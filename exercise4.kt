package day00.exercise2

fun main(){
    var lowest = 20.0
    var highest = 25.0
    var lowestH = 30.0
    var highestH = 60.0
    var mode = readMode1()
    var season = readSeason1()
    var lambaFullSeason = { season:String ->
        if(season == "S"){
            lowest = 22.0
            "Summer"
        } else{
            highest = 22.0
            highestH = 45.0
            "Winter"}
    }
    var fullSeason = lambaFullSeason(season)

    var sign = "°C"
    var temp = readTemperature1(fullSeason)
    var humidity = readHumidity()

    if(mode =="Kelvin"){
        temp-=271.15
        lowest-=271.15
        highest-=271.15
        sign = "K"
    } else if(mode =="Fahreheit"){
        temp= (temp * 9/5) + 32
        lowest= (temp * 9/5) + 32
        highest= (temp * 9/5) + 32
        sign ="F"
    }

    print("The temperature is $temp $sign\n")

    finalPrint(param="temperature", lowest, highest, sign, temp )
    print("\n")
    finalPrint(param="humidity", lowestH, highestH, sign = "%", humidity )

}

fun warmerOrColder1(temp: Double, low: Double, high: Double, sign: String, param: String):Unit{
    if (temp > high){
        print("Please, decrease it by ${temp-high} $sign\n")
    } else if(temp < low){
        print("Please, increase it by ${low-temp} $sign\n")
    } else{
        print("No need for adjustments. The $param is fine\n")
    }
}

fun readMode1(): String{
    print("Output mode: ")
    var mode = readln()
    while (mode !in "Celcius, Kelvin, Fahrenheit"){
        print("Incorrect input. Enter the output mode: Celcius, Kelvin or Fahrenheit:\n")
        mode = readln()
    }
    return mode
}

fun readSeason1(): String{
    print("Enter a season - (W)inter or (S)ummer:\n")
    var season = readln()
    while (season !in "W, S"){
        print("Incorrect input. Enter a season - (W)inter or (S)ummer:\n")
        season = readln()
    }
    return  season
}

fun readTemperature1(fullSeason: String): Double {
    print("Season: $fullSeason . Enter a temperature:\n")

    var temp = readln().toDoubleOrNull()?:"S"
    while (temp !is Double){
        print("Incorrect input. Season: $fullSeason. Enter a temperature:\n")
        temp = readln()
    }
    return temp
}

fun readHumidity(): Double {
    print("Enter humidity:\n")
    var temp = readln().toDoubleOrNull()?:"S"
    while (temp !is Double){
        print("Incorrect input. Enter humidity:\n")
        temp = readln()
    }
    return temp
}

fun finalPrint(param: String, low: Double, high: Double, sign: String, number: Double ){
    print("The comfortable $param is from $low to $high $sign.\n")
    warmerOrColder1(number, low, high, sign, param)
}




