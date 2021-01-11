package com.example.hypddemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CategoryFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        val v = inflater.inflate(R.layout.fragment_category, container, false)

        val categories = mutableListOf<Category>()
        categories.add(Category("Item1" , "Title1"))
        categories.add(Category("Item2" , "Title2"))
        categories.add(Category("Item3" , "Title3"))
        categories.add(Category("Item4" , "Title4"))
        categories.add(Category("Item5" , "Title5"))
        categories.add(Category("Item6" , "Title6"))



        val rv = v.findViewById<RecyclerView>(R.id.categoryRV)
        val lm = LinearLayoutManager(this.context , LinearLayoutManager.HORIZONTAL ,false)

        rv.adapter = CategoryAdapter(categories)
        rv.layoutManager = lm




        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}