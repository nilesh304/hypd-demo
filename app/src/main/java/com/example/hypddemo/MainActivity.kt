package com.example.hypddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fm = supportFragmentManager
        fm.beginTransaction().apply {
            replace(R.id.fragment_placeholder2 , BestDealsFragment())
            replace(R.id.fragment_placeholder1 , CategoryFragment())
            commit()
        }



    }
}