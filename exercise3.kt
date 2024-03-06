package day00.exercise2

fun main(){
    var lowest = 20.0
    var highest = 25.0
    var mode = readMode()
    var season = readSeason()
    var lambaFullSeason = { season:String ->
        if(season == "S"){
            lowest = 22.0
            "Summer"
        } else{
            highest = 22.0
            "Winter"}
    }
    var fullSeason = lambaFullSeason(season)

    var sign = "°C"
    var temp = readTemperature(fullSeason)

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

    var textComfortableZone = "The comfortable temperature is from $lowest to $highest $sign. "
    print("The temperature is $temp $sign\n")
    print("$textComfortableZone\n")
    warmerOrColder(temp, lowest, highest, mode)

}

fun warmerOrColder(temp: Double, low: Double, high: Double, mode: String):Unit{
    if (temp > high){
        print("Please, make it colder by ${temp-high} degrees")
    } else if(temp < low){
        print("Please, make it warmer by ${low-temp} degrees")
    } else{
        print("No need to adjust the temperature. Everything is fine")
    }
}

fun readMode(): String{
    print("Output mode: ")
    var mode = readln()
    while (mode !in "Celcius, Kelvin, Fahrenheit"){
        print("Incorrect input. Enter the output mode: Celcius, Kelvin or Fahrenheit:\n")
        mode = readln()
    }
    return mode
}

fun readSeason(): String{
    print("Enter a season - (W)inter or (S)ummer:\n")
    var season = readln()
    while (season !in "W, S"){
        print("Incorrect input. Enter a season - (W)inter or (S)ummer:\n")
        season = readln()
    }
    return  season
}

fun readTemperature(fullSeason: String): Double {
    print("Season: $fullSeason . Enter a temperature:\n")

    var temp = readln().toDoubleOrNull()?:"S"
    while (temp !is Double){
        print("Incorrect input. Season: $fullSeason. Enter a temperature:\n")
        temp = readln()
    }
    return temp
}