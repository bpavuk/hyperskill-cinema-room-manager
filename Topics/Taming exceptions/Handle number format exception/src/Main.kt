import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    val incorrectCardNumber = Exception("Incorrect card number!")

    val cardNumFormat = Regex("\\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d")
    if (!cardNumFormat.matches(cardNumber)) throw incorrectCardNumber

    val cardNum = cardNumber.split(" ")
    var cardNumStr = ""
    for (i in cardNum) cardNumStr += i

    return cardNumStr.toLong()
}