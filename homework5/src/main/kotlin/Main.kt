fun main(args: Array<String>) {
    var e: Int
    do {println("Enter a number")
        e = readln().toIntOrNull() ?:return
        if (e <= 0 ) println("Number must be positive")
        if (e > 0) println(fibo(e))
    } while (e <= 0)
}tailrec fun fibo(e: Int): Int {
    if (e==1) return 0
    if (e==2) return 1
    if (e==3) return 1
    else return fibo(e-1)+fibo(e-2)}