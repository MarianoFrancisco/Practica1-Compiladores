package com.mariano.practica1compiladores

import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import java.util.ArrayList


class Grafico {
    public fun configurarGraficoBarra(grafico : AnyChartView?, elemento: ArrayList<String>, valorElemento:ArrayList<String>,titulo:String){
        val barra = AnyChart.column()
        val datoGraficoBarra: MutableList<DataEntry> = mutableListOf()
        for (index in valorElemento.indices){
            datoGraficoBarra.add(ValueDataEntry(elemento.elementAt(index),Integer.parseInt(valorElemento.elementAt(index)) ))
        }
        barra.data(datoGraficoBarra)
        barra.title(titulo)
        grafico!!.setChart(barra)

    }

    public fun configurarGraficoCircular(grafico : AnyChartView?, elemento: ArrayList<String>, valorElemento:ArrayList<String>,titulo:String){
        val circular = AnyChart.pie()
        val datoGraficoCircular: MutableList<DataEntry> = mutableListOf()
        for (index in valorElemento.indices){
            datoGraficoCircular.add(ValueDataEntry(elemento.elementAt(index),Integer.parseInt(valorElemento.elementAt(index))))
        }
        circular.data(datoGraficoCircular)
        circular.title(titulo)

        grafico!!.setChart(circular)
    }
}