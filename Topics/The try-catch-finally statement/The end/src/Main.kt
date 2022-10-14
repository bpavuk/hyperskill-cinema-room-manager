fun solution() {
    try {
        val v1 = readln().toInt()
        val v2 = readln().toInt()

        println(v1 / v2)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}