package com.lymors.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wa.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.lymors.myprojact.databinding.FragmentHomeBinding
import com.lymors.myprojact.settingActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragments = listOf(AllFragmant(), BlankFragment2(), BlankFragment3(), BlankFragment4(), BlankFragment5(), BlankFragment6())

        val adapter = ViewPagerAdapter(requireActivity(), fragments)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.TabLayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Food"
                2 -> tab.text = "shoes"
                3 -> tab.text = "cloth"
                4 -> tab.text = "Grocer"
                5 -> tab.text = "pharmacy"
            }
        }.attach()

    }



}
