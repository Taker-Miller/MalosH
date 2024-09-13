package com.seba.malosh

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var registerText: TextView
    private lateinit var titleText: TextView
    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculación de las vistas
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        registerText = findViewById(R.id.registerText)
        titleText = findViewById(R.id.titleText)
        fragmentContainer = findViewById(R.id.fragment_container)

        // Configurar la acción del botón de inicio de sesión
        loginButton.setOnClickListener {
            val inputUsername = username.text.toString()
            val inputPassword = password.text.toString()

            if (inputUsername == "a" && inputPassword == "1") {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Ocultar los elementos de la pantalla de login
                username.visibility = View.GONE
                password.visibility = View.GONE
                loginButton.visibility = View.GONE
                registerText.visibility = View.GONE
                titleText.visibility = View.GONE

                // Mostrar el contenedor del fragmento
                fragmentContainer.visibility = View.VISIBLE

                // Cargar el fragmento de menú
                loadFragment(MenuFragment())
            } else {
                if (inputUsername != "a") {
                    Toast.makeText(this, "Nombre de usuario incorrecto", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Acción para redirigir a la pantalla de registro
        registerText.setOnClickListener {
            // Aquí se puede cargar el fragmento de registro
            // loadFragment(RegisterFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    // Método para cerrar sesión y restaurar los campos de login
    fun logout() {
        // Mostrar los elementos de login nuevamente
        username.visibility = View.VISIBLE
        password.visibility = View.VISIBLE
        loginButton.visibility = View.VISIBLE
        registerText.visibility = View.VISIBLE
        titleText.visibility = View.VISIBLE

        // Ocultar el fragmento de menú
        fragmentContainer.visibility = View.GONE

        // Quitar el fragmento de menú
        supportFragmentManager.popBackStack()
    }
}
