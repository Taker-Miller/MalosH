package com.seba.malosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var titleText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculación de las vistas
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)
        titleText = findViewById(R.id.titleText)

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
                registerButton.visibility = View.GONE
                titleText.visibility = View.GONE

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
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
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
        registerButton.visibility = View.VISIBLE
        titleText.visibility = View.VISIBLE

        // Quitar el fragmento de menú
        supportFragmentManager.popBackStack()
    }
}
