package money

class Yuan: CurrencyConverter {
    override var currencyCode = "554"

    override fun convertRub(rubles: Double): Double {
        return rubles/9.0
    }
}
