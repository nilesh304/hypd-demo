package com.example.hypddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val categories : List<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.items_category ,parent , false)
        return CategoryViewHolder(view)



    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].title
        holder.categoryDesc.text = categories[position].description

    }

    override fun getItemCount(): Int {
        return categories.size

    }
}

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var categoryTitle = itemView.findViewById<TextView>(R.id.categoryTitle)
    var categoryDesc = itemView.findViewById<TextView>(R.id.categoryDesc)

}

