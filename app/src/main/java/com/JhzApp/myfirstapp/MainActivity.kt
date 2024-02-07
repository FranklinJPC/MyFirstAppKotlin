package com.JhzApp.myfirstapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.JhzApp.myfirstapp.databinding.ActivityMainBinding
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var number_1: EditText;
    private lateinit var number_2: EditText;
    private lateinit var result: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        number_1=findViewById(R.id.number_1);
        number_2=findViewById(R.id.number_2);
        result=findViewById(R.id.textResultado);


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    fun sumar(view: View){
        val n1=number_1.text.toString().toInt();
        val n2=number_2.text.toString().toInt();
        val suma=n1+n2;
        result.setText(suma.toString());
    }
}