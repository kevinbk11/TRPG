package quest

import item.BrokenStone
import item.Item
import monster.Monster
import monster.monsterType.LittleStone
import player.Player
import java.util.*

class Quest2:Quest
{
    override var Name:String="村長要石頭"
    override var Accept=false
    override var ItemCount=Array(10,{it->0})
    override var MonsterCount= Array(10,{it->0})
    override var NeedMonsterList= LinkedList<Monster>()//小石怪
    override var NeedItemList=LinkedList<Item?>()
    override var Done=false
    override var HadBeenDone=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打石頭")
    init {
        NeedMonsterList.add(LittleStone)
        NeedItemList.add(BrokenStone)
    }
    override fun Updata(M: Monster, P: Player)
    {
        if(M.Name!="null")
        {
            CheckMonesterCount(M)
        }
        CheckItemCount(P)
        if( (MonsterCount[0]>=3 && ItemCount[0]>=3) && (!this.Done && !HadBeenDone))
        {
            QuestDone(P)//顯示完成訊息
            /*
            TODO
            把這段改成可以直接檢查所有怪物或物品是否符合需求的函數
             */
        }
        else
        {
            this.Done=false
        }
    }
}