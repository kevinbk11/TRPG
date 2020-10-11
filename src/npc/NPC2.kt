package npc

import player.Player
import quest.Quest

import java.util.*

class NPC2:Npc()
{
    override var Name:String="小村民"

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
                CheckQuest(P)
            }
        }
    }
}