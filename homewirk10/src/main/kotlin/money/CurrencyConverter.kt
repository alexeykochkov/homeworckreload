package money

interface CurrencyConverter {
    var currencyCode: String

    fun convertRub (rubles: Double): Double

}