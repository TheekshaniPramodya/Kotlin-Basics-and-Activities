package com.example.activity1.ui.theme

class Server(val country:String,val ip:String){
    fun connect(){
        println("connecting to $country server at $ip")
    }
}
fun main(){
    val japaneseServer = Server("japan","192.13.01.01")
    japaneseServer.connect()
}