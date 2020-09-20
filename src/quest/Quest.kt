package quest

import item.Item
import monster.*
import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird
import player.Player
import java.io.BufferedOutputStream
import java.io.Serializable
import java.util.*

interface Quest:Serializable
{
    open var QuestWord:Map<String,String>
    open var Name:String
    open var Accept:Boolean
    open var NeedMonsterList:LinkedList<Monster>
    open var NeedItemList:LinkedList<Item?>
    open var ItemCount:Array<Int>
    open var MonsterCount:Array<Int>
    open var Done:Boolean
    open var HadBeenDone:Boolean
    open fun Updata(M:Monster,P:Player)
    {

    }
    fun QuestDone(P: Player)
    {
        println("\n任務 ${this.Name} 已完成!!!!\n")
        this.Done=true

    }
    fun CheckMonesterCount(M:Monster)
    {
        for(x in 0..10)
        {
            if(M.Name==this.NeedMonsterList[x]!!.Name)
            {
                this.MonsterCount[x]++
                break
            }
        }
    }
    fun CheckItemCount(P: Player)
    {
        for(w in this.NeedItemList)
        {
            var f=false
            for(x in P.bag)
            {
                if(x.Name==w!!.Name)
                {
                    for(y in 0..9)
                    {
                        if(this.NeedItemList[y]!!.Name==x.Name)
                        {
                            this.ItemCount[y]=x.Count
                            f=true
                            break
                        }
                    }
                    if(f)
                    {
                        break
                    }
                }
                for(y in 0..9)
                {
                    this.ItemCount[y]=0
                }
            }
        }
    }
}

class nullQuest:Quest
{
    override var Name:String="N"
    override var Accept=false
    override var ItemCount=Array(10,{it->0})
    override var MonsterCount= Array(10,{it->0})
    override var NeedMonsterList=LinkedList<Monster>()
    override var NeedItemList=LinkedList<Item?>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝")
    override var HadBeenDone=false
}
var NullQuest = nullQuest()
var Quest_1 = Quest1()
var Quest_2 = Quest2()
/*
Q1村長怕鳥
Q2村長要石頭
 */