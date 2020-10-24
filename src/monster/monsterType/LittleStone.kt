package monster.monsterType

import item.*
import item.normalItem.*
import monster.Monster
import monster.monsterSkills.*
import player.Player
import kotlin.random.Random

object LittleStone : Monster
{
    override var Exp:Int=35
    override var Name="小石怪"
    override var HP=135
    override var FullHP=135
    override var Damage=12
    override var LV=2
    override var HaveQuestItem=false
    val I1= BrokenStone
    val I2= BlueWater

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
            is BrokenStone ->
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
                this.use(RockAttack,P)
            }
        }
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }

}