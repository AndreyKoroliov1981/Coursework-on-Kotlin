package classes

import java.text.SimpleDateFormat
import java.util.*

class GeneratedTruck {
    private var truckFull = false
    fun generatedTruck(): Truck {
        var tr: Truck
        truckFull = false

        var n = (1..3).random() //создание случайного типа грузовика
        tr = when (n) {
            2 -> TruckLittleCapacity()
            3 -> TruckMiddleCapacity()
            else -> TruckBigCapacity()
        }

        n = (1..2).random() //выбираем продукты или нет
        when (n) {
            2 -> loadFood(tr) //грузим в машину продукты питания
            else -> loadNonFood(tr) // грузим в машину не пищевые продукты
        }

        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentTime = sdf.format(Date())
        tr.numberTrack = currentTime // присваеваем грузовику номер, соответствующий текущему времени (для удобства)
        return tr
    }

    private fun loadFood(tr: Truck) {
        var n: Int
        var foodList = mutableListOf<Product>() //заполняем List продуктами
        var freePlace = 0
        foodList.add(Bread()) //будем из него удалять продукты если их
        foodList.add(Milk())  //невозможно будет погрузить в Truck
        foodList.add(Potato())

        while (!truckFull) {
            freePlace = tr.liftingCapacity - tr.currentCapacity
            //если вес товара превышает оставшуюся грузоподъемность,
            //то удаляем его из списка товаров к погрузке
            for (i in foodList.size downTo 1) {
                if (freePlace < foodList[i - 1].weight) foodList.removeAt(i - 1)
            }
            if (foodList.size == 0) truckFull = true

            if (!truckFull) {
                n = (0..foodList.size - 1).random() //выбираем случайный продукт
                tr.products.push(foodList[n])
                tr.currentCapacity += foodList[n].weight
            }
        }
    }

    private fun loadNonFood(tr: Truck) {
        var n: Int
        var nonFoodList = mutableListOf<Product>() //заполняем List продуктами
        var freePlace = 0
        nonFoodList.add(Stool()) //будем из него удалять продукты если их
        nonFoodList.add(PC())  //невозможно будет погрузить в Truck
        nonFoodList.add(Violin())
        nonFoodList.add(Armchair())
        nonFoodList.add(TV())
        nonFoodList.add(Tube())
        nonFoodList.add(Sofa())
        nonFoodList.add(Fridge())
        nonFoodList.add(Piano())

        while (!truckFull) {
            freePlace = tr.liftingCapacity - tr.currentCapacity
            //если вес товара превышает оставшуюся грузоподъемность,
            //то удаляем его из списка товаров к погрузке
            for (i in nonFoodList.size downTo 1) {
                if (freePlace < nonFoodList[i - 1].weight) nonFoodList.removeAt(i - 1)
            }
            if (nonFoodList.size == 0) truckFull = true

            if (!truckFull) {
                n = (0..nonFoodList.size - 1).random() //выбираем случайный продукт
                tr.products.push(nonFoodList[n])
                tr.currentCapacity += nonFoodList[n].weight
            }
        }

    }

    fun generatedEmptyTruck(): Truck {
        val tr: Truck
        val n = (1..2).random() //создание случайного типа грузовика, без типа с максимальной грузоподъемностью
        tr = when (n) {
            2 -> TruckLittleCapacity()
            else -> TruckMiddleCapacity()
        }
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentTime = sdf.format(Date())
        // присваеваем грузовику номер, соответствующий текущему времени и литерой Е (для удобства)
        tr.numberTrack = "E$currentTime"
        return tr
    }

}