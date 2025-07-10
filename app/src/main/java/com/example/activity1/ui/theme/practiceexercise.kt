package com.example.activity1.ui.theme

data class ServerConfig(val name:String, val ip: String)

fun main(){
    val serverConfigs =listOf(ServerConfig("japan","192.168.10.2"), ServerConfig("india","192.168.20.2"),
        ServerConfig("uk","192.168.30.2"))
    for((index,config) in serverConfigs.withIndex()){
        println("${index+1}.${config.name}.${config.ip}")
        connect(config)
    }

}
fun connect(config: ServerConfig) = println("trying to connect to ${config.name}")