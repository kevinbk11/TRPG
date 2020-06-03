package npc

import java.io.Serializable

fun say(word:String)
{
    var t=Thread()
    t.run{
        var count=0
        println()
        while(count<word.length)
        {
            Thread.sleep(80)
            print(word.substring(count,count+1))
            count++
        }
        println("\n")
    }
}
interface Npc:Serializable
{
    open var Name:String
    open var QuestionName:String
    open var HaveAnthorChoice:Boolean
    open var Static:List<String>
    fun talk(command:Int)
    {
        say("")
    }
    fun quest()
    {

    }
}
data class NPC_1(override var Name:String="村長"):Npc
{
    override var HaveAnthorChoice=true
    override var QuestionName="村長的請求(任務)"
    override var Static= listOf("聊天","${QuestionName}")
    override fun talk(command:Int)
    {
        when(command)
        {
            1->
            {
                say("欸幹幹測試測試我是村長法語也是說村長嗎")
            }
            2->
            {
                quest()
            }
        }

    }
    override fun quest()
    {
        say("幫我打鳥拜託拜託拜託")
    }
}