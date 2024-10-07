package com.juanfra.intentcambioactivityeventoonclick

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 07/10/2024
Clase: Segunda actividad que recibe el texto (nombre) y lo muestra en un control TextView
*/

class ActivitySec : AppCompatActivity() {

    lateinit var tvNombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvNombre = findViewById(R.id.tvNombre)
        tvNombre.setText(getString(R.string.btn_text) + " " +  intent.extras?.getString("nombre"))
    }
}