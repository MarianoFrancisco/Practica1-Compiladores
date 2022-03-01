package com.mariano.practica1compiladores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import lector.DatosGrafica
import lector.Leer
import java.util.ArrayList

class InsertarTexto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_texto)
        val textoIngresado = findViewById<EditText>(R.id.textoUsuario)
        val cupFlex =  findViewById<Button>(R.id.cupFlex)
        cupFlex.setOnClickListener{
            var leer = Leer()
            leer.Leyendo(textoIngresado.getText().toString())
            val intent: Intent = Intent(this,MostrarGraficos::class.java)
            startActivity(intent)
            DatosGrafica.datosGrafica.setContador(0)
        }
    }

}