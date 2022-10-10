fun main(args: Array<String>) {
    println("Введите количество вносимых номеров")
    var n = readln().toIntOrNull() ?: return
    while (n<0) {
        println("Число должно быть положительным")
        n = readLine()?.toIntOrNull() ?: return
    }
    val mutableListPhone = getTelephone(n)
    val teleBook = getName(mutableListPhone)

    val filter = teleBook.filterKeys { it.contains("+7") }
    for (entry in filter.entries) {
        println("Абонент: ${entry.value} - Номер телефона: ${entry.key}")}

    val toset = mutableListPhone.toSet()
    println("Сумма длинны всех номеров телефонов - ${toset.sumOf { it.length }}")

    val reversed = teleBook.entries.associate { (v, k) -> v to k }
    for (entry in reversed.entries) {
        println("Номер телефона: ${entry.key} - Абонент: ${entry.value}")
    }
}

fun getTelephone(n: Int): MutableList<String> {

    val phoneNumbers = mutableListOf<String>()
    while (phoneNumbers.size < n) {
        val contactNum = phoneNumbers.size + 1
        println("Введите телефон $contactNum контакта")

        val telephone = readLine()
        telephone?.let {
            phoneNumbers.add(it)
        }
    }
    return phoneNumbers
}
fun getName (number: MutableList<String>): MutableMap<String, String>  {
    val phonebookMapped = mutableMapOf<String, String> ()
    for (telephone in number) {
        println("Введите имя для контакта $telephone")
        val name = readLine()
        name?.let {
            phonebookMapped.put(telephone, name)
        }
    }
    return phonebookMapped
}
