package monster.monsterType

import item.*
import item.normalItem.*
import monster.Monster
import monster.monsterSkills.*
import player.Player
import kotlin.random.Random

object TurnTurnBird: Monster {
    override var Exp: Int = 30
    override var Name = "轉轉鳥"
    override var HP = 90
    override var FullHP = 90
    override var Damage = 9
    override var LV = 1

    val I1 = TurnTurnBirdFeather
    val I2 = RedWater
    override fun drop(): Item? {
        val rd = Random.nextInt(0, 100)
        when (rd) {
            in 0..80 -> return I1 //毛
            in 81..100 -> return I2//水
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
