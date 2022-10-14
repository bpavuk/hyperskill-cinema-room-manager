fun main() {
    val i1 = readln().toInt()
    val i2 = readln().toInt()
    val i3 = readln().toInt()
    val i4 = readln().toInt()
    val which = readln().toInt()

    println(which in i1..i2 || which in i3..i4)
}