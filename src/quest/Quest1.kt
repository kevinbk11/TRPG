package quest

import item.Item
import monster.Monster
import monster.monsterType.TurnTurnBird
import player.Player
import java.util.*

class Quest1:Quest()
{
    override var Name:String="村長怕鳥"
    override var Exp=100
    override var Money=500
    override var QuestWord= mapOf("Done" to "謝了","NotDone" to "你還沒完成吧","WasDone" to "謝謝","BeforeAccept" to "幫我打鳥")
    init {
        this.NeedMonsterList.add(TurnTurnBird)
        this.NeedMonsterCount.add(3)
    }
}