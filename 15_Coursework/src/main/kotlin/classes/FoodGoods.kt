package classes

abstract class FoodGoods():Product() {

}

class Bread():FoodGoods() {
    override var name="bread"
    override var weight=10
    override var timeToMove=1
}

class Milk():FoodGoods() {
    override var name="milk"
    override var weight=20
    override var timeToMove=2
}

class Potato():FoodGoods() {
    override var name="potato"
    override var weight=50
    override var timeToMove=3
}