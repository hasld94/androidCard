package com.example.androidcard

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.androidcard.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MainAdapter(MainCategories.getMainCategory().subCat)

        binding?.groupArea?.adapter=adapter

        binding?.textMainCat?.text=MainCategories.getMainCategory().name
        var drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_chevron_down, null)
        binding?.chevronButton?.setOnClickListener {
            //binding?.chevronButton?.setCompoundDrawables(drawable,drawable,drawable,drawable)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}