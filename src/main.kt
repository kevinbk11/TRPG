import MainSystem.*
import item.Consume.BlueWater
import item.Consume.RedWater
import item.normalItem.Item_1
import item.weapon.ShortSword
import map.m
import player.Player
import player.setjob
import window.*
import java.awt.EventQueue
import java.io.FileInputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.util.*
import javax.swing.JFrame



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
            People.put(RedWater, 1)
            People.put(ShortSword, 1)
            People.put(BlueWater, 1)
            People.put(Item_1, 1)
            People.put(RedWater, 1)
            People.save()
            game(People)
        }
        2 -> {
            val i = ObjectInputStream(FileInputStream("data.txt"))
            People = i.readObject() as Player
            People.Info()
            People.ShowBag()
            game(People)
        }
    }
}





