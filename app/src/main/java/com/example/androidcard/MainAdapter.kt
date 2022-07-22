package com.example.androidcard

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcard.databinding.RecyclerviewItemgroupBinding


class MainAdapter(val group: ArrayList<Group>, val groupIcon: Drawable?, val color:String?):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val itemBinding: RecyclerviewItemgroupBinding)
     :RecyclerView.ViewHolder(itemBinding.root) {
     fun bindItem(group: Group) {
         val adapter=SubcatAdapter(group.subCat)
         itemBinding.group.text = group.name
         if(group.ungroup==true){
             itemBinding.groupIcon.setImageDrawable(groupIcon)
         }
         itemBinding.groupIcon.setColorFilter(Color.parseColor(color))
         itemBinding.subcatArea.adapter=adapter

     }
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemgroupBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val card = group[position]
        holder.bindItem(card)
    }

    override fun getItemCount(): Int {
        return group.size
    }
}