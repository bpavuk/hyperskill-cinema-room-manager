package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val cinema = Cinema(rows, seats)

    do {
        println("""
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
    """.trimIndent())

        val action = readln().toInt()
        println()
        when (action) {
            1 -> cinema.printSeats()
            2 -> cinema.buyTicket()
            3 -> cinema.printStats()
        }
    } while (action != 0)
}

class Cinema(private val rows: Int, private val seats: Int) {

    private val room = MutableList(rows) { MutableList(seats) { "S" } }
    private var currentIncome = 0f
    private var purchasedTickets = 0f

    // LOW-LEVEL FUNCTIONS

    fun printSeats() {
        var output = "Cinema:\n  "
        for (k in 0 until seats) output += "${k + 1} "
        output += "\n"
        for (i in 0 until rows) {
            output += "${i + 1} "
            for (j in 0 until seats) {
                output += "${room[i][j]} "
            }
            output += "\n"
        }
        println(output)
    }

    fun calcTotalIncome(rows: Int = room.size, seats: Int = room[0].size): Int {
        val firstHalfTicketPrice = 10
        if (rows * seats <= 60) return rows * seats * firstHalfTicketPrice

        val secondHalfTicketPrice = 8
        val firstHalfRows = rows / 2
        val secondHalfRows = rows / 2 + rows % 2
        val profitFromFirstHalf = firstHalfRows * seats * firstHalfTicketPrice
        val profitFromSecondHalf = secondHalfRows * seats * secondHalfTicketPrice

        return profitFromFirstHalf + profitFromSecondHalf
    }

    fun calcCurrentIncome(): Int {
        return currentIncome.toInt()
    }

    fun calcPercentage(): String {
        val percentage = (purchasedTickets / (rows * seats) * 100)
        return "%.2f".format(percentage)
    }

    private fun orderSeat(row: Int, seat: Int) {
        val ticketPrice = if (row > rows / 2 && rows * seats > 60) 8 else 10

        if (room[row - 1][seat - 1] == "B") throw IllegalArgumentException("That ticket has already been purchased!")
        room[row - 1][seat - 1] = "B"
        println("Ticket price: $$ticketPrice\n")
        currentIncome += ticketPrice
        purchasedTickets++
    }

    // END OF LOW-LEVEL FUNCTIONS

    // HIGH-LEVEL FUNCTIONS

    fun buyTicket() {
        println("Enter a row number:")
        val orderedRow = readln().toInt()
        println("Enter a seat number in that row:")
        val orderedSeat = readln().toInt()
        try {
            orderSeat(orderedRow, orderedSeat)
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong input!")
            buyTicket()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            buyTicket()
        }
    }

    fun printStats() {
        println("""
            Number of purchased tickets: ${purchasedTickets.toInt()}
            Percentage: ${calcPercentage()}%
            Current income: $${calcCurrentIncome()}
            total income: $${calcTotalIncome()}
            
        """.trimIndent())
    }
}