import MainSystem.*
import item.*
import item.HealItem.BlueWater
import item.HealItem.RedWater
import item.PlayerItem.weapon.Fighter.AdminFist
import item.PlayerItem.weapon.Fighter.ShortSword
import item.normalItem.TurnTurnBirdFeather
import map.m
import player.Player
import player.setjob
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.util.*


val input= Scanner(System.`in`)
var Map=m

fun main(args: Array<String>)
{

    Map.Load()
    print("按1建檔 按2讀檔\n")
    var move:Int
    move=input.nextInt()
    var People:Player

    when(move) 
    {
        1 -> {
            println("輸入職業代碼 1是戰士 2是法師")
            var jobnum = input.nextInt()
            println("輸入名稱")
            var name = input.next()
            People = setjob(jobnum, name)
            People.put(RedWater(), 1)
            People.put(ShortSword, 1)
            People.put(BlueWater(), 1)
            People.put(TurnTurnBirdFeather(), 1)
            People.put(RedWater(), 1)
            game(People)
        }
        2 -> {
            val i = ObjectInputStream(FileInputStream("data.txt"))
            People = i.readObject() as Player
            for (y in People.bag) {
                if (y!!.Count == 0) {
                    People.bag.remove(y)
                    People.bag.add(empty)
                    break
                }
            }
            game(People)
        }
    }
}

var command=""
fun game(P: Player)
{
    m.Load()
    do
    {
        MapUpdata(P, P.MapNumber, m)
        P.PlayerUpdata()
        println("請輸入指令,L離開,D顯示玩家資料,I顯示物品欄,N前往下一張地圖,B回到上一張地圖\nK進入戰鬥,T查看該地圖npc,Q查看任務")
        println()
        println("目前所在地:${P.map!!.Name}")
        while(P.EXP>=P.FullEXP)
        {
            P.levelup()
        }
        command= MainSystem.input.next().toUpperCase()
        when(command)
        {
            "D" -> {
                P.Info()
            }
            "I" -> {
                ItemDisplay(P)
            }
            "N" -> {
                P.MapNumber = NextMap(P.MapNumber, m.MapSet.size)
            }
            "B" -> {
                P.MapNumber = LastMap(P.MapNumber, m.MapSet.size)
            }
            "K" -> {
                Fight(P)
            }
            "T" -> {
                NPC(P)
            }
            "Q" -> {
                P.CheckQuest()
            }
            "SYSTEMCALL" -> {
                P.put(AdminFist, 1)
            }
        }
        P.save()
    }while(command!="L")
}



