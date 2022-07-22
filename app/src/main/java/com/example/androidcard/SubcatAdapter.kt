package com.example.androidcard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcard.databinding.RecyclerviewItemsubcatBinding


class SubcatAdapter(val subCat: ArrayList<String>):RecyclerView.Adapter<SubcatAdapter.MainViewHolder>() {
 inner class MainViewHolder(val itemBinding: RecyclerviewItemsubcatBinding)
     :RecyclerView.ViewHolder(itemBinding.root) {
     fun bindItem(subCat: String) {
         itemBinding.subcat.text = subCat
     }
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemsubcatBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val card = subCat[position]
        holder.bindItem(card)
    }

    override fun getItemCount(): Int {
        return subCat.size
    }
}