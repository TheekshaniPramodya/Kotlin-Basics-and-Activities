package com.example.activity1.ui.theme

fun checkStatus(status: String) {
    if (status == "connected") {
        println("VPN is active")
    } else {
        println("VPN is inactive")
    }
// Same thing using `when`:
    when (status) {
        "connected" -> println("You're online")
        "disconnected" -> println("You're offline")
        else -> println("Unknown state")
    }
}

fun main(){
    checkStatus("connected")

}
