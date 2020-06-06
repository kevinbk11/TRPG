package job

import item.normalItem.*
import item.weapon.Weapon
import item.weapon.WoodSword
import map.MAP
import map.MAP_1
import player.Player
import quest.NullQuest
import quest.Quest
import skill.NomralAttack
import skill.*
import java.util.*
import kotlin.math.pow


class magic(var n:String): Player
{
    override var name=n
    override var job="Magic"
    override var HP=200
    override var MP=300
    override var FullHP=200
    override var FullMP=300
    override var hand: Weapon? = Empty()
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()

    override var FullEXP: Double =150+(2.0).pow(0.35)
    override var EXP: Double =0.0
    var INT:Int=0
    override var Damage=0
    override var MapNumber: Int=0
    override var SkillList=LinkedList<Skill>()
    override var QuestList=LinkedList<Quest>()
    init {

        for(iti in 1..20)
        {
            bag.add(Empty())
        }
        for(x in 1..20)
        {
            SkillList.add(none())
        }
        for(q in 1..20)
        {
            QuestList.add(NullQuest())
        }
        this.LearningSkill(NomralAttack())
    }
    override fun levelup() {
        println("LEVEL UP!")
        FullHP+=100
        FullMP+=150
        LV+=1
    }
}

class fighter(var n:String): Player
{
    override var name=n
    override var job="Fighter"
    override var HP=500
    override var MP=100
    override var FullHP=500
    override var FullMP=100
    override var hand: Weapon? = WoodSword()
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()
    override var Damage=0
    override var MapNumber: Int=0
    override var SkillList=LinkedList<Skill>()
    override var FullEXP: Double =150+(2.0).pow(LV*0.35)
    override var EXP: Double =0.0
    override var QuestList=LinkedList<Quest>()
    var BasicStr: Double=0.0
    init {
        for(iti in 1..20)
        {
            bag.add(Empty())
        }
        for(x in 1..20)
        {
            SkillList.add(none())
        }
        for(q in 1..20)
        {
            QuestList.add(NullQuest())
        }
        this.LearningSkill(NomralAttack())
        this.LearningSkill(FighterSkill_1())
    }
    override fun levelup() {
        println("LEVEL UP!")
        FullHP+=180
        FullMP+=50
        LV+=1
        FullEXP=150+(2.0).pow(LV*0.35)
        EXP=0.0
        HP=FullHP
        MP=FullMP
        BasicStr=LV*2.5
        Damage=(BasicStr+hand!!.Damage).toInt()
    }
    override fun PlayerUpdata()
    {
        this.Damage=(this.BasicStr+this.hand!!.Damage).toInt()
    }
}

class n(var n:String): Player
{
    override var name=n
    override var job="None"
    override var HP=0
    override var MP=0
    override var FullHP=500
    override var FullMP=100
    override var hand: Weapon? = Empty()
    override var Damage=0
    override var LV=1
    override var bag= LinkedList<Item?>()
    override var map: MAP?= MAP_1()
    override var MapNumber: Int=0
    override var SkillList=LinkedList<Skill>()
    override var FullEXP: Double =150+(2.0).pow(0.35)
    override var EXP: Double =0.0
    override var QuestList=LinkedList<Quest>()
}