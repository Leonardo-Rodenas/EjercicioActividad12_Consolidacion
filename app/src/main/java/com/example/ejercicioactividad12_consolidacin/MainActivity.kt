package com.example.ejercicioactividad12_consolidacin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navegador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navhost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragContainer) as NavHostFragment
        navegador = navhost.navController;

        NavigationUI.setupActionBarWithNavController(this, navegador)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navegador, null)
    }


}