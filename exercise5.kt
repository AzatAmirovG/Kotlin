package day00.exercise5

import kotlin.math.pow
import kotlin.math.sqrt
//import android.graphics.Canvas

fun main() {
    print("Введите х1 ")
    var x1 = readln()!!.toDouble()
    print("Введите y1 ")
    var y1 = readln()!!.toDouble()
    print("Введите r1 ")
    var r1 = readln()!!.toDouble()
    print("Введите х2 ")
    var x2 = readln()!!.toDouble()
    print("Введите у2 ")
    var y2 = readln()!!.toDouble()
    print("Введите r2 ")
    var r2 = readln()!!.toDouble()

    val length = vectorLength(x1, y1, x2, y2)
    val sumOfRadiuses = r1 + r2;
    var result = showResult(length, sumOfRadiuses, r1, r2)
    if (result > 0){
        calcCoordinates(x1, y1, r1, x2, y2, r2, length, result)
    }


//    var paint: Paint? = Paint()
//    paint.setColor(Color.GREEN) // установим зелёный цвет
//    paint.setStyle(Paint.Style.FILL)
//    canvas.drawCircle(x1, y1, r1, paint);
}

fun vectorLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = sqrt((x2-x1).pow(2) +(y2-y1).pow(2))

fun showResult(length: Double, sumOfRadiuses: Double, r1:Double, r2:Double): Int {
    var result = 0
    if (length == sumOfRadiuses) {
        println("the circles touch")
        result = 1
    } else if (length > sumOfRadiuses && length != 0.0) {
        println("the circles do not intersect")
    } else if (r1 >= length + r2 || r2 >= length + r1) {
        if (length == 0.0 && r1 == r2) {
            println("the circles coincide")
        } else {
            println("one circle is inside of another")
        }
    } else {
        println("the circles intersect")
        result = 2
    }
    return result
}

fun calcCoordinates(x1: Double, y1: Double, r1: Double, x2: Double, y2: Double, r2: Double, length: Double, type: Int){
    var a = (r1.pow(2) - r2.pow(2) + length.pow(2))/ (2 * length)
    var h = sqrt(r1.pow(2) - a.pow(2))
    var x3 = x1 + a * (x2 - x1)/ length
    var y3 = y1 + a * (y2 - y1)/ length
    var xResult = x3 + h *(y2 - y1)/ length
    var yResult = y3 + h *(x2 - x1)/ length
    if (type == 1){
        print("\nCircles intersect at (${"%.2f".format(xResult)}, ${"%.2f".format(yResult)})")
    } else{
        var xResult2 = x3 - h *(y2 - y1)/ length
        var yResult2 = y3 - h *(x2 - x1)/ length
        print("\nCircles intersect at (${"%.2f".format(xResult)}, ${"%.2f".format(yResult)}) and" +
                " (${"%.2f".format(xResult2)}, ${"%.2f".format(yResult2)})")
    }

}