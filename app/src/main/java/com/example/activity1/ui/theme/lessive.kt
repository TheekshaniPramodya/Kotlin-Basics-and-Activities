package com.example.activity1.ui.theme

var countryCode: String? =null
class VpnConfig(val  fileName:String,val path :String){
    fun  printDetails(fileName: String,path: String){
        println("${fileName}")
        println("${path}")
    }
}
fun accept(value:Any){
    if(value is String){
        println("${value.length}")
    }
}
fun main(){
    countryCode="abc"
    if (countryCode!=null){
        println("$countryCode")
    }else{
        println("Defaulting to GLOBAL")
    }
    val a= VpnConfig("abc","abc")
    a.printDetails("abc","abc")
    accept(123)
    accept("abcd")
}