package com.example.nosfaltauno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Buscar el boton
        val btnIngresarLogin = findViewById<Button>(R.id.btn_In_login)

        //Funcion para el boton
        btnIngresarLogin.setOnClickListener {
            //Llamar a la segunda vista

            try {
                val usuario: String = findViewById<EditText>(R.id.etUsuario).text.toString()
                val contrasenia: String = findViewById<EditText>(R.id.etContrasenia).text.toString()

                if (usuario.isNotEmpty()) {
                    if (contrasenia.isNotEmpty()) {
                        if (usuario.equals("test")) {
                            if (contrasenia.equals("123456")) {
                                val intent = Intent(this, InicioUsuario::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this,"La contraseña no es valida", Toast.LENGTH_LONG).show()
                            }
                        }else{
                            Toast.makeText(this,"El usuario no es valido", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this,"No hay contraseña", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this,"No hay usuario", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.e("Error enviarNombre", e.message.toString())
            }

        }

    }
}