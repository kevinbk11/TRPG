package item

import player.Player
import java.io.Serializable

fun <T>Message(P: Player, I:T)
{
    when(I)
    {
        is Heal ->println("你使用了${I.Name}\n目前HP=${P.HP}\n目前MP=${P.MP}")
        is Weapon ->println("穿上了${I.Name}")
        is NormalItem ->println("該道具無法使用.")
    }
}
abstract class Item():Serializable
{
    open lateinit var Name:String
    open lateinit var Type:String
    open var Count:Int=0
    open fun GetInfo(){}
}

abstract class NormalItem(): Item()
{
    override var Type="Item"
}

abstract class Heal(var HealHP:Int,var HealMP:Int): Item()
{
    override var Type="Heal"
    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復${HealHP}血量和${HealMP}魔力")
    }
}

abstract class Weapon (var Damage:Int,var needLV:Int): Item()
{
    override var Type="Weapon"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${Damage},需要等級:${needLV}")
    }
}
abstract class Cloth(var def:Int,var needLV:Int):Item()
{
    override var Type="Cloth"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${def},需要等級:${needLV}")
    }
}
abstract class Pants(var def:Int,var needLV:Int):Item()
{
    override var Type="Pants"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${def},需要等級:${needLV}")
    }
}

object empty:Item()
{
    override var Name="none"
    override var Type="none"
    override var Count=0
}