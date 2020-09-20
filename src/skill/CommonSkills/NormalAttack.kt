package skill.CommonSkills

import job.fighter
import job.magic
import monster.Monster
import skill.Skill
import kotlin.random.Random

class NormalAttack: Skill
{
    override var name:String = "普通攻擊"
    override fun <T>use(M: Monster?, P:T)
    {
        when(P)
        {
            is magic ->
            {
                var dam=(P.Damage*0.6* Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
            is fighter ->
            {
                var dam = (P.Damage*1.1* Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
        }
    }
}