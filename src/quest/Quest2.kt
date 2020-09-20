package quest

import monster.Monster
import monster.monsterType.LittleStone
import player.Player
import java.util.*

class Quest2:Quest
{
    override var Name:String="村長要石頭"
    override var Accept=false
    override var MonsterCount= IntArray(10)
    override var NeedMonsterList= LinkedList<Monster>()
    override var Done=false
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打石頭")
    init {
        NeedMonsterList.add(LittleStone)
        MonsterCount[0]=0
    }
    override fun Updata(M: Monster, P: Player)
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