package npc

import MainSystem.input
import player.Player
import quest.*
import java.io.Serializable
import java.lang.management.PlatformLoggingMXBean
import java.util.*
import java.util.zip.CheckedInputStream

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
object NPC_1:Npc
{
    override var Name:String="村長"
    override var HaveAnthorChoice=true
    override var NPCQuest=LinkedList<Quest>()
    init {
        NPCQuest.add(Quest_1)
        NPCQuest.add(Quest_2)
    }
    override var Static= listOf("聊天","查看任務")
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
                CheckQuest(this,P)
            }
        }

    }

    override fun CheckQuest(N: Npc,P:Player)
    {
        var x=1
        for(quest in N.NPCQuest)
        {
            if(quest.Name!="N")
            {
                println("${x}.${quest.Name}   \n")
                x++
            }
        }
        println("輸入欲查看的任務")
        var z = input.nextInt()
        quest(P,z)
    }
    override fun quest(P:Player,Choice:Int)//之後要選擇任務
    {
        if(this.NPCQuest[Choice-1] in P.QuestList==false)
        {
            say(this.NPCQuest[Choice-1].QuestWord["BeforeAccept"])
            println("\n1接受 2拒絕\n")
            var x= input.nextInt()
            when(x)
            {
                1->
                {
                    this.NPCQuest[Choice-1].Accept=true
                    P.QuestList.add(this.NPCQuest[Choice-1])

                }
                2->
                {

                }
            }
        }
        else
        {
            print("?")
            QuestStatus(P,NPCQuest[Choice-1])
        }
    }
}