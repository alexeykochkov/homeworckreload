fun main(args: Array<String>) {
    val mainText = "F2p)v\"y233{0->c}ttelciFc"

    val firstText: String =mainText.substring(0,12)
    var partOne = firstText.map {char -> char + 1}.joinToString ("")
    partOne =  partOne.replace("5", "s")
    partOne =  partOne.replace("4", "u")
    var partOnePlus = partOne.map {char -> char - 3}.joinToString ("")
    partOnePlus = partOnePlus.replace("0", "o")

    val secondText: String = mainText.substring(12,24)
    val reverse = secondText.reversed()
    var partTwo = reverse.map {char -> char - 4}.joinToString ("")
    partTwo =  partTwo.replace("_", " ")

    println(partOnePlus+partTwo)
   }