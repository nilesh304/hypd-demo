package com.example.hypddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView





class TabsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                ShoppingFragment()
            }
            1 -> {
                CategoryFragment()
            }
            2 -> {
                BestDealsFragment()
            }
            3 -> {
                ShoppingFragment()
            }
            else ->  {
                ShoppingFragment()
            }
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> {return "Shopping"}
            1 -> {return "OtherTasks"}
            2 -> {return "Miscs"}
            3 -> {return "Shopping"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 4
    }
}








//class TabsPagerAdapter(val tabsPages : List<TabsPage>) : RecyclerView.Adapter<TabsPagerViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabsPagerViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.items_category ,parent , false)
//        return TabsPagerViewHolder(view)
//
//
//
//    }
//
//    override fun onBindViewHolder(holder: TabsPagerViewHolder, position: Int) {
////        holder.tabFrag = tabsPages[position].tabsPage
//
//    }
//
//    override fun getItemCount(): Int {
//        return tabsPages.size
//
//    }
//}
//
//class TabsPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//    var tabFrag = itemView.findViewById<FrameLayout>(R.id.tabsFragment)
//
//}
