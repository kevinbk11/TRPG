package player


import item.Item
import item.Empty
import job.*
import java.io.*
import javax.management.ObjectInstance
import map.MAP
import map.MAP_1
import java.util.*
import kotlin.collections.ArrayList

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
    open var hand:Item?
    open var LV:Int
    open var bag:LinkedList<Item?>
    open var map:MAP?
    open fun levelup(){}

    open fun Info()
    {
        println("Name=${name}\nHP=${HP}\nhand=${hand!!.Name}\njob=${job}\nLV=${LV}\n")
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
    open fun put(item:Item?,value:Int)
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
                if(this.bag[x]!!.Name==Empty().Name)
                {
                    item!!.Count=value
                    this.bag[x]=item
                    break
                }
            }
        }
    }

    fun save()
    {
        val out = ObjectOutputStream(FileOutputStream("data.txt"))
        out.writeObject(this)
    }

}


