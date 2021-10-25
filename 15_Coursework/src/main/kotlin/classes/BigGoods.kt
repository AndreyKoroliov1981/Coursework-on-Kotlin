package classes

abstract class BigGoods():Product() {
}

class Sofa():BigGoods() {
    override var name="sofa"
    override var weight=100
    override var timeToMove=3
}

class Fridge():BigGoods() {
    override var name="fridge"
    override var weight=80
    override var timeToMove=3
}

class Piano():BigGoods() {
    override var name="piano"
    override var weight=150
    override var timeToMove=3
}