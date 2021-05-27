package job

import item.Item
import item.*
import item.PlayerItem.cloth.EmptyCloth
import item.PlayerItem.pants.EmptyPants
import item.PlayerItem.weapon.EmptyWeapon
import map.MAP
import map.MAP_1
import player.Player
import quest.Quest
import skill.Skill
import java.util.*
import kotlin.math.pow

class NoneJob(n:String): Player
{
    override var name=n
    override var job="None"
    override var HP=0
    override var MP=0
    override var FullHP=500
    override var FullMP=100
    override var hand: Weapon? = EmptyWeapon
    override var Damage=0
    override var cloth: Cloth?= EmptyCloth
    override var pants: Pants?= EmptyPants
    override var def =0
    override var LV=1
    override var bag:LinkedList<Item> = LinkedList()
    override var map: MAP?= MAP_1
    override var MapNumber: Int=0
    override var SkillList= LinkedList<Skill>()
    override var FullEXP: Double =150+(2.0).pow(0.35)
    override var EXP: Double =0.0
    override var QuestList= LinkedList<Quest>()
    override var Money=0
}