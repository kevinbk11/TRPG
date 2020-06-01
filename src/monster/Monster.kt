package monster
import MainSystem.*
import item.Consume.*
import item.normalItem.*
import item.weapon.*
import player.Player
import java.io.Serializable
import java.util.*
import kotlin.random.Random

interface Monster_Skill:Serializable
{
    var Name:String
    fun use(M:Monster,P:Player){}
}

class BirdAttack():Monster_Skill
{
    override var Name:String="撞擊"
    override fun use(M:Monster,P:Player)
    {
        val rd= Random.nextInt(8,12)
        P.HP-=rd
        println("你受到了${rd}點傷害!")
    }
}

interface Monster:Serializable
{
    var Name:String
    var FullHP:Int
    var LV:Int
    var HP:Int
    var Damage:Int
    var Exp:Int
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
}

data class Monster_1(override var Exp:Int=30):Monster
{
    override var Name="轉轉鳥"
    override var HP=90
    override var FullHP=90
    override var Damage=9
    override var LV=1

    val I1= Item_1()
    val I2= RedWater()
    override fun drop(): Item?
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..80->return I1 //毛
            in 81..100->return I2//水
            else->return null
        }
    }
    override fun <T> ItemCount(I:T):Int
    {
        val rd= Random.nextInt(0,100)
        when(I)
        {
            is Item_1->
            {
                when (rd)
                {
                    in 0..20 -> return 2
                    in 21..70 -> return 1
                    else -> return 0
                }
            }
        }
        return 0
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }
    override fun Attack(P: Player)
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..2->
            {
                //2
            }
            in 3..100->
            {
                BirdAttack().use(this,P)
            }
        }
    }
}

data class Monster_2(override var Exp:Int=35):Monster
{
    override var Name="小石怪"
    override var HP=135
    override var FullHP=135
    override var Damage=12
    override var LV=2
    val I1= Item_2()
    val I2= BlueWater()

    override fun drop(): Item?
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..80->return I1 //九陶
            in 81..100->return I2//水
            else->return null
        }
    }
    override fun <T> ItemCount(I:T):Int
    {
        val rd= Random.nextInt(0,100)
        when(I)
        {
            is Item_1->
            {
                when(rd)
                {
                    in 0..20->return 2
                    in 21..70->return 1
                    else->return 0
                }
            }
        }
        return 0
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }

}