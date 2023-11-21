package com.example.nosfaltauno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nosfaltauno.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Login : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityLoginBinding
    //Firebase Auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Nuevo metodo con firebase
        auth = Firebase.auth

        //Login al activar el boton
        binding.btnInLogin.setOnClickListener {

            //Recuperar el correo y la contraseña
            val correo = binding.etEmail.text.toString()
            val contrasena = binding.etPassword.text.toString()

            if (correo.isEmpty()) {
                binding.etEmail.error = "Ingresa un correo"
                return@setOnClickListener
            }
            if (contrasena.isEmpty()) {
                binding.etPassword.error = "Ingrese una contraseña"
            }

            //Iniciar Sesion
            signIn(correo, contrasena)

        }
    }
    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    Toast.makeText(this,"Inicio de sesion exitoso", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, InicioUsuario::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"Inicio de sesion invalido", Toast.LENGTH_LONG).show()
                }
            }
    }

}