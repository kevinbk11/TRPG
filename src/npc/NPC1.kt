package npc

import MainSystem.input
import player.Player
import quest.Quest
import quest.Quest1
import quest.Quest2

import java.util.*

object NPC1:Npc()
{
    override var Name:String="村長"
    override var HaveAnthorChoice=true
    override var NPCQuest= LinkedList<Quest>()
    init {
        NPCQuest.add(Quest1())
        NPCQuest.add(Quest2())
    }
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
                CheckQuest(P)
            }
        }
    }
}