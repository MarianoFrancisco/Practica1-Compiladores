package com.mariano.practica1compiladores

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.charts.Pie
import com.anychart.core.ui.table.Column
import com.google.android.material.progressindicator.CircularProgressIndicator
import lector.Leer
import java.util.ArrayList


class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val realizarGrafica=findViewById<Button>(R.id.realizarGrafica)
        realizarGrafica.setOnClickListener{
            val intent:Intent=Intent(this,InsertarTexto::class.java)
            startActivity(intent)
        }



    }

}

