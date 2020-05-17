package monster
import MainSystem.*
import item.Consume.*
import item.normalItem.*
import item.weapon.*
import java.io.Serializable
import kotlin.random.Random


interface Monster:Serializable
{
    var Name:String
    var HP:Int
    fun info(){}
    fun drop(): Item?
    {
        return null
    }
}

class Monster_1():Monster
{
    override var Name="轉轉鳥"
    override var HP=50
    val I1= Item_1()
    val I2= RedWater()
    override fun drop(): Item?
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..80->return I1
            in 81..100->return I2
            else->return null
        }
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }
}

class Monster_2():Monster
{
    override var Name="小石怪"
    override var HP=65
    val I1= Item_2()
    val I2= BlueWater()
    override fun drop(): Item?
    {
        val rd= Random.nextInt(0,100)
        when(rd)
        {
            in 0..80->return I1
            in 81..100->return I2
            else->return null
        }
    }
    override fun info()
    {
        println("Name=${Name},HP=${HP}")
    }
}