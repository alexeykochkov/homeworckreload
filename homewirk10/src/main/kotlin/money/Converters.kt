package money

object Converters {
    private val currencyCodeToConvertor_ = mutableMapOf<String, CurrencyConverter>(
        "847" to USDollar(),
        "554" to Yuan()
    )
        fun get(currencyCode: String): CurrencyConverter? {
            if(!currencyCodeToConvertor_.containsKey(currencyCode)){
                println("cant finde currency code")
                return object : CurrencyConverter {
                    override var currencyCode = currencyCode
                    override fun convertRub(rubles: Double): Double {
                        println("exchange currency 1/10000000.0")
                        return rubles/10000000.0
                    }
                }
            }
            return currencyCodeToConvertor_[currencyCode]
        }

//    init {
//        var usDollar = money.USDollar()
//        currencyCodeToConvertor.put("847",usDollar)
//    }
}