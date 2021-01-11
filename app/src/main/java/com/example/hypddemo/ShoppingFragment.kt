package com.example.hypddemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShoppingFragment : Fragment() {

    companion object {
        fun newInstance() = ShoppingFragment()
    }

    private lateinit var viewModel: ShoppingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fm = childFragmentManager
        fm.beginTransaction().apply {
            replace(R.id.frame1 , CategoryFragment())
            replace(R.id.frame2 , BestDealsFragment())
            replace(R.id.frame3 , TrendingFragment())
            replace(R.id.frame4 , CategoryFragment())
            commit()
        }
        return inflater.inflate(R.layout.shopping_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}