package map

import monster.Monster
import npc.*
import java.util.*

class MAP_2:MAP
{
    override var Name="艾村"
    override var MonsterType= LinkedList<Monster?>()
    override var Npc= LinkedList<Npc?>()
    init{
        Npc.add(NPC_1)
    }
}