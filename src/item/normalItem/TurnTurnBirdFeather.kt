package item.normalItem

import item.NormalItem

class TurnTurnBirdFeather: NormalItem() {
    override var Count: Int=0
    override var Name: String="轉轉鳥的羽毛"
    override fun GetInfo()
    {
        println("轉轉鳥的羽毛,有著漂亮的青藍色")
    }
}
