package com.example.hypddemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TrendingFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_trending, container, false)

        val trendings = mutableListOf<Trending>()
        trendings.add(Trending("1","Item 1"))
        trendings.add(Trending("2","Item 2"))
        trendings.add(Trending("3","Item 3"))
        trendings.add(Trending("4","Item 4"))
        trendings.add(Trending("5","Item 5"))
        trendings.add(Trending("6","Item 6"))
        trendings.add(Trending("7","Item 7"))
        trendings.add(Trending("8","Item 8"))
        trendings.add(Trending("9","Item 9"))


        val rv = v.findViewById<RecyclerView>(R.id.trendingRV)
        val lm = LinearLayoutManager(this.context , LinearLayoutManager.HORIZONTAL ,false)

        rv.adapter = TrendingAdapter(trendings)
        rv.layoutManager = lm


        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                TrendingFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}