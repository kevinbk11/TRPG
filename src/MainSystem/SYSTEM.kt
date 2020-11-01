package MainSystem

import item.*
import map.*
import monster.*
import player.Player
import java.util.*
import kotlin.random.Random


val input= Scanner(System.`in`)
fun ItemDisplay(P:Player)
{
    P.ShowBag()
    println("請輸入道具代碼")
    try
    {
        var ItemNumber=input.nextInt()-1
        if(P.bag[ItemNumber].Name== Empty.Name)throw Exception()
        println("請輸入接下來的操作,1為使用,2為顯示道具詳細,3為丟棄")
        when(input.nextInt())
        {
            1->
            {
                P.use(P.bag[ItemNumber])
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
        println("這裡是空的。")
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
        try
        {
            var Monster = Map.MonsterType[MonsterNumber - 1]
            Fighting(P, Monster)
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
        P.Attack(M,P.SkillList[attackCommand])
        if(M.HP<=0)
        {
            println("${M.Name}倒下了! 戰鬥勝利!\n")
            break
        }
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
            println("你獲得了${prize!!.Name}${count}個\n")
        }
        var r = Random.nextDouble(0.80000,1.20000)*M.Money
        var x=r.toInt()
        println("你獲得了${x}艾幣\n")
        P.Money+=x
        P.EXP+=M.Exp
        if(P.EXP>=P.FullEXP)
        {
            P.levelup()
        }
        P.UpdataQuest(M)
    }

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



