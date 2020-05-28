package MainSystem

import item.normalItem.Empty
import map.m
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
        if(P.bag[ItemNumber]!!.Name== Empty().Name)throw Exception()
        println("請輸入接下來的操作,1為使用,2為顯示道具詳細,3為丟棄")
        when(input.nextInt())
        {
            1->
            {
                P.bag[ItemNumber]!!.use(P)
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
        var Monster = Map.MonsterType[MonsterNumber-1]
        print("你的血量:${P.HP},   ${Monster!!.Name}的血量:${Monster!!.HP}\n")
        FightThread(P).run()
    }
}
class FightThread(var PP:Player) : Thread() {
    override fun run() {
        super.run()
        var cd=(PP.hand!!.CD*1000).toLong()
        for(x in 0..4)
        {
            print("攻擊\n")
            Thread.sleep(cd)
        }
    }
}



