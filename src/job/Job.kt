package job

import item.normalItem.*
import item.weapon.Weapon
import map.MAP
import map.MAP_1
import player.Player
import java.util.*


class magic(var n:String): Player
{
    override var name=n
    override var job="Magic"
    override var HP=500
    override var MP=500
    override var hand: Weapon? = Empty()
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()
    override var MapNumber: Int=0
    init {
        for(iti in 1..20)
        {
            bag.add(Empty())
        }
    }
    override fun levelup() {
        HP+=50
        LV+=1
    }
}

class fighter(var n:String): Player
{
    override var name=n
    override var job="Fighter"
    override var HP=1000
    override var MP=200
    override var hand: Weapon? = Empty()
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()
    override var MapNumber: Int=0
    init {
        for(iti in 1..20)
        {
            bag.add(Empty())
        }
    }
    override fun levelup() {
        println("LEVEL UP!")
        HP+=100
        LV+=1
    }
}

class n(var n:String): Player
{
    override var name=n
    override var job="None"
    override var HP=0
    override var MP=0
    override var hand: Weapon? = Empty()
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()
    override var MapNumber: Int=0
}