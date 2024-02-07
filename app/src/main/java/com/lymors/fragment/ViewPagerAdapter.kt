package com.example.wa


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lymors.fragment.HomeFragment
import com.lymors.fragment.StoreFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity,private val fragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}