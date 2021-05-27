package map

import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird


object MAP_1:MAP()
{
    override var Name="探險發源地(1-3)"
    init {
        MonsterType.add(TurnTurnBird)
        MonsterType.add(LittleStone)
    }

}