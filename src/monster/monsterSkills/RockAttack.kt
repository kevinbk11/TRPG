package monster.monsterSkills

import monster.Monster_Skill
import player.Player
import kotlin.random.Random

object RockAttack: Monster_Skill
{
    override var Name:String="滾石"
    override fun use(P: Player)
    {
        val rd= Random.nextInt(5,15)
        P.HP-=rd
        println("你受到了${rd}點傷害!")
    }
}