package com.example.androidcard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcard.databinding.RecyclerviewItemBinding


class MainAdapter(val subCat: Array<String>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
 inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding)
     :RecyclerView.ViewHolder(itemBinding.root) {
     fun bindItem(subCat: String) {
         itemBinding.ungrouped.text = subCat
     }
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val card = subCat[position]
        holder.bindItem(card)
    }

    override fun getItemCount(): Int {
        return subCat.size
    }
}