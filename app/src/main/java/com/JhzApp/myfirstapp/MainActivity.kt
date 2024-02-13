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
import android.widget.ArrayAdapter
import android.widget.Spinner;
import android.widget.Toast;

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var number_1: EditText;
    private lateinit var number_2: EditText;
    private lateinit var result: TextView;
    private lateinit var spinner: Spinner;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        number_1=findViewById(R.id.number_1);
        number_2=findViewById(R.id.number_2);
        result=findViewById(R.id.textResultado);

        spinner = findViewById(R.id.spinner)
        val opciones = arrayOf("sumar", "restar", "multiplicar", "dividir", "verificar")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones)
        spinner.adapter = adapter



        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    fun operar(view: View)
    {
        val valor_1 = number_1.text.toString();
        val valor_2 = number_2.text.toString();
        val selector = spinner.selectedItem.toString();
        if (selector.equals("sumar"))
        {
            val suma = valor_1.toInt() + valor_2.toInt();
            result.setText(suma.toString());
        }
        else if(selector.equals("restar"))
        {
            val resta = valor_1.toInt() - valor_2.toInt();
            result.setText(resta.toString());
        }
        else if(selector.equals("multiplicar"))
        {
            val mult = valor_1.toInt() * valor_2.toInt();
            result.setText(mult.toString());
        }
        else if(selector.equals("dividir"))
        {
            val dividir = valor_1.toInt() / valor_2.toInt();
            result.setText(dividir.toString());
        }
        else if(selector.equals("verificar"))
        {
            val tamanio = number_2.text.toString();
            val tam2 = tamanio.length;
            if(tam2 == 0)
            {
                val noti = Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG)
                noti.show()
            }
        }

    }
}