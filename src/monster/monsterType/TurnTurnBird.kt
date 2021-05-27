package monster.monsterType

import item.*
import item.HealItem.RedWater
import item.normalItem.*
import monster.Monster
import monster.monsterSkills.*
import player.Player
import javax.print.attribute.HashPrintRequestAttributeSet
import kotlin.random.Random

object TurnTurnBird: Monster {
    override var Exp: Int = 30
    override var Name = "轉轉鳥"
    override var HP = 90
    override var FullHP = 90
    override var Damage = 9
    override var LV = 1
    override var Money=7
    override var HaveQuestItem=false
    val I1 = TurnTurnBirdFeather()
    val I2 = RedWater()
    val I3=QuestItem1
    override fun drop(): Item? {
        val rd = Random.nextInt(0, 100)
        when (rd) {
            in 0..65 -> return I1 //毛
            in 66..90 -> return I2//水
            in 91..100-> {
                if (HaveQuestItem)
                {
                    this.HaveQuestItem=false
                    return I3
                }
                return I2
            }//錢包

            else -> return null
        }
    }

    override fun <T> ItemCount(I: T): Int {
        val rd = Random.nextInt(0, 100)
        when (I) {
            is TurnTurnBirdFeather -> {
                when (rd) {
                    in 0..20 -> return 2
                    in 21..70 -> return 1
                    else -> return 0
                }
            }
            is RedWater -> {
                when(rd){
                    in 0..70 -> return 1
                    else -> return 0
                }
            }
            is QuestItem1 -> {
                return 1
            }
        }
        return 0
    }

    override fun info() {
        println("Name=${Name},HP=${HP}")
    }

    override fun Attack(P: Player) {
        val rd = Random.nextInt(0, 100)
        when (rd) {
            in 0..2 -> {
                //2
            }
            in 3..100 -> {
                this.use(BirdAttack, P)
            }
        }
    }
}
