package com.san22.task

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlideAdpater(Fragment: FragmentActivity): FragmentStateAdapter(Fragment)
{

    override fun getItemCount()=2



    override fun createFragment(position: Int): Fragment =when(position){
        0->Login()
        else->SignUp()
    }


}