package com.san22.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.adapter=ScreenSlideAdpater(this)
        TabLayoutMediator(tabs,viewpager, TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
            when(position)
            {
                0->{
                    tab.text="Login"
                }
                1->{
                    tab.text="Create"
                }
            }

        }).attach()
    }
}