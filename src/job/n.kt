package job

import item.Item
import item.*
import map.MAP
import map.MAP_1
import player.Player
import quest.Quest
import skill.Skill
import java.util.*
import kotlin.math.pow

class n(var n:String): Player
{
    override var name=n
    override var job="None"
    override var HP=0
    override var MP=0
    override var FullHP=500
    override var FullMP=100
    override var hand: Weapon? = Empty
    override var Damage=0
    override var LV=1
    override var bag:LinkedList<Item> = LinkedList()
    override var map: MAP?= MAP_1()
    override var MapNumber: Int=0
    override var SkillList= LinkedList<Skill>()
    override var FullEXP: Double =150+(2.0).pow(0.35)
    override var EXP: Double =0.0
    override var QuestList= LinkedList<Quest>()
}