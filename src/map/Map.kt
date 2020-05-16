package map

import java.io.Serializable

interface MAP:Serializable
{
    var Name:String

}

class MAP_1():MAP
{
    override var Name="探險發源地(1-3)"
}
class MAP_2():MAP
{
    override var Name="艾村"

}

class m()
{
    var MapSet=ArrayList<MAP?>(100)
    fun Load()
    {
        MapSet.add(MAP_1())
        MapSet.add(MAP_2())
    }
}