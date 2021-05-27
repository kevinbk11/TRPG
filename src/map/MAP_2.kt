package map

import monster.Monster
import npc.*
import java.util.*

object MAP_2:MAP()
{
    override var Name="艾村"
    init{
        Npc.add(NPC1)
        Npc.add(NPC2)
    }
}