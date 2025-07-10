package com.example.activity1.ui.theme

var name: String?="th"

fun main(){
    val alength = name!!.length
    name=null
    val blength = name?.length
    val displayName = name?: "thp"
    println("Forced Length: $alength")
    println("Safe Length: $blength")
    println("Display Name: $displayName")
}