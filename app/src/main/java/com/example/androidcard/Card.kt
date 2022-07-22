package com.example.androidcard

fun main(){

}
class Group(
    val name:String,
    var subCat:ArrayList<String>,
    var ungroup:Boolean?=false
)

data class Card (
    val id: String,
    val name:String,
    var group:ArrayList<Group>,
    var subCat:ArrayList<String>,
) {

}
