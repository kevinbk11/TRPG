package player

import item.Consume.*
import item.weapon.*
import item.normalItem.*
import job.*
import java.io.*
import map.MAP
import monster.Monster
import quest.Quest
import skill.NomralAttack
import skill.Skill
import java.util.*

fun setjob(num:Int,name:String):Player
{
    var m= magic(name)
    var f= fighter(name)
    var N= n(name)
    when(num)
    {
        1->return f
        2->return m
    }
    return N
}
interface Player:Serializable
{
    open var name:String
    open var job:String
    open var HP:Int
    open var MP:Int
    open var FullHP:Int
    open var FullMP:Int
    open var hand: Weapon?
    open var LV:Int
    open var bag:LinkedList<Item?>
    open var map:MAP?
    open var MapNumber:Int
    open var Damage:Int
    open var FullEXP:Double
    open var EXP:Double
    open var SkillList:LinkedList<Skill>
    open var QuestList:LinkedList<Quest>
    open fun levelup(){}
    open fun CheckQuest()
    {
        var num=1
        for (q in this.QuestList)
        {
            if(q.Name!="N")
            {
                println("${num}.${q.Name}")
                num++
            }

        }
    }
    open fun Info()
    {
        println("Name=${name}\nHP=${HP}\nMP=${MP}\nhand=${hand!!.Name}\njob=${job}\nLV=${LV}\nDamage=${Damage}")
    }
    open fun UpdataQuest(M:Monster,P:Player)
    {
        for(QUEST in this.QuestList)
        {
            QUEST.Updata(M,P)
        }
    }
    open fun ShowBag() {
        var w = 1
        for (y in bag) {
            if (y!!.Count == 0) {
                bag.remove(y)
                bag.add(Empty())
                break
            }
        }
        for (x in bag) {
            if (x!!.Name != Empty().Name) {
                println("${w}.${x!!.Name} x${x.Count}")
                w++
            }
        }
    }
    open fun put(item: Item?, value:Int)
    {
        var find=false
        var Value=value
        for(x in this.bag)
        {
            if(x!!.Name==item!!.Name)
            {
                x.Count+=Value
                find=true
                break
            }
        }
        if(find==false)
        {
            for(x in 0..20)
            {
                if(this.bag[x]!!.Name== Empty().Name)
                {
                    item!!.Count=value
                    this.bag[x]=item
                    break
                }
            }
        }
    }
    open fun LearningSkill(SKILL:Skill)
    {
        for(x in 1..20)
        {
            if (this.SkillList[x].name=="none")
            {
                SkillList[x]=SKILL
                break
            }
        }
    }
    open fun PlayerUpdata(){}
    fun save()
    {
        val out = ObjectOutputStream(FileOutputStream("data.txt"))
        out.writeObject(this)
    }

}


