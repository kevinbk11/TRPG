package quest

import monster.*
import player.Player
import java.awt.*
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


data class Quest_1(override var Name:String="村長怕鳥"):Quest
{
    override var Accept=false
    override var MonsterCount= IntArray(10)
    override var NeedMonsterList=LinkedList<Monster>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打鳥")
    init {
        NeedMonsterList.add(Monster_1())
        MonsterCount[0]=0
    }
    override fun Updata(M:Monster,P:Player)
    {
        for(x in NeedMonsterList)
        {
            if(M.Name==x.Name)
            {
                MonsterCount[0]++
            }
        }
        if(MonsterCount[0]>=3)
        {
            println("\ndone!!\n")
            var r=0
            for(q in P.QuestList)
            {
                if(q.Name==this.Name)
                {
                    P.QuestList[r].Done=true
                    break
                }
                else
                {
                    r++
                }
            }
        }
    }
}


data class Quest_2(override var Name:String="村長要石頭"):Quest
{
    override var Accept=false
    override var MonsterCount= IntArray(10)
    override var NeedMonsterList=LinkedList<Monster>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打石頭")
    init {
        NeedMonsterList.add(Monster_2())
        MonsterCount[0]=0
    }
    override fun Updata(M:Monster,P:Player)
    {
        for(x in NeedMonsterList)
        {
            if(M.Name==x.Name)
            {
                MonsterCount[0]++
            }
        }
        if(MonsterCount[0]>=3)
        {
            println("\ndone!!\n")
            var r=0
            for(q in P.QuestList)
            {
                if(q.Name==this.Name)
                {
                    P.QuestList[r].Done=true
                    break
                }
                else
                {
                    r++
                }
            }
        }
    }
}


data class NullQuest(override var Name:String="N"):Quest
{
    override var Accept=false
    override var MonsterCount= IntArray(10)
    override var NeedMonsterList=LinkedList<Monster>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝")
}
