package quest

import item.Item
import monster.*
import monster.monsterType.LittleStone
import monster.monsterType.TurnTurnBird
import player.Player
import java.io.BufferedOutputStream
import java.io.Serializable
import java.util.*
import kotlin.reflect.jvm.internal.impl.util.Check

open class Quest:Serializable
{
    open var QuestWord:Map<String,String> = mapOf("Done" to "謝了")
    open var Name:String=""
    open var Accept:Boolean=false
    open var NeedMonsterList:LinkedList<Monster> = LinkedList()
    open var NeedItemList:LinkedList<Item?> = LinkedList()
    open var NeedMonsterCount:LinkedList<Int> = LinkedList()
    open var NeedItemCount:LinkedList<Int> = LinkedList()
    open var ItemCount:Array<Int> =Array(10,{it->0})
    open var MonsterCount:Array<Int> =Array(10,{it->0})
    open var Done:Boolean=false
    open var HadBeenDone:Boolean=false
    open var Exp:Int=0
    open var Money:Int=0
    open var ItemPrize:LinkedList<Item> = LinkedList()
    open var ItemPrizeCount:LinkedList<Int> = LinkedList()
    fun Updata(M:Monster,P:Player)
    {
        if(this.HadBeenDone==false && this.Name!="N")
        {
            if(M.Name!="null")
            {
                CheckMonesterCount(M)
            }
            CheckItemCount(P)
            var Done=CheckDone()
            if(Done)
            {
                QuestDone()//顯示完成訊息
            }
            else
            {
                this.Done=false
            }
        }
    }
    fun QuestDone()
    {
        println("\n任務 ${this.Name} 已完成!!!!\n")
        this.Done=true
    }
    fun CheckDone():Boolean
    {
        for(x in 0..this.NeedMonsterList.size-1)
        {
            if(this.NeedMonsterCount[x]>this.MonsterCount[x])
            {
                return false
            }
        }
        for(x in 0..this.NeedItemList.size-1)
        {
            if(this.NeedItemCount[x]>this.ItemCount[x])
            {
                return false
            }
        }
        return true
    }
    fun CheckMonesterCount(M:Monster)
    {
        for(x in 0..this.NeedMonsterList.size-1)
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
                    for(y in 0..this.NeedItemList.size-1)
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

class nullQuest:Quest()
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
/*
Q1村長怕鳥
Q2村長要石頭
 */