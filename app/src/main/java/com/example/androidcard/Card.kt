package com.example.androidcard

fun main(){

}
class Group(
    val name:String,
    var subCat:Array<String>
)

data class Card (
    val id: String,
    val name:String,
    var group:Array<Group>,
    var subCat:Array<String>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (id != other.id) return false
        if (name != other.name) return false
        if (!subCat.contentEquals(other.subCat)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + subCat.contentHashCode()
        return result
    }
}
