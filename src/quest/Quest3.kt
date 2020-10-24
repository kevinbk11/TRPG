package quest

import item.BlueWater
import item.QuestItem1
import item.RedWater
import monster.monsterType.TurnTurnBird

class Quest3:Quest()
{
    override var Name:String="被偷走的錢包"
    override var Exp=200
    override var Money=800
    override var QuestWord= mapOf("Done" to "感恩ㄛ","NotDone" to "媽的還不快去找","WasDone" to "謝ㄌ","BeforeAccept" to "她媽我ㄉ錢包被轉轉鳥幹走ㄌ,能幫我找回來ㄇ")
    init
    {
        NeedItemList.add(QuestItem1)
        NeedItemCount.add(1)
        this.ItemPrize.add(RedWater)
        this.ItemPrize.add(BlueWater)
        this.ItemPrizeCount.add(3)
        this.ItemPrizeCount.add(3)
    }
}