package com.example.activity1.ui.theme

val fullname = "Theekshani Pramodya Hettiarachchi"
var appversion = 10.1

fun main(){
    println("Fullname - $fullname and App Version - $appversion")
    larger(25,35)

    val st = isVpnEnabled("disconnected")
    println("status $st")
}
fun large(a:Int,b:Int){
    if (a>b){
        println("larger number is $a")
    }
    else{
        println("larger number is $b")
    }

}
fun larger(a :Int,b :Int){
    when (a>b){
        true -> println("larger number is $a")
        else -> println("larger number is $b")
    }
}
fun isVpnEnabled(status: String): Boolean{
    when (status){
        "connected" -> return true
        else -> return false
    }
}