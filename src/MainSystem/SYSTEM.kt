package MainSystem

import item.normalItem.Empty
import item.weapon.Weapon
import map.m
import monster.*
import player.Player
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.*
import kotlin.concurrent.thread


const val RESET = "\u001B[0m"
const val BLACK = "\u001B[30m"
const val REDDEEP = "\u001B[31;1m"
const val RED = "\u001B[31m"
const val GREEN = "\u001B[32m"
const val YELLOW = "\u001B[33m"
const val BLUE = "\u001B[34m"
const val PURPLE = "\u001B[35m"
const val CYAN = "\u001B[36m"
const val WHITE = "\u001B[37m"
const val BLACK_BACKGROUND = "\u001B[40m"
const val RED_BACKGROUND = "\u001B[41m"
const val GREEN_BACKGROUND = "\u001B[42m"
const val YELLOW_BACKGROUND = "\u001B[43m"
const val BLUE_BACKGROUND = "\u001B[44m"
const val PURPLE_BACKGROUND = "\u001B[45m"
const val CYAN_BACKGROUND = "\u001B[46m"
const val WHITE_BACKGROUND = "\u001B[47m"

val input= Scanner(System.`in`)
fun ItemDisplay(P:Player)
{
    P.ShowBag()
    println("請輸入道具代碼")
    try
    {
        var ItemNumber=input.nextInt()-1
        if(P.bag[ItemNumber]!!.Name== Empty.Name)throw Exception()
        println("請輸入接下來的操作,1為使用,2為顯示道具詳細,3為丟棄")
        when(input.nextInt())
        {
            1->
            {
                P.use(P.bag[ItemNumber] as Weapon)
            }
            2->
            {
                P.bag[ItemNumber]!!.GetInfo()
            }
            3->
            {
                P.bag.removeAt(ItemNumber)
            }
        }
    }
    catch (e:Exception)
    {
        println("This Item Is Not Exist!!!")
    }
}

fun NextMap(MapNumber:Int,size:Int):Int
{
    if(MapNumber+1==size)
    {
        println("沒有這張地圖.")
        return MapNumber
    }
    else
    {
        return MapNumber+1
    }
}

fun LastMap(MapNumber:Int,size:Int):Int
{
    if(MapNumber-1==-1)
    {
        println("沒有這張地圖.")
        return MapNumber
    }
    else
    {
        return MapNumber-1
    }
}

fun MapUpdata(P:Player,MapNumber: Int,Map:m)
{
    P.map=Map.MapSet[MapNumber]
}

fun Fight(P:Player)
{
    var num=1
    println()
    var Map=P.map
    for(Monster in Map!!.MonsterType)
    {
        print("${num}.${Monster!!.Name}   ")
        num++
    }
    if(num==1)
    {
        println("這裡沒有怪物!")
    }
    else
    {
        println("請輸入怪物代碼")
        var MonsterNumber = input.nextInt()
        try {
            var Monster = Map.MonsterType[MonsterNumber-1]
            Fighting(P,Monster)
        }
        catch (e:Exception)
        {
            println("沒有這隻怪物")
        }
    }
}
fun Fighting(P:Player,M: Monster?)
{
    var Fail=false
    while(M!!.HP>0)
    {

        print("你的血量:${P.HP},   ${M!!.Name}的血量:${M!!.HP}\n")
        if(P.HP==0)
        {
            println("戰鬥失敗!")
            P.HP=P.FullHP
            Fail=true
            break
        }
        var List:Int=1
        for(skill in P.SkillList)
        {
            if(skill.name!="none")
            {
                print("${List}.${skill.name}   ")
                if(List%3==0)
                {
                    println()
                }
                List++
            }

        }
        println()
        var attackCommand = input.nextInt()
        P.SkillList[attackCommand].use(M,P)
        M.Attack(P)
    }
    if(!Fail)
    {
        M.HP=M.FullHP
        var prize=M.drop()
        var count = M.ItemCount(prize)
        if(count!=0)
        {
            P.put(prize,count)
            println("你獲得了${prize!!.Name}${count}個")
        }
        P.EXP+=M.Exp
        if(P.EXP>=P.FullEXP)
        {
            P.levelup()
        }
    }
    P.UpdataQuest(M,P)
}
fun NPC(P: Player)
{
    var num=1
    for(npc in P.map!!.Npc)
    {
        println("${num},${npc!!.Name}   ")
        num++
    }
    if(num==1)
    {
        println("\n這裡沒有NPC!!\n")
    }
    else
    {
        println("請輸入npc的代碼")
        var n=input.nextInt()
        var NPC=P.map!!.Npc[n-1]
        var num=1
        println()
        if(NPC!!.HaveAnthorChoice)
        {
            for(Static in NPC.Static)
            {
                print("${num}.${Static}   ")
                num++
            }
            println()
            var choice=input.nextInt()
            NPC.talk(choice,P)
        }
        else
        {
            NPC.talk(1,P)
        }
    }
}



