package quest

import item.BrokenStone
import item.Item
import monster.Monster
import monster.monsterType.LittleStone
import player.Player
import java.util.*

class Quest2:Quest()
{
    override var Name:String="村長要石頭"
    override var Exp=150
    override var Money=600
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打石頭")
    init {
        NeedMonsterList.add(LittleStone)
        NeedMonsterCount.add(3)
        NeedItemList.add(BrokenStone)
        NeedItemCount.add(3)
    }
}