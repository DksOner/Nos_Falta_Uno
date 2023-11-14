package com.example.nosfaltauno

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nosfaltauno.databinding.ActivityInicioUsuarioBinding
import com.example.nosfaltauno.databinding.ActivityMainBinding
import com.example.nosfaltauno.vistas.SettingFragment
import com.example.nosfaltauno.vistas.arriendosFragment
import com.example.nosfaltauno.vistas.canchasFragment
import com.example.nosfaltauno.vistas.equipoFragment
import com.example.nosfaltauno.vistas.notificacionFragment

class InicioUsuario : AppCompatActivity() {

    //Configurar viewBinding
    private lateinit var binding: ActivityInicioUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, canchasFragment()).commit()
        }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_canchas -> {
                    //Indicamos que hacer -> mostrar el fragment de Canchas
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, canchasFragment()).commit()
                    true
                }
                R.id.nav_arriendos -> {
                    //Indicamos que hacer -> mostrar el fragment de Canchas
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, arriendosFragment()).commit()
                    true
                }
                R.id.nav_equipos -> {
                    //Indicamos que hacer -> mostrar el fragment de Canchas
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, equipoFragment()).commit()
                    true
                }
                R.id.nav_notificaciones -> {
                    //Indicamos que hacer -> mostrar el fragment de Canchas
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, notificacionFragment()).commit()
                    true
                }
                R.id.nav_opciones -> {
                    //Indicamos que hacer -> mostrar el fragment de Canchas
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, SettingFragment()).commit()
                    true
                }

                else -> false
            }
        }




    }


}

