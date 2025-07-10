package com.example.activity1.ui.theme



fun main() {
    val msg = greetUser("Thinula")
    val msg2 = talkUser("theekshani")
    println(msg)
    println(msg2)
}


fun greetUser(username: String): String {
    return "Hello, $username!"
}

fun talkUser(username: String): String{
    return "welcome , $username"
}