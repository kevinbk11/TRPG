package quest

import monster.*
import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird
import player.Player
import java.io.Serializable
import java.util.*

interface Quest:Serializable
{
    open var QuestWord:Map<String,String>
    open var Name:String
    open var Accept:Boolean
    open var NeedMonsterList:LinkedList<Monster>
    open var MonsterCount:IntArray
    open var Done:Boolean

    open fun Updata(M:Monster,P:Player)
    {

    }
}

class nullQuest:Quest
{
    override var Name:String="N"
    override var Accept=false
    override var MonsterCount= IntArray(10)
    override var NeedMonsterList=LinkedList<Monster>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝")
}
var NullQuest = nullQuest()
var Quest_1 = Quest1()
var Quest_2 = Quest2()
/*
Q1村長怕鳥
Q2村長要石頭
 */