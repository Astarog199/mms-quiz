package com.moneymanagementservices.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moneymanagementservices.quiz.databinding.ActivityMainBinding
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.fragment_container)
        val toolbar = findNavController(R.id.fragment_container)

        val colorStateList = ContextCompat.getColorStateList(this, R.color.icon_state)
        navView.itemIconTintList = colorStateList
        navView.itemTextColor = colorStateList

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(toolbar, appBarConfiguration)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_start, R.id.navigation_list
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}