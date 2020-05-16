package monster

import item.Item
import item.RedWater
import item.WoodSword
import kotlin.random.Random


interface Monster
{
    var Name:String
    var HP:Int
    fun info(){}
    fun drop(): Item?
    {
        return null
    }
}

class brb():Monster
{
    override var Name="ㄐㄐ"
    override var HP=50
    val I1= WoodSword()
    val I2= RedWater()
    override fun drop(): Item?
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..20->return I1
            in 21..100->return I2
            else->return null
        }
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }
}