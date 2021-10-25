package classes

abstract class MiddleGoods():Product() {
}

class Armchair():MiddleGoods() {
    override var name="armchair"
    override var weight=20
    override var timeToMove=2
}

class TV():MiddleGoods() {
    override var name="TV"
    override var weight=30
    override var timeToMove=2
}


class Tube():MiddleGoods() {
    override var name="tube"
    override var weight=15
    override var timeToMove=2
}