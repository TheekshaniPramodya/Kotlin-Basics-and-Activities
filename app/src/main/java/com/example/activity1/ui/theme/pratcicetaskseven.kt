package com.example.activity1.ui.theme
import java.io.File
val servers= mutableListOf("japan.json","USA.json")

fun loop(){
    for(server in servers){
        println("server - $server")
        val file=File(server)
        file.writeText("{ \\\"log\\\": { \\\"level\\\": \\\"info\\\" } }")
        val content = file.readText()
        println(content)
    }
}
fun main(){
    loop()
}