package com.example.androidcard

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    private var visible:Boolean=true;
    private var color:String="black";
    private var hasMaincatIcon:Boolean=false;
    private var maincatIcon:String="";
    private var card:Card=Card("","", arrayListOf(), arrayListOf());

    fun getCard():Card{
        return card
    }

    fun setCard(Card:Card){
        card=Card
    }

    fun getVisible():Boolean{
        return !visible
    }

    fun visible(){
        visible=!visible;
    }

    fun setColor(Color:String){
        color=Color
    }

    fun getColor():String{
       return color
    }

    fun setMaincatIcon(MaincatIcon:String){
        hasMaincatIcon=true
        maincatIcon=MaincatIcon
    }

    fun getMaincatIcon():String{
        return maincatIcon
    }
    fun hasMaincatIcon():Boolean{
        return hasMaincatIcon
    }

}