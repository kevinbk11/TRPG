package skill

import monster.Monster
import skill.CommonSkills.*
import skill.FighterSkills.HitHard
import java.io.Serializable

abstract class Skill:Serializable {
    open var name=""
    open fun<T>use(M: Monster?,P:T){}
}

object none:Skill()
{
    override var name:String="none"
}
