package com.example.contactosmaterial

package com.tu_paquete // ¡CAMBIA ESTO POR TU PAQUETE!

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvFecha = findViewById<TextView>(R.id.tvFecha)
        val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        val nombre = intent.getStringExtra("NOMBRE") ?: ""
        val fecha = intent.getStringExtra("FECHA") ?: ""
        val telefono = intent.getStringExtra("TELEFONO") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val descripcion = intent.getStringExtra("DESCRIPCION") ?: ""

        tvNombre.text = "Nombre: $nombre"
        tvFecha.text = "Fecha Nacimiento: $fecha"
        tvTelefono.text = "Tel: $telefono"
        tvEmail.text = "Email: $email"
        tvDescripcion.text = "Descripción: $descripcion"

        btnEditar.setOnClickListener {
            val intentEditar = Intent(this, FormularioActivity::class.java).apply {
                putExtra("NOMBRE", nombre)
                putExtra("FECHA", fecha)
                putExtra("TELEFONO", telefono)
                putExtra("EMAIL", email)
                putExtra("DESCRIPCION", descripcion)
            }
            startActivity(intentEditar)
            finish()
        }
    }
}