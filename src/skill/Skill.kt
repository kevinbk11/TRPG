package skill

import monster.Monster
import player.Player
import job.*
import java.io.Serializable
import kotlin.random.Random

interface Skill:Serializable {
    var name:String
    fun<T>use(M: Monster?,P:T){}
}

object NomralAttack:Skill
{
    override var name:String = "普通攻擊"
    override fun <T>use(M: Monster?,P:T)
    {
        when(P)
        {
            is magic->
            {
                var dam=(P.Damage*0.6*Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
            is fighter->
            {
                var dam = (P.Damage*1.1*Random.nextDouble(0.95,1.05)).toInt()
                println("\n你造成了${dam}點傷害\n")
                M!!.HP-=dam
            }
        }
    }
}

object FighterSkill_1:Skill
{
    override var name:String="沉重打擊"
    override fun <T>use(M:Monster?,P:T)
    {
        when(P)
        {
            is fighter->
            {
                if(P.MP<20)
                {
                    println("魔力不足!")
                }
                else
                {
                    P.MP-=20
                    var dam = (P.Damage*1.5*Random.nextDouble(0.85,1.1)).toInt()
                    println("\n你使用了${this.name}造成了${dam}點傷害\n")
                    M!!.HP-=dam
                }

            }
        }
    }
}

object none:Skill
{
    override var name:String="none"
}