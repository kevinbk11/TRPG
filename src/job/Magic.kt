package job

import item.Item
import item.*
import item.*
import item.PlayerItem.cloth.EmptyCloth
import item.PlayerItem.pants.EmptyPants
import item.PlayerItem.weapon.EmptyWeapon
import map.MAP
import map.MAP_1
import player.Player
import quest.NullQuest
import quest.Quest
import skill.*
import skill.CommonSkills.NormalAttack
import skill.Skill
import skill.none
import java.util.*
import kotlin.math.pow

class Magic(var n:String): Player
{
    override var name=n
    override var job="Magic"
    override var HP=200
    override var MP=300
    override var FullHP=200
    override var FullMP=300
    override var hand: Weapon? = EmptyWeapon
    override var cloth:Cloth?= EmptyCloth
    override var pants:Pants?= EmptyPants
    override var def =0
    override var LV=1
    override var bag:LinkedList<Item> = LinkedList()
    override var map: MAP?= MAP_1
    override var Money=0
    override var FullEXP: Double =150+(2.0).pow(0.35)
    override var EXP: Double =0.0
    override var Damage=0
    override var MapNumber: Int=0
    override var SkillList= LinkedList<Skill>()
    override var QuestList= LinkedList<Quest>()
    init {

        for(iti in 1..20)
        {
            bag.add(empty)
        }
        for(x in 1..20)
        {
            SkillList.add(none)
        }
        for(q in 1..20)
        {
            QuestList.add(NullQuest)
        }
        this.LearningSkill(NormalAttack)
    }
    override fun levelup() {
        println("LEVEL UP!")
        FullHP+=100
        FullMP+=150
        LV+=1
    }
}