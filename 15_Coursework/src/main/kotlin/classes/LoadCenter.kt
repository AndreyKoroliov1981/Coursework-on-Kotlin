package classes

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class LoadCenter(numLoadPort: Int) {
    var loadPorts = mutableListOf<LoadPort>() // список портов загрузки
    val myNumLoadPort = numLoadPort //количество портов разгрузки
    var endGeneratedTruck = false //флаг о том, что больше новые грузовики не появятся
    var countTruckLoad = 0


    init {
        // инициализация портов загрузки
        for (i in 1..myNumLoadPort) loadPorts.add(LoadPort())
    }

    //функция заполнения портов разгрузки
    suspend fun loadTruckToLoadPort() {
        runBlocking {
            while ((endGeneratedTruck == false) || (Warehouse.wareHouseIsEmpty() == false)) {
                var numPort = -1
                for (i in 0..myNumLoadPort - 1) {
                    if (loadPorts[i].isEmpty) numPort = i
                }
                //если есть свободный порт, то отправляем truck на загрузку
                if (numPort != -1) {
                    launch { loadPorts[numPort].loadTruck() }
                    countTruckLoad++
                }
                delay(1000) // устанавливаем задержку в 1 мин.
            }
        }
    }


}

class LoadPort() {
    var isEmpty = true
    suspend fun loadTruck() {
        isEmpty = false
        val tr = GeneratedTruck().generatedEmptyTruck() //генерируем пустой грузовик
        var pr: Product
        val mutex = Mutex()
        println("Грузовик с номером ${tr.numberTrack} и грузоподъемностью ${tr.liftingCapacity} поставлен в порт загрузки")
        val currentNameProduct =
            Warehouse.returnRandomProduct() //получаем имя случайного продукта, который имеется на складе
        var weightProduct = 0
        when (currentNameProduct) {
            "bread" -> weightProduct = Bread().weight
            "milk" -> weightProduct = Milk().weight
            "potato" -> weightProduct = Potato().weight
            "stool" -> weightProduct = Stool().weight
            "PC" -> weightProduct = PC().weight
            "violin" -> weightProduct = Violin().weight
            "armchair" -> weightProduct = Armchair().weight
            "TV" -> weightProduct = TV().weight
            "tube" -> weightProduct = Tube().weight
            "sofa" -> weightProduct = Sofa().weight
            "fridge" -> weightProduct = Fridge().weight
            "piano" -> weightProduct = Piano().weight
        }

        while ((!checkForEmpty(currentNameProduct)) && (tr.currentCapacity <= tr.liftingCapacity - weightProduct)) {
            mutex.withLock { //Блокируем одновременный доступ к складу
                pr = Warehouse.pickUpProduct(currentNameProduct) //берем продукт со склада
            }
            tr.products.push(pr) //загружаем его в грузовик
            tr.currentCapacity += pr.weight
            delay((pr.timeToMove * 1000).toLong())
        }
        println("Загружена машина с номером ${tr.numberTrack}, товаром $currentNameProduct и весом ${tr.currentCapacity}")
        isEmpty = true
    }
}

fun checkForEmpty(nameProduct: String): Boolean {
    return when (nameProduct) {
        "bread" -> Warehouse.breadWare.isEmpty()
        "milk" -> Warehouse.milkWare.isEmpty()
        "potato" -> Warehouse.potatoWare.isEmpty()
        "stool" -> Warehouse.stoolWare.isEmpty()
        "PC" -> Warehouse.pCWare.isEmpty()
        "violin" -> Warehouse.violinWare.isEmpty()
        "armchair" -> Warehouse.armchairWare.isEmpty()
        "TV" -> Warehouse.tVWare.isEmpty()
        "tube" -> Warehouse.tubeWare.isEmpty()
        "sofa" -> Warehouse.sofaWare.isEmpty()
        "fridge" -> Warehouse.fridgeWare.isEmpty()
        else -> Warehouse.pianoWare.isEmpty() //piano
    }
}
