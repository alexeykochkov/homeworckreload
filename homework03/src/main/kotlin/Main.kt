fun main(args: Array<String>) {
    val firstName: String = "Alexi"
    val lastName: String = "Kochkov"
    var height = 1.74
    var weight = 63f
    val isChild1: Boolean = 1.50 > height && 40f > weight
    var resultString1 = """First name - $firstName
        |Last name - $lastName
        |Height - $height
        |Weight - $weight
        |Is this person a child? - $isChild1""".trimMargin()
    println(resultString1)
    height = 1.0
    weight = 30f
    val isChild2: Boolean = 1.50 > height && 40f > weight
    var resultString2 = """First name - $firstName
        |Last name - $lastName
        |Height - $height
        |Weight - $weight
        |Is this person a child? - $isChild2""".trimMargin()
    println(resultString2)
}