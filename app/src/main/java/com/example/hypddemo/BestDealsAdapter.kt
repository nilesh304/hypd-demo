package com.example.hypddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BestDealsAdapter(val deals : List<BestDeal>) : RecyclerView.Adapter<BestDealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestDealViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_deals ,parent , false)
//        val view = inflater.inflate(R.layout.item_deals_v2 ,parent , false)

        return BestDealViewHolder(view)



    }

    override fun onBindViewHolder(holder: BestDealViewHolder, position: Int) {
        holder.image.setBackgroundResource(deals[position].image)
//        holder.title.text = deals[position].title

    }

    override fun getItemCount(): Int {
        return deals.size

    }
}

class BestDealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var image = itemView.findViewById<ImageView>(R.id.deal_IV)
//    var title = itemView.findViewById<TextView>(R.id.dealsTitleV2)

}
