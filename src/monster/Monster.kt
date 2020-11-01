package monster
import item.*
import item.Consume.*
import item.normalItem.*
import player.Player
import java.io.Serializable
import kotlin.random.Random
interface Monster_Skill:Serializable
{
    var Name:String
    fun use(P:Player){}
}

interface Monster:Serializable
{
    var Name:String
    var FullHP:Int
    var LV:Int
    var HP:Int
    var Damage:Int
    var Exp:Int
    var HaveQuestItem:Boolean
    var Money:Int
    fun info(){}
    fun drop(): Item?
    {
        return null
    }
    fun <T> ItemCount(I:T):Int
    {
        return 0
    }
    fun Attack(P:Player)
    {

    }
    fun use(s:Monster_Skill,P:Player)
    {
       s.use(P)
    }
}
object EmptyMonster:Monster
{
    override var Exp: Int = 0
    override var Name = "null"
    override var HP = 0
    override var FullHP = 0
    override var Damage = 0
    override var LV = 0
    override var Money=0
    override var HaveQuestItem=false
}


