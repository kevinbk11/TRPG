package map
import MainSystem.*
import monster.*
import npc.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

interface MAP:Serializable
{
    var Name:String
    var MonsterType:LinkedList<Monster?>
    var Npc:LinkedList<Npc?>
}

class MAP_1():MAP
{
    override var Name="探險發源地(1-3)"
    override var MonsterType=LinkedList<Monster?>()
    override var Npc=LinkedList<Npc?>()
    init {
        MonsterType.add(Monster_1())
        MonsterType.add(Monster_2())
    }

}
class MAP_2():MAP
{
    override var Name="艾村"
    override var MonsterType=LinkedList<Monster?>()
    override var Npc=LinkedList<Npc?>()
    init{
        Npc.add(NPC_1())
    }
}

class m()
{
    var MapSet=ArrayList<MAP?>(100)
    fun Load()
    {
        MapSet.add(MAP_1())
        MapSet.add(MAP_2())
    }
}