package com.example.exercise1

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
    showResult(length, sumOfRadiuses, r1, r2)


//    var paint: Paint? = Paint()
//    paint.setColor(Color.GREEN) // установим зелёный цвет
//    paint.setStyle(Paint.Style.FILL)
//    canvas.drawCircle(x1, y1, r1, paint);
}

fun vectorLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = sqrt((x2-x1).pow(2) +(y2-y1).pow(2))

fun showResult(length: Double, sumOfRadiuses: Double, r1:Double, r2:Double): Unit {
    if (length == sumOfRadiuses) {
        println("the circles touch")
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
    }
}