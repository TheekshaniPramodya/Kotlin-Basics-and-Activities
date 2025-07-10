package com.example.activity1.ui.theme

data class  VpnServer(val name:String,val ip:String,val countryCode:String?)

fun ccnull(country:VpnServer){
    if(country.countryCode != null){
        println("Connecting to ${country.name},${country.countryCode}")
    }
    else{
        println("Connecting to ${country.name}")
    }
}
fun main(){
    val a = VpnServer("india","123.123.123.123","023")
    val b= VpnServer("japan","412.412.412.412","456")
    val c = VpnServer("uk","456.456.456.456",null)
    ccnull(a)
    ccnull(b)
    ccnull(c)

}