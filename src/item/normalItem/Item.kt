package item.normalItem
import MainSystem.*
import item.Consume.Heal
import item.weapon.Weapon
import player.Player
import java.io.Serializable

fun <T>Message(P:Player,I:T)
{
    when(I)
    {
        is Heal ->println("你使用了${I.Name}\n目前HP=${P.HP}\n目前MP=${P.MP}")
        is Weapon ->println("穿上了${I.Name}")
        is NormalItem ->println("\u001b[38;5;1m該道具無法使用."+RESET)
    }
}


interface Item:Serializable
{
    var Name:String
    var Type:String
    var Count:Int
    fun GetInfo(){}
    fun use(P:Player){}
}

abstract class NormalItem(): Item
{
    override var Type="Item"
    override var Count=0
}


data class Item_1(override var Count: Int=0): NormalItem()
{
    override var Name: String="轉轉鳥的羽毛"
    override fun use(P: Player)
    {
        Message(P, this)
    }
    override fun GetInfo()
    {
        println("轉轉鳥的羽毛,有著漂亮的青藍色")
    }
}

data class Item_2(override var Count: Int=0): NormalItem()
{
    override var Name: String="碎石"
    override fun use(P: Player)
    {
        Message(P, this)
    }
    override fun GetInfo()
    {
        println("從小石怪身上掉落的碎石,很堅硬")
    }
}

class Empty() : Item
{
    override var Name="none"
    override var Type="none"
    override var Count=0
}