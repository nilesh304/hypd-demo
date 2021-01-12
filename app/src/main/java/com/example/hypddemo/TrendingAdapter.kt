package com.example.hypddemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrendingAdapter(val trendings : List<Trending>) : RecyclerView.Adapter<TrendingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.items_trending ,parent , false)
        return TrendingViewHolder(view)



    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
//        holder.categoryTitle.text = categories[position].title
        var clicked=false;
        holder.categoryDesc.text = trendings[position].description
        holder.trendsIv.setOnClickListener{
            if(!clicked) {
                clicked=true
                holder.trendsIv.setColorFilter(Color.argb(255, 255, 0, 0))
            }
            else {
                clicked=false
                holder.trendsIv.setColorFilter(Color.argb(255, 0, 0, 0))
            }
        }
    }

    override fun getItemCount(): Int {
        return trendings.size

    }
}

class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

//    var categoryTitle = itemView.findViewById<TextView>(R.id.categoryTitle)
    var categoryDesc = itemView.findViewById<TextView>(R.id.trendsDesc)
    var trendsIv = itemView.findViewById<ImageView>(R.id.trendsIv)

}
