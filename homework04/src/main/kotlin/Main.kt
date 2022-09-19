fun main(args: Array<String>) {
    val text1 = "F2p)v\"y233{0"
    val string1 = text1.map {char -> char - 2}.joinToString ()
    val oldValue1 = "5,4,0"
    val newValue1= "s,u,o"
    val result1 = string1.replace(oldValue1, newValue1)
    val text2 = "->c}ttelciFc"
    val string2 = text2.map {char -> char - 4}.joinToString ()
    val reverse2 = string2.reversed()
    val oldValue2 = "_"
    val newValue2= ""
    val result2= reverse2.replace(oldValue2, newValue2)
    println(result1+result2)
}