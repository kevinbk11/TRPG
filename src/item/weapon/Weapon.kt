package item.weapon
import item.normalItem.Item
import item.normalItem.Message
import player.Player

abstract class Weapon (var Damage:Int,var needLV:Int): Item
{
    open var CD:Double=0.0
    override var Type="Weapon"
    override var Count=0
    override fun GetInfo()
    {
        println("${this.Name}   傷害:${Damage} 冷卻:${this.CD}s 需要等級:${needLV}")
    }
    override fun use(P: Player)
    {
        P.put(P.hand,1)
        P.hand=this
        this.Count-=1
        Message(P, this)
    }
}

data class WoodSword(override var Count: Int=0) :Weapon(30,0)
{
    override var CD=1.0
    override var Name: String="木劍"
}

data class ShortSword(override var Count: Int=0) :Weapon(16,0)
{
    override var CD=0.5
    override var Name: String="短刀"

}