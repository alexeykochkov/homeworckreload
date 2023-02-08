package money

class USDollar: CurrencyConverter {
    override var currencyCode = "847"

    override fun convertRub(rubles: Double): Double {
       return rubles/71.0
    }
}
