package monster.monsterSkills

import monster.Monster_Skill
import player.Player
import kotlin.random.Random

object BirdAttack: Monster_Skill
{
    override var Name:String="撞擊"
    override fun use(P: Player)
    {
        val rd= Random.nextInt(8,12)
        P.HP-=rd
        println("你受到了${rd}點傷害!")
    }
}

