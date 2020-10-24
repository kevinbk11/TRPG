package npc

import monster.monsterType.TurnTurnBird
import player.Player
import quest.Quest
import quest.Quest1
import quest.Quest2
import quest.Quest3

import java.util.*

class NPC2:Npc()
{
    override var Name:String="小村民"
    override var HaveAnthorChoice=true
    override var NPCQuest= LinkedList<Quest>()
    init {
        NPCQuest.add(Quest3())
    }
    override fun talk(command:Int,P: Player)
    {
        when(command)
        {
            1->
            {
                say("我是沒用的小村民")
            }
            2->
            {
                if(CheckQuest(P))
                {
                    TurnTurnBird.HaveQuestItem=true
                }
            }
        }
    }
}