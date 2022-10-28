class televisor (var brend: String, var model: String, var dialonal: Int) {

    var choise_ = tOF(String())
    var random_ = ranromchannals(String())

    init {
        setChannal()
        volUpVolDown()
    }

    fun tOF(tof: String): String {

        println("Включить - on или Не включать - off")
        var chois = readln()
        if (chois == "on") println("Включено")
        else println("Не включено")
        return chois
    }

    fun ranromchannals(rch: String): List<String> {
        val list = arrayListOf<String>("Первый", "Россия", "ОРТ", "РТР", "ТВ3")
        val rnds = (1..5).random()
        val randomElements = list.asSequence().shuffled().take(rnds).toList()
        if (choise_ == "on") println("Доступные каналы в телевизоре${randomElements}")
        return randomElements
    }

    private fun setChannal() {
        while (true) {
            println("Переключить канал - yes или нет - no?")
            var question = readln()
            if (question == "yes") {
                println("Переключить канал - вверх или - вниз")
                var up = readln()
                if (up != "вверх" && up != "вниз") {
                    println("Можно ввести только вверх или вниз")
                    continue
                }
                println("На какое колличество каналов?")
                var char = readln().toInt()
                val size = random_.size
                val b = char % size
                val niz = size - (char%size)
                if (up == "вверх") println("Канал ${b}  Название канала ${random_.get(b)}")
                else if (up == "вниз") println("Канал ${niz} Название канала ${random_.get(niz)}")
            } else if (question == "no") {
                println("Нет сигнала")
                return
            } else {
            }
        }
    }
    companion object {
        const val maxVolume = 100
        fun volUpVolDown() {
            while (true) {
                println("Переключить звук телевизора - yes или нет - no?")
                var questionVol = readln()
                if (questionVol == "yes") {
                    println("Переключить канал вверх или вниз")
                    var upVol = readln()
                    if (upVol != "вверх" && upVol != "вниз") {
                        println("Можно ввести только вверх или вниз")
                        continue
                    }
                    if (upVol == "вверх") {
                        println("На какое число вверх")
                        var upVol2 = readln().toInt()
                        if (upVol2 > 0 && upVol2 < maxVolume) println("Громкость ${upVol2}")
                        else if (upVol2 > maxVolume) println("Громкость ${maxVolume}")
                    }
                    if (upVol == "вниз") {
                        println("На какое число вниз")
                        var downVol = readln().toInt()
                        if (downVol < maxVolume) println("Громкость ${0}")
                    }
                }
                else if (questionVol == "no") {
                    println("Нет звука")
                    return
                }
            }
        }
    }
}