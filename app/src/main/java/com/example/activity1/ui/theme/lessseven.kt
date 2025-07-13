package com.example.activity1.ui.theme

import java.io.File

val mutableconfig= mutableListOf("japan.json","uk.json","india.json")
fun main(){
    mutableconfig.add("usa.json")
    for(fl in mutableconfig){
        println("$fl")
    }
    saveConfig("japan.json","abcd")
    loadConfig("japan.json")
    saveConfig("india.json","abcde")
    loadConfig("usa.json")
    val b= loadConfig("japan.json")
    val c= loadConfig("india.json")
    println("$b ")
}
fun saveConfig(fileName: String, content: String){
    val file = File(fileName)
    file.writeText(content)
}
fun loadConfig(fileName: String): String{
    val file=File(fileName)
    val content =file.readText()
    return content
}