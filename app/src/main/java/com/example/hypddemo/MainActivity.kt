package com.example.hypddemo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var tabsPagerAdapter: TabsPagerAdapter

    var tabTitle = arrayOf("Shopping", "Tasks", "Views" , "Shopping")






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)


//        val fm = supportFragmentManager
//        fm.beginTransaction().apply {
//            replace(R.id.fragment_placeholder2 , BestDealsFragment())
//            replace(R.id.fragment_placeholder1 , CategoryFragment())
//            commit()
//        }


//        tabsPagerAdapter = TabsPagerAdapter(getSupportFragmentManager())
//        viewPager2.setAdapter(tabsPagerAdapter)
//        tabLayout.setupWithViewPager(viewPager2)


//        --------------------------------------------------------------________----------------------


//        val mytabsadapter = MyTabsViewPagerAdapter(this, supportFragmentManager,
//                3)
//
//        viewPager2.adapter = mytabsadapter
//
//        viewPager2.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                viewPager2.currentItem = tab.position
////                when(tab.position){
////                    0 -> scanappBar
////                }
//
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })
//        createCustomTab()

//        -------------------------------------___________________-----------------------______________----------

        viewPager2.adapter = TabsPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager2)
        createCustomTab()




    }

    fun createCustomTab() {
        val tabCount = tabLayout.tabCount
        for (i in 0 until tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.setCustomView(R.layout.custom_tab)
            val view: View? = tab!!.customView
            val title : TextView? = view?.findViewById(R.id.tabTitle)
            title?.text = tabTitle[i]
        }
    }

    @Suppress("DEPRECATION")
    internal class MyTabsViewPagerAdapter(
            var context: Context,
            fm: FragmentManager,
            var totalTabs: Int
    ) :
            FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    ShoppingFragment()
                }
                1 -> {
                    CategoryFragment()

                }
                2 ->{
                    BestDealsFragment()
//                    getItem(position)
                }

                else -> getItem(position)
            }
        }
        override fun getCount(): Int {
            return totalTabs
        }
    }
}