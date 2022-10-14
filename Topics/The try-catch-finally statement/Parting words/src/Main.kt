fun pepTalk(name: String): String {
    println("Good luck!")
    val array = name.split(" ").toTypedArray()
    return try {
        val firstName = array[0]
        val secondName = array[1]
        "Don't lose the towel, traveler $firstName $secondName!"
    } catch (e: Exception) {
        "Don't lose the towel, nameless one."
    }
}   
// do not change the function above        

fun main() {
    val name = readLine()!!
    val advice = pepTalk(name) // fix this function call
    print(advice)        
}