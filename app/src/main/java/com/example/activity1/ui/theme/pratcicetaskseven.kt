package com.example.activity1.ui.theme
import java.io.File
val servers= mutableListOf("japan.json","USA.json")

fun loop(){
    for(server in servers){
        println("server - $server")
    }
}
fun main(){
    loop()
}