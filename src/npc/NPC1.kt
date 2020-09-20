package npc

import MainSystem.input
import player.Player
import quest.Quest
import quest.Quest_1
import quest.Quest_2
import java.util.*

class NPC1:Npc
{
    override var Name:String="村長"
    override var HaveAnthorChoice=true
    override var NPCQuest= LinkedList<Quest>()
    init {
        NPCQuest.add(Quest_1)
        NPCQuest.add(Quest_2)
    }
    override var Static= listOf("聊天","查看任務")
    override fun talk(command:Int,P: Player)
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

    override fun CheckQuest(N: Npc,P: Player)
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
    override fun quest(P: Player, Choice:Int)//之後要選擇任務
    {
        var unfind=true
        for(x in P.QuestList)
        {
            if (this.NPCQuest[Choice-1].Name==x.Name)
            {
                print("?")
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

                }
                2 -> {

                }
            }
        }
    }
}