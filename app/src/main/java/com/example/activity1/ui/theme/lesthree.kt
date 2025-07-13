package com.example.activity1.ui.theme

data class Serverr(val name : String, val ip: String,val location:String )
fun main(){
    val servers = listOf(Serverr("japan","123.123.123.123","japan"),Serverr("india","123.123.123.123","india"),Serverr("uk","123.123.123.123","uk"))
    for((index,server)in servers.withIndex()){
        println("${index+1}.$server ")
        connect(server)
    }
}
fun  connect(server:Serverr){
    println("Connecting to ${server.location} \n" +
            "server at ${server.ip}")
}