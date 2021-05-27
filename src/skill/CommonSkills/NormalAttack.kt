package skill.CommonSkills

import job.Fighter
import job.Magic
import monster.Monster
import skill.Skill
import kotlin.random.Random

object NormalAttack: Skill()
{
    override var name:String = "普通攻擊"
    override fun <T>use(M: Monster?, P:T)
    {
        when(P)
        {
            is Magic ->
            {
                var dam=(P.Damage*0.6* Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
            is Fighter ->
            {
                var dam = (P.Damage*1.1* Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
        }
    }
}