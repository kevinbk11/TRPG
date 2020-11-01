package player


import item.*
import job.*
import java.io.*
import map.MAP
import monster.Monster
import quest.Quest
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
    open var cloth:Cloth?
    open var pants:Pants?
    open var LV:Int
    open var bag:LinkedList<Item>
    open var map:MAP?
    open var MapNumber:Int
    open var Damage:Int
    open var def:Int
    open var FullEXP:Double
    open var EXP:Double
    open var SkillList:LinkedList<Skill>
    open var QuestList:LinkedList<Quest>
    open var Money:Int
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
    open fun Attack(M: Monster,S:Skill)
    {
        S.use(M,this)
    }
    open fun <T>use(I:T)
    {
        when(I)
        {
            is Weapon->
            {
                this.put(this.hand,1)
                this.Damage-=this.hand!!.Damage
                this.hand=I
                this.Damage+=this.hand!!.Damage
                I.Count-=1
            }
            is Heal->
            {
                this.HP+=I.HealHP
                this.MP+=I.HealMP
                I.Count-=1
            }
            is Cloth->
            {
                this.put(this.cloth,1)
                this.def-=this.cloth!!.def
                this.cloth=I
                this.def+=this.cloth!!.def
                I.Count-=1
            }
            is Pants->
            {
                this.put(this.pants,1)
                this.def-=this.pants!!.def
                this.pants=I
                this.def+=this.pants!!.def
                I.Count-=1
            }
        }
        Message(this,I)
    }
    open fun Info()
    {
        println("玩家名稱=${name}\n" +
                "HP=${HP}\n" +
                "MP=${MP}\n" +
                "等級=${LV}\n" +
                "經驗值=${EXP.toInt()},還需要${(FullEXP-EXP).toInt()}經驗\n" +
                "艾幣=${Money}\n" +
                "武器=${hand!!.Name}\n" +
                "職業=${job}\n" +
                "等級=${LV}\n" +
                "傷害=${Damage}\n" +
                "防禦力=${def}")
    }
    open fun UpdataQuest(M:Monster)
    {
        for(QUEST in this.QuestList)
        {
            QUEST.Updata(M,this)
        }
    }
    open fun ShowBag() {
        var w = 1
        for (y in bag) {
            if (y!!.Count == 0) {
                bag.remove(y)
                bag.add(Empty)
                break
            }
        }
        for (x in bag) {
            if (x!!.Name != Empty.Name) {
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
                if(this.bag[x]!!.Name== Empty.Name)
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


