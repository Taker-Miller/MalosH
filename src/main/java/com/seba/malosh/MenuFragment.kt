package com.seba.malosh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        // Botón para cerrar sesión
        val cerrarSesionButton = view.findViewById<Button>(R.id.buttonCerrarSesion)
        cerrarSesionButton.setOnClickListener {
            (activity as? MainActivity)?.logout()
        }

        return view
    }
}
