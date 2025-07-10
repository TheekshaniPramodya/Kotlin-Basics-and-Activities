package com.example.activity1.ui.theme

data class Servers(val name : String, val ip: String,val location :String )
fun main(){
    val serverone = listOf(Servers("japan","123.123.123.123","japan"),Servers("india","123.123.123.123","india"),Servers("uk","123.123.123.123","uk"))
    for((index,server)in serverone.withIndex()){
        println("${index+1}.$server ")
    }
}