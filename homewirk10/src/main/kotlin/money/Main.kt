package money

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    var converter = Converters.get("31651321324")
    if (converter != null){
        var currency = converter?.convertRub(100.0)
        println(currency)
    } else throw IllegalArgumentException()

}