package map

import monster.Monster
import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird
import npc.Npc
import java.util.*

class MAP_1:MAP
{
    override var Name="探險發源地(1-3)"
    override var MonsterType= LinkedList<Monster?>()
    override var Npc= LinkedList<Npc?>()
    init {
        MonsterType.add(TurnTurnBird)
        MonsterType.add(LittleStone)
    }

}