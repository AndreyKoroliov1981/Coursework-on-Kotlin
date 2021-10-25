package classes

import java.util.*

/* класс синглтон СКЛАД
Для каждого товара делаем свой стек
В стек будем разгружать товар и из стека брать на загрузку.
*/
object Warehouse {
    var breadWare = Stack<Bread>()
    var countBreadWare = 0
    var milkWare = Stack<Milk>()
    var countMilkWare = 0
    var potatoWare = Stack<Potato>()
    var countPotatoWare = 0
    var stoolWare = Stack<Stool>()
    var countStoolWare = 0
    var pCWare = Stack<PC>()
    var countPCWare = 0
    var violinWare = Stack<Violin>()
    var countViolinWare = 0
    var armchairWare = Stack<Armchair>()
    var countArmchairWare = 0
    var tVWare = Stack<TV>()
    var countTVWare = 0
    var tubeWare = Stack<Tube>()
    var countTubeWare = 0
    var sofaWare = Stack<Sofa>()
    var countSofaWare = 0
    var fridgeWare = Stack<Fridge>()
    var countFridgeWare = 0
    var pianoWare = Stack<Piano>()
    var countPianoWare = 0

    fun addProduct(pr: Product) {
        when (pr.name) {
            "bread" -> {
                breadWare.push(pr as Bread); countBreadWare++
            }
            "milk" -> {
                milkWare.push(pr as Milk); countMilkWare++
            }
            "potato" -> {
                potatoWare.push(pr as Potato);countPotatoWare++
            }
            "stool" -> {
                stoolWare.push(pr as Stool);countStoolWare++
            }
            "PC" -> {
                pCWare.push(pr as PC); countPCWare++
            }
            "violin" -> {
                violinWare.push(pr as Violin); countViolinWare++
            }
            "armchair" -> {
                armchairWare.push(pr as Armchair); countArmchairWare++
            }
            "TV" -> {
                tVWare.push(pr as TV); countTVWare++
            }
            "tube" -> {
                tubeWare.push(pr as Tube); countTubeWare++
            }
            "sofa" -> {
                sofaWare.push(pr as Sofa); countSofaWare++
            }
            "fridge" -> {
                fridgeWare.push(pr as Fridge); countFridgeWare++
            }
            "piano" -> {
                pianoWare.push(pr as Piano); countPianoWare++
            }
        }
    }

    fun pickUpProduct(t: String): Product {
        when (t) {
            "bread" -> {
                countBreadWare--
                return breadWare.pop() as Product
            }
            "milk" -> {
                countMilkWare--
                return milkWare.pop() as Product
            }
            "potato" -> {
                countPotatoWare--
                return potatoWare.pop() as Product
            }
            "stool" -> {
                countStoolWare--
                return stoolWare.pop() as Product
            }
            "PC" -> {
                countPCWare--
                return pCWare.pop() as Product
            }
            "violin" -> {
                countViolinWare--
                return violinWare.pop() as Product
            }
            "armchair" -> {
                countArmchairWare--
                return armchairWare.pop() as Product
            }
            "TV" -> {
                countTVWare--
                return tVWare.pop() as Product
            }
            "tube" -> {
                countTubeWare--
                return tubeWare.pop() as Product
            }
            "sofa" -> {
                countSofaWare--
                return sofaWare.pop() as Product
            }
            "fridge" -> {
                countFridgeWare--
                return fridgeWare.pop() as Product
            }
            else -> {  // "piano"
                countPianoWare--
                return pianoWare.pop() as Product
            }
        }
    }

    fun wareHouseIsEmpty(): Boolean {
        if (
            (countBreadWare == 0) &&
            (countMilkWare == 0) &&
            (countPotatoWare == 0) &&
            (countStoolWare == 0) &&
            (countPCWare == 0) &&
            (countViolinWare == 0) &&
            (countArmchairWare == 0) &&
            (countTVWare == 0) &&
            (countTubeWare == 0) &&
            (countSofaWare == 0) &&
            (countFridgeWare == 0) &&
            (countPianoWare == 0)
        ) return true
        return false
    }

    fun returnRandomProduct(): String { // вызывать только если wareHouseIsEmpty()=false
        val t = mutableListOf<String>() // создаем список классов склад которых не пустой
        if (!breadWare.isEmpty()) t.add("bread")
        if (!milkWare.isEmpty()) t.add("milk")
        if (!potatoWare.isEmpty()) t.add("potato")
        if (!stoolWare.isEmpty()) t.add("stool")
        if (!pCWare.isEmpty()) t.add("PC")
        if (!violinWare.isEmpty()) t.add("violin")
        if (!armchairWare.isEmpty()) t.add("armchair")
        if (!tVWare.isEmpty()) t.add("TV")
        if (!tubeWare.isEmpty()) t.add("tube")
        if (!sofaWare.isEmpty()) t.add("sofa")
        if (!fridgeWare.isEmpty()) t.add("fridge")
        if (!pianoWare.isEmpty()) t.add("piano")
        val tSize = t.size

        val i = (0..tSize - 1).random()

        return t[i] //возвращаем имя случайного продукта склад которого не пустой
    }

}