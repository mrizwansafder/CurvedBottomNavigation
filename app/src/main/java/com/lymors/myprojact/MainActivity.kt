package com.lymors.myprojact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.lymors.myprojact.databinding.ActivityMainBinding
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    companion object {
        val HOME_ITEM = R.id.homeFragment
        val OFFERS_ITEM = R.id.favoriteFragment
        val MORE_ITEM = R.id.storeFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            initNavHost()
            setUpBottomNavigation()

            binding!!.imeg.setOnClickListener {
                if (binding!!.DrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding!!.DrawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    binding!!.DrawerLayout.openDrawer(GravityCompat.START)
                }
            }


        }

    }


    private fun ActivityMainBinding.setUpBottomNavigation() {
        val bottomNavigationItems = mutableListOf(
            CurvedBottomNavigation.Model(HOME_ITEM, getString(R.string.home), R.drawable._01_home),
            CurvedBottomNavigation.Model(MORE_ITEM, getString(R.string.more), R.drawable.offers),
            CurvedBottomNavigation.Model(OFFERS_ITEM, getString(R.string.offers), R.drawable.baseline_heart_broken_24),
            )
        bottomNavigation.apply {
            bottomNavigationItems.forEach { add(it) }
            setOnClickMenuListener {
                navController.navigate(it.id)
            }
            setupNavController(navController)
        }
    }


    private fun initNavHost() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        if (navController.currentDestination!!.id == HOME_ITEM)
            super.onBackPressed()
        else {
            when (navController.currentDestination!!.id) {
                OFFERS_ITEM -> {
                    navController.popBackStack(R.id.favoriteFragment, false)
                }
                MORE_ITEM -> {
                    navController.popBackStack(R.id.storeFragment, false)
                }
                HOME_ITEM -> {
                    navController.popBackStack(R.id.homeFragment, false)
                }
                else -> {
                    navController.navigateUp()
                }
            }
        }
           }
        }



//}