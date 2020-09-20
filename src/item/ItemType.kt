package item

import item.Consume.*
import item.normalItem.*
import item.weapon.*
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
interface Item:Serializable
{
    var Name:String
    var Type:String
    var Count:Int
    fun GetInfo(){}
}

abstract class NormalItem(): Item
{
    override var Type="Item"
}

abstract class  Heal(var HealHP:Int,var HealMP:Int): Item
{
    override var Type="Heal"
    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復${HealHP}血量和${HealMP}魔力")
    }
}

abstract class Weapon (var Damage:Int,var needLV:Int): Item
{
    override var Type="Weapon"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${Damage},需要等級:${needLV}")
    }
}
//道具寫好後在下方實體化物件
var BlueWater= BlueWater()
var RedWater = RedWater()
var BrokenStone=BrokenStone()
var TurnTurnBirdFeather = TurnTurnBirdFeather()
var AdminFist = AdminFist()
var Empty=Empty()
var ShortSword=ShortSword()
var WoodSword = WoodSword()