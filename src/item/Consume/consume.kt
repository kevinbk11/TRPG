package item.Consume
import MainSystem.*
import item.normalItem.Item
import item.normalItem.Message
import player.Player

abstract class  Heal(var Value:Int): Item
{
    override var Type="Heal"
    override var Count=0
}

object RedWater : Heal(50)
{
    override var Count: Int=0
    override var Name="紅水"
    override fun use(P: Player)
    {
        P.HP+=this.Value
        this.Count-=1
        Message(P, this)
    }
    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復:${Value}血量")
    }
}
object BlueWater: Heal(50)
{
    override var Count: Int=0
    override var Name="藍水"
    override fun use(P: Player)
    {
        P.HP+=Value*2
        this.Count-=1
        Message(P, this)
    }

    override fun GetInfo()
    {
        println("${this.Name}   使用後恢復:${Value*2}血量")
    }
}
