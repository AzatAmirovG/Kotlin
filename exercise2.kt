package day00.exercise2

import kotlin.math.sqrt

fun main() {
    print("The grouping order is: ")
    val order = readln()
    if (order !in "higher, lower")
        throw Exception("Possible input: higher or lower")
    print("Enter a number: \n")

    val stringNumber = readln()
    val number = stringNumber.toInt() ?: throw Exception("input should be Int")

    var increment = 1
    var startPosition = 0
    if (order == "lower") {
        increment = -1
        startPosition = stringNumber.length - 1
    }

    var i = 0
    var numberToPrint = ""
    while (i != stringNumber.length) {
        numberToPrint += stringNumber[startPosition]
        print("\n $numberToPrint - ")
        if (!checkPrime(numberToPrint.toInt()))
            print(" Prime")
        startPosition += increment
        i++
    }
}


fun checkPrime(num: Int): Boolean {
    var i = 2
    while(i <= sqrt(num.toDouble())){
        if (num % i == 0){
            return true
        }
        i++
    }
    return false
}