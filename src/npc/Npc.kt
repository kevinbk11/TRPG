package npc


import MainSystem.input
import player.Player
import quest.*
import java.io.Serializable
import npc.*
import java.util.*


open class Npc:Serializable
{
    open var Name:String=""//NPC名稱
    open var NPCQuest:LinkedList<Quest> =LinkedList()
    open var HaveAnthorChoice=false//NPC是否有其他功能 如商城或聊天
    open var Static= listOf("聊天","查看任務")

    open fun talk(command:Int,P:Player)
    {
        say("")
    }
    fun quest(P: Player,Choice: Int):Boolean
    {
        var unfind=true
        for(x in P.QuestList)
        {
            if (this.NPCQuest[Choice-1].Name==x.Name)
            {
                QuestStatus(P,NPCQuest[Choice-1])
                unfind=false
                break
            }
        }
        if(unfind) {
            say(this.NPCQuest[Choice - 1].QuestWord["BeforeAccept"])
            println("\n1接受 2拒絕\n")
            var x = input.nextInt()
            when (x) {
                1 -> {
                    this.NPCQuest[Choice - 1].Accept = true
                    P.QuestList.add(this.NPCQuest[Choice - 1])
                    return true
                }
                2 -> {
                    return false
                }
            }
        }
        return false
    }
    fun CheckQuest(P:Player):Boolean
    {
        if(this.NPCQuest.isNotEmpty())
        {
            var x=1
            for(quest in this.NPCQuest)
            {
                if(quest.Name!="N")
                {
                    println("${x}.${quest.Name}   \n")
                    x++
                }
            }
            println("輸入欲查看的任務")
            var z = input.nextInt()
            return quest(P,z)
        }
        return false
    }
}

fun QuestStatus(P: Player,Q:Quest)
{
    var r=0
    for(x in P.QuestList)
    {
        if(x.Name==Q.Name)
        {
            if(P.QuestList[r].Done and P.QuestList[r].Accept==true)
            {
                say(Q.QuestWord["Done"])
                P.QuestList[r].Accept=false
                P.QuestList[r].HadBeenDone=true
                for(x in 0..Q.NeedItemList.size-1)
                {
                    for(y in 0..P.bag.size)
                    {
                        if(Q.NeedItemList[x]!!.Name==P.bag[y].Name)
                        {
                            P.bag[y].Count-=Q.NeedItemCount[x]
                            break
                        }
                    }
                }
                for(x in 0..Q.ItemPrize.size-1)
                {
                    P.put(Q.ItemPrize[x],Q.ItemPrizeCount[x])
                }
                P.EXP+=Q.Exp
                P.Money+=Q.Money
            }
            else if(!P.QuestList[r].HadBeenDone)
            {
                say(Q.QuestWord["NotDone"])
            }
            else if(P.QuestList[r].HadBeenDone)
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
/*
NPC1村長
NPC2村民
 */