import MainSystem.*
import com.andreapivetta.kolor.yellow
import item.Consume.BlueWater
import item.Consume.RedWater
import item.normalItem.Item_1
import item.weapon.ShortSword
import item.weapon.WoodSword
import map.m
import player.Player
import player.setjob
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.util.*

const val ANSI_CLS = "\u001b[2J"
const val ANSI_HOME = "\u001b[H"
const val ANSI_BOLD = "\u001b[1m"
const val ANSI_AT55 = "\u001b[10;10H"
const val ANSI_REVERSEON = "\u001b[7m"
const val ANSI_NORMAL = "\u001b[0m"
const val ANSI_WHITEONBLUE = "\u001b[37;44m"



val input= Scanner(System.`in`)
var Map=m()
fun main(args:Array<String>)
{
    Map.Load()
    print("按1建檔 按2讀檔\n")
    var move:Int
    move=input.nextInt()
    var People:Player

    when(move) 
    {
        1->{
            println("輸入職業代碼 1是戰士 2是法師")
            var jobnum=input.nextInt()
            println("輸入名稱")
            var name=input.next()
            People=setjob(jobnum,name)
            People.put(RedWater(),1)
            People.put(WoodSword(),1)
            People.put(ShortSword(),1)
            People.put(BlueWater(),1)
            People.put(Item_1(),1)
            People.save()
            game(People)
        }
        2->
        {
            val i = ObjectInputStream(FileInputStream("data.txt"))
            People = i.readObject() as Player
            People.Info()
            People.ShowBag()
            game(People)
        }
    }
}





var command=""
fun game(P:Player)
{
    do
    {
        MapUpdata(P,P.MapNumber,Map)
        println("請輸入指令,L離開,D顯示玩家資料,I顯示物品欄,N前往下一張地圖,B回到上一張地圖\nK進入戰鬥")
        println()
        println("目前所在地:${P.map!!.Name}")
        command=input.next().toUpperCase()
        when(command)
        {
            "D"->
            {
                P.Info()
            }
            "I"->
            {
                ItemDisplay(P)
            }
            "N"->
            {
                P.MapNumber=NextMap(P.MapNumber,Map.MapSet.size)
            }
            "B"->
            {
                P.MapNumber= LastMap(P.MapNumber,Map.MapSet.size)
            }
            "K"->
            {
                Fight(P)
            }
        }
        P.save()
    }while(command!="L")
}