package map
import monster.*
import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird
import npc.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

abstract class MAP:Serializable
{
    open var Name=""
    open var MonsterType=LinkedList<Monster>()
    open var Npc=LinkedList<Npc?>()
}


object m
{
    var MapSet=ArrayList<MAP?>(100)
    fun Load()
    {
        MapSet.add(MAP_1)
        MapSet.add(MAP_2)
    }
}
/*
MAP1=探險發源地
MAP2=艾村
*/