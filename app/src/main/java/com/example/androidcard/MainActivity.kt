package com.example.androidcard

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import com.example.androidcard.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val model : CardViewModel by viewModels()
        model.setCard(MainCategories.getMainCategory())
        model.setColor("black")
        //model.setMaincatIcon("1")
        val listGroups=ArrayList<Group>()
        if(!model.getCard().subCat.isEmpty()){
            val ungrouped=Group(
                name = "Ungrouped",
                subCat=model.getCard().subCat,
                ungroup = true
            )
            listGroups.add(ungrouped)
            model.getCard().group.forEach { listGroups.add(it) }
        }else{
            model.getCard().group.forEach { listGroups.add(it) }
        }
        var groupIcon: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_ungroup, null)

        val adapter = MainAdapter(listGroups, groupIcon, model.getColor())
        binding?.groupArea?.adapter=adapter

        binding?.textMainCat?.text=model.getCard().name
        var drawableUp: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_chevron_up, null)
        var drawableDown: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_chevron_down, null)
        binding?.chevronButton?.setOnClickListener {
            if(model.getVisible()){
                binding?.chevronButton?.setCompoundDrawablesWithIntrinsicBounds(drawableUp,null,null,null)
            }else{
                binding?.chevronButton?.setCompoundDrawablesWithIntrinsicBounds(drawableDown,null,null,null)
            }
            binding?.groupArea?.isVisible=model.getVisible()
            model.visible()
        }

        binding?.maincatIcon?.isVisible=model.hasMaincatIcon()
        var maincatIcon1: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_maincat1, null)
        if(model.hasMaincatIcon()){
            if(model.getMaincatIcon()=="1"){
                binding?.maincatIcon?.setImageDrawable(maincatIcon1)
            }
            binding?.maincatIcon?.setColorFilter(Color.parseColor(model.getColor()))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}