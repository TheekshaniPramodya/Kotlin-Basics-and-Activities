package com.example.activity1.ui.theme

fun main(){
    val user ="theekshani"
    val configs = listOf("japan.json","germany.json","USA.json")
    println ("welcome $user")
    println("available configs")

    for ((index,config) in configs.withIndex()){
        println("${index+1}.$config")
    }
    println("Choose one to connect (1-3):")
    val choice = 2  // simulate user input
    println("Connecting to ${configs[choice - 1]} ...")
}