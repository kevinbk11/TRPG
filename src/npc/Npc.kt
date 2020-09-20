package npc


import player.Player
import quest.*
import java.io.Serializable
import npc.*
import java.util.*


interface Npc:Serializable
{
    open var Name:String
    open var NPCQuest:LinkedList<Quest>
    open var HaveAnthorChoice:Boolean
    open var Static:List<String>
    fun talk(command:Int,P:Player)
    {
        say("")
    }
    fun quest(P: Player,Choice: Int)
    {

    }
    fun CheckQuest(N:Npc,P:Player)
    {

    }
}

fun QuestStatus(P: Player,Q:Quest)
{
    var r=0
    for(x in P.QuestList)
    {
        if(x.Name==Q.Name)
        {
            println(P.QuestList[r].Done)
            println(P.QuestList[r].Accept)
            if(P.QuestList[r].Done and P.QuestList[r].Accept==true)
            {
                say(Q.QuestWord["Done"])
                P.QuestList[r].Accept=false
            }
            else if(P.QuestList[r].Done==false and P.QuestList[r].Accept==true)
            {
                say(Q.QuestWord["NotDone"])
            }
            else if(P.QuestList[r].Done and P.QuestList[r].Accept==false)
            {
                say(Q.QuestWord["WasDone"])
            }
            break
        }
        else
        {
            r++
        }
    }
}

fun say(word:String?)
{
    var t=Thread()
    t.run{
        var count=0
        println()
        while(count<word!!.length)
        {
            Thread.sleep(80)
            print(word.substring(count,count+1))
            count++
        }
        println("\n")
    }
}
//NPC寫好後在下方實體化物件
var NPC_1=npc.NPC1()
/*
NPC1村長
 */