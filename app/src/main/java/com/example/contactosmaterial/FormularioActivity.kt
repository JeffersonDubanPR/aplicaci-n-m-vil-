package com.tu_paquete // ¡CAMBIA ESTO POR TU PAQUETE!

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: TextInputEditText
    private lateinit var etFecha: TextInputEditText
    private lateinit var etTelefono: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etDescripcion: TextInputEditText
    private lateinit var btnSiguiente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etFecha = findViewById(R.id.etFecha)
        etTelefono = findViewById(R.id.etTelefono)
        etEmail = findViewById(R.id.etEmail)
        etDescripcion = findViewById(R.id.etDescripcion)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        recibirDatosParaEditar()

        etFecha.setOnClickListener {
            mostrarSelectorFecha()
        }

        btnSiguiente.setOnClickListener {
            irAConfirmacion()
        }
    }

    private fun mostrarSelectorFecha() {
        val calendario = Calendar.getInstance()
        val anio = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val mesFormateado = String.format("%02d", month + 1)
            val diaFormateado = String.format("%02d", dayOfMonth)
            etFecha.setText("$diaFormateado/$mesFormateado/$year")
        }, anio, mes, dia)
        datePicker.show()
    }

    private fun irAConfirmacion() {
        val intent = Intent(this, ConfirmacionActivity::class.java).apply {
            putExtra("NOMBRE", etNombre.text.toString())
            putExtra("FECHA", etFecha.text.toString())
            putExtra("TELEFONO", etTelefono.text.toString())
            putExtra("EMAIL", etEmail.text.toString())
            putExtra("DESCRIPCION", etDescripcion.text.toString())
        }
        startActivity(intent)
    }

    private fun recibirDatosParaEditar() {
        if (intent.hasExtra("NOMBRE")) {
            etNombre.setText(intent.getStringExtra("NOMBRE"))
            etFecha.setText(intent.getStringExtra("FECHA"))
            etTelefono.setText(intent.getStringExtra("TELEFONO"))
            etEmail.setText(intent.getStringExtra("EMAIL"))
            etDescripcion.setText(intent.getStringExtra("DESCRIPCION"))
        }
    }
}