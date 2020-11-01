package item

import item.Consume.*
import item.normalItem.*
import player.Player
import java.io.Serializable
import item.PlayerItem.cloth.Com.*
import item.PlayerItem.cloth.Fighter.*
import item.PlayerItem.cloth.Magic.*
import item.PlayerItem.weapon.Fighter.*
import item.PlayerItem.weapon.Magic.*
import item.PlayerItem.pants.Fighter.*
import item.PlayerItem.pants.Magic.*
import item.PlayerItem.pants.Com.*
import item.PlayerItem.pants.EmptyPants
import item.PlayerItem.weapon.EmptyWeapon
import item.PlayerItem.cloth.EmptyCloth
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
abstract class Cloth(var def:Int,var needLV:Int):Item
{
    override var Type="Cloth"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${def},需要等級:${needLV}")
    }
}
abstract class Pants(var def:Int,var needLV:Int):Item
{
    override var Type="Pants"
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${def},需要等級:${needLV}")
    }
}

class empty():Item
{
    override var Name="none"
    override var Type="none"
    override var Count=0
}
var Empty = empty()
//道具寫好後在下方實體化物件
//----------------消耗品
var BlueWater= BlueWater()
var RedWater = RedWater()
//----------------雜物
var BrokenStone=BrokenStone()
var TurnTurnBirdFeather = TurnTurnBirdFeather()
//----------------武器
var AdminFist = AdminFist()
var EmptyWeapon= EmptyWeapon()
var ShortSword= ShortSword()
var WoodSword = WoodSword()
//----------------上衣
var EmptyCloth= EmptyCloth()
var LeatherArmor= LeatherArmor()
//----------------褲子
var EmptyPants= EmptyPants()
var LeatherPants= LeatherPants()
//----------------任務道具
var QuestItem1=QuestItem1()