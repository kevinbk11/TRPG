package MainSystem

import item.Empty
import java.lang.Exception
import java.util.*
import player.*
import map.*



val input= Scanner(System.`in`)
fun ItemDisplay(P:Player)
{
    P.ShowBag()
    println("請輸入道具代碼")
    try
    {
        var ItemNumber=input.nextInt()-1
        if(P.bag[ItemNumber]!!.Name==Empty().Name)throw Exception()
        println("請輸入接下來的操作,1為使用,2為顯示道具詳細,3為丟棄")
        when(input.nextInt())
        {
            1->
            {
                P.bag[ItemNumber]!!.use(P)
            }
            2->
            {
                P.bag[ItemNumber]!!.GetInfo()
            }
            3->
            {
                P.bag.removeAt(ItemNumber)
            }
        }
    }
    catch (e:Exception)
    {
        println("This Item Is Not Exist!!!")
    }
}

fun NextMap(MapNumber:Int,size:Int):Int
{
    if(MapNumber+1==size)
    {
        println("沒有這張地圖.")
        return MapNumber
    }
    else
    {
        return MapNumber+1
    }
}

fun LastMap(MapNumber:Int,size:Int):Int
{
    if(MapNumber-1==-1)
    {
        println("沒有這張地圖.")
        return MapNumber
    }
    else
    {
        return MapNumber-1
    }
}

fun MapUpdata(P:Player,MapNumber: Int,Map:m)
{
    P.map=Map.MapSet[MapNumber]
}
