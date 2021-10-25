package classes

abstract class LittleGoods():Product() {
}

class Stool():LittleGoods() {
    override var name="stool"
    override var weight=5
    override var timeToMove=1
}

class PC():LittleGoods() {
    override var name="PC"
    override var weight=10
    override var timeToMove=1
}

class Violin():LittleGoods() {
    override var name="violin"
    override var weight=6
    override var timeToMove=1
}