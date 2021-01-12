package com.example.hypddemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BestDealsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var viewPager2: ViewPager2
    lateinit var myView : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_best_deals, container, false)
        viewPager2 = myView.findViewById(R.id.dealVP)

        val deal_list = mutableListOf<BestDeal>()

        deal_list.add(BestDeal(R.drawable.mic))
        deal_list.add(BestDeal(R.drawable.moon))
        deal_list.add(BestDeal(R.drawable.leaf))
        deal_list.add(BestDeal(R.drawable.shoes))
        deal_list.add(BestDeal(R.drawable.camera))
//
//        deal_list.add(BestDeal("BestDeals-1"))
//        deal_list.add(BestDeal("BestDeals-2"))
//        deal_list.add(BestDeal("BestDeals-3"))
//        deal_list.add(BestDeal("BestDeals-4"))
//        deal_list.add(BestDeal("BestDeals-5"))
//        deal_list.add(BestDeal("BestDeals-6"))
//        deal_list.add(BestDeal("BestDeals-7"))
//        deal_list.add(BestDeal("BestDeals-8"))



        viewPager2.adapter = BestDealsAdapter(deal_list)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3

        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{page , position ->
            val r = 1- kotlin.math.abs(position)
            page.scaleY = 0.85f + r*0.25f
            page.scaleX = 0.85f + r*0.25f
        }
        viewPager2.setPageTransformer(compositePageTransformer)




        return myView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BestDealsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}