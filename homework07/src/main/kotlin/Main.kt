fun main(args: Array<String>) {
    println("Сколько телевизоров вы хотите создать?")
    var count = readln().toInt()
    repeat(count) {
        println("Введите брэнд")
        val brabd = readln()
        println("Введите модель")
        val model = readln()
        println("Введите диагональ")
        val diagonal = readln().toInt()
        val myTelevisor = televisor(brabd, model, diagonal)
        println("Брэнд ${myTelevisor.brend} Модэль ${myTelevisor.model} Диагональ ${myTelevisor.dialonal}")
    }
}
