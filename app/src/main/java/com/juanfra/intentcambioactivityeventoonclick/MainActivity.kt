package com.juanfra.intentcambioactivityeventoonclick

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 07/10/2024
Clase: Actividad principal que recoge el texto (nombre) del usuario y se lo pasamos a una
segunda actividad con un Intent, controlando el evento onClick del botón
*/

class MainActivity : AppCompatActivity() {

    lateinit var etNombre: EditText
    lateinit var btnSaludar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Instanciamos los controles
        etNombre = findViewById(R.id.et_textoNombre)
        btnSaludar = findViewById(R.id.button)

        // Listener del evento OnClick del botón
        btnSaludar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, ActivitySec::class.java)
                intent.putExtra("nombre", etNombre.text.toString())
                startActivity(intent)
            }

        })
    }
}