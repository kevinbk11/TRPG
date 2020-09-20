package item.normalItem

import item.NormalItem

class BrokenStone: NormalItem()
{
    override var Count: Int=0
    override var Name: String="碎石"
    override fun GetInfo()
    {
        println("從小石怪身上掉落的碎石,很堅硬")
    }
}