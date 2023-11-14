package com.example.nosfaltauno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buscar el boton
        val btnMenuLogin = findViewById<Button>(R.id.btn_menu_login)

        //Funcion para el boton
        btnMenuLogin.setOnClickListener {
            //Llamar a la segunda vista
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}