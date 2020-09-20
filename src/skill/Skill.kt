package skill

import monster.Monster
import skill.CommonSkills.*
import skill.FighterSkills.HitHard
import java.io.Serializable

interface Skill:Serializable {
    var name:String
    fun<T>use(M: Monster?,P:T){}
}

object none:Skill
{
    override var name:String="none"
}
//技能寫好後在下方實體化物件
var NormalAttack= NormalAttack()
var HitHard = HitHard()