package skill.FighterSkills

import job.fighter
import monster.Monster
import skill.Skill
import kotlin.random.Random

class HitHard: Skill
{
    override var name:String="沉重打擊"
    override fun <T>use(M: Monster?, P:T)
    {
        when(P)
        {
            is fighter ->
            {
                if(P.MP<20)
                {
                    println("魔力不足!")
                }
                else
                {
                    P.MP-=20
                    var dam = (P.Damage*1.5* Random.nextDouble(0.85,1.1)).toInt()
                    println("\n你使用了${this.name}造成了${dam}點傷害\n")
                    M!!.HP-=dam
                }

            }
        }
    }
}