package job

import item.Item
import item.*
import item.PlayerItem.cloth.Com.LeatherArmor
import item.PlayerItem.pants.Com.LeatherPants
import item.PlayerItem.weapon.Fighter.WoodSword
import map.MAP
import map.MAP_1
import player.Player
import quest.*
import skill.*
import skill.CommonSkills.*
import skill.FighterSkills.HitHard
import java.util.*
import kotlin.math.pow

class Fighter(var n:String): Player
{
    override var name=n
    override var job="Fighter"
    override var HP=500
    override var MP=100
    override var FullHP=500
    override var FullMP=100
    override var hand: Weapon? = WoodSword
    override var cloth:Cloth?= LeatherArmor
    override var pants:Pants?= LeatherPants
    override var def=0
    override var LV=1
    override var bag:LinkedList<Item> = LinkedList()
    override var map: MAP?= MAP_1
    override var Damage=0
    override var MapNumber: Int=0
    override var SkillList= LinkedList<Skill>()
    override var FullEXP: Double =150+(2.0).pow(LV*0.35)
    override var EXP: Double =0.0
    override var QuestList= LinkedList<Quest>()
    override var Money=0
    var BasicStr: Double=0.0
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
        this.LearningSkill(HitHard)
    }
    override fun levelup() {
        println("LEVEL UP!")
        FullHP+=180
        FullMP+=50
        LV+=1
        EXP-=FullEXP
        FullEXP=150+(2.0).pow(LV*0.35)
        HP=FullHP
        MP=FullMP
        BasicStr=LV*2.5
        Damage=(BasicStr+hand!!.Damage).toInt()
    }
    override fun PlayerUpdata()
    {
        this.Damage=(this.BasicStr+this.hand!!.Damage).toInt()
        this.def=(this.cloth!!.def+this.pants!!.def).toInt()
    }
}