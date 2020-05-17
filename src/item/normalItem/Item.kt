package item
import player.Player
import java.io.Serializable
import weapon.*
import java.lang.reflect.GenericArrayType

fun <T>Message(P:Player,I:T)
{
    when(I)
    {
        is Heal->println("你使用了${I.Name}\n目前HP=${P.HP}\n目前MP=${P.MP}")
        is Weapon ->println("穿上了${I.Name}")
        is NormalItem->println("u001B31;1m該道具無法使用.")
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
abstract class NormalItem():Item
{
    override var Type="Item"
    override var Count=0
}


abstract class  Heal(var Value:Int):Item
{
    override var Type="Heal"
    override var Count=0
}

data class RedWater (override var Count: Int=0):Heal(50)
{
    override var Name="紅水"
    override fun use(P:Player)
    {
        P.HP+=this.Value
        this.Count-=1
        Message(P,this)
    }
    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復:${Value}血量")
    }
}
data class BlueWater(override var Count: Int=0):Heal(50)
{
    override var Name="藍水"
    override fun use(P:Player)
    {
        P.HP+=Value*2
        this.Count-=1
        Message(P,this)
    }

    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復:${Value*2}血量")
    }
}

data class Item_1(override var Count: Int=0):NormalItem()
{
    override var Name: String="轉轉鳥的羽毛"
    override fun use(P: Player)
    {
        Message(P,this)
    }
    override fun GetInfo()
    {
        println("轉轉鳥的羽毛,有著漂亮的青藍色")
    }
}
class Empty() :Item
{
    override var Name="none"
    override var Type="none"
    override var Count=0
}