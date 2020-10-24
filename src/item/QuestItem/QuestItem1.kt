package item.normalItem

import item.NormalItem

class QuestItem1: NormalItem()
{
    override var Count: Int=0
    override var Name: String="錢包"
    override fun GetInfo()
    {
        println("似乎就是村民的錢包,媽ㄉ裡面也沒多少錢叫我幫忙找還這種口氣操")
    }
}