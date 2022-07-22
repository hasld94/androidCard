package com.example.androidcard

object MainCategories {

    fun getMainCategory():Card {
        //val mainCatList =ArrayList<Card>()

        val group1=Group(
            name = "Group1",
            subCat= arrayListOf("Subcat 1", "Subcat 2", "Subcat 3", "Subcat 4")
        )
        val group2=Group(
            name = "Group2",
            subCat=arrayListOf("Subcat 21", "Subcat 22", "Subcat 23", "Subcat 24")
        )
        val group3=Group(
            name = "Group3",
            subCat=arrayListOf("Subcat 31", "Subcat 32", "Subcat 33", "Subcat 34")
        )

        return Card(
            id = "asfdaf",
            name = "MainCat1",
            group=arrayListOf(group1, group2, group3),
            subCat = arrayListOf("NoGroupCat 1", "NoGroupCat 2")
        )
    }


}