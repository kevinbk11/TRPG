package item.weapon
import MainSystem.*
import item.normalItem.Item
import item.normalItem.Message
import player.Player

abstract class Weapon (var Damage:Int,var needLV:Int): Item
{
    override var Type="Weapon"
    override var Count=0
}

data class WoodSword(override var Count: Int=0) :Weapon(30,0)
{
    override var Name: String="木劍"
    override fun use(P: Player)
    {
        P.hand=this
        this.Count-=1
        Message(P, this)
    }
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${Damage}  需要等級:${needLV}")
    }
}