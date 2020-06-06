package npc

import MainSystem.input
import player.Player
import quest.*
import java.io.Serializable
import java.lang.management.PlatformLoggingMXBean
import java.util.*
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
    fun quest(P: Player)
    {

    }
}
data class NPC_1(override var Name:String="村長"):Npc
{
    override var HaveAnthorChoice=true
    override var NPCQuest=LinkedList<Quest>()
    init {
        NPCQuest.add(Quest_1())
        NPCQuest.add(Quest_2())
    }
    override var Static= listOf("聊天","${NPCQuest[0].Name}","${NPCQuest[1].Name}")
    override fun talk(command:Int,P:Player)
    {
        when(command)
        {
            1->
            {
                say("欸幹幹測試測試我是村長法語也是說村長嗎")
            }
            2->
            {
                quest(P)
            }
        }

    }
    override fun quest(P:Player)//之後要選擇任務
    {
        if(this.NPCQuest[0] in P.QuestList==false)
        {
            say("幫我打鳥拜託拜託拜託")
            println("\n1接受 2拒絕\n")
            var x= input.nextInt()
            when(x)
            {
                1->
                {
                    this.NPCQuest[0].Accept=true
                    P.QuestList.add(this.NPCQuest[0])

                }
                2->
                {

                }
            }
        }
        else
        {
            QuestStatus(P,NPCQuest[0])


        }
    }
}