package com.mariano.practica1compiladores

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChartView
import lector.DatosGrafica
import lector.DatosReportes

class MostrarGraficos : AppCompatActivity() {
    private var tipoParcial:String=""
    private var totalParcial:String=""
    private var extraParcial:String=""
    private var tituloComparacion: ArrayList<String> =  ArrayList()
    private var tipoDeGrafica: ArrayList<String> =  ArrayList()
    private var elementoParcial: ArrayList<String> =  ArrayList()
    private var elementoParcial2: ArrayList<String> = ArrayList()
    private var elementoParcial3: ArrayList<String> =  ArrayList()
    private var elementoParcial4: ArrayList<String> = ArrayList()
    private var textoParcialGrafica: ArrayList<String> =  ArrayList()
    private var cantidadParcialGrafica: ArrayList<String> = ArrayList()
    private var tipoDeGraficaParcial:String=""
    private var extraPie: ArrayList<String> =  ArrayList()
    private var totalPie: ArrayList<String> =  ArrayList()
    private var tipoPie: ArrayList<String> =  ArrayList()
    private var titulo:String = ""
    private var grafico : AnyChartView?=null
    private var contador:Int = 0
    private var a:Int=DatosGrafica.datosGrafica.ejecutar.size
    private var b:Int=DatosGrafica.datosGrafica.tituloGrafica.size
    private var c:Int=DatosGrafica.datosGrafica.barraEjeY.size
    private var d:Int=DatosGrafica.datosGrafica.barraEjeX.size
    private var e:Int=DatosGrafica.datosGrafica.barraUnir.size
    private var f:Int=DatosGrafica.datosGrafica.totalPie.size
    private var g:Int=DatosGrafica.datosGrafica.tipoGraficaPie.size
    private var h:Int=DatosGrafica.datosGrafica.extraPie.size
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_graficos)
        var reportes = findViewById<Button>(R.id.reportes)
        var siguienteGrafica = findViewById<Button>(R.id.graficaAdelante)
        if(DatosGrafica.datosGrafica.contador<a-1){
            siguienteGrafica.setOnClickListener(){
                val intent: Intent = Intent(this,MostrarGraficos::class.java)
                startActivity(intent)
                DatosGrafica.datosGrafica.setContador(DatosGrafica.datosGrafica.contador+1)
                finish()
            }
        }else{siguienteGrafica.setOnClickListener(){
            val intent: Intent = Intent(this,MostrarGraficos::class.java)
            startActivity(intent)
            finish()
            }

        }
        val objetoIntent: Intent =intent
        grafico=findViewById<AnyChartView>(R.id.grafico)
        if(DatosReportes.datosReportes.getErrorEntrada()==0){
            if((a and b)>0){
                llenarTitulos()
                if((c and d and e)>0){
                    llenarDatos()
                    if(tipoDeGraficaParcial=="Pie"){
                        var graficoCircular= Grafico()
                        graficoCircular.configurarGraficoCircular(grafico, textoParcialGrafica ,cantidadParcialGrafica,titulo)

                    }else{
                        var graficoBarra= Grafico()
                        graficoBarra.configurarGraficoBarra(grafico, textoParcialGrafica,cantidadParcialGrafica,titulo)
                    }}
            }
        }
        reportes.setOnClickListener{
            val intent:Intent=Intent(this,CrearReportes::class.java)
            startActivity(intent)
        }
    }
    fun llenarTitulos(){
        for (i in (DatosGrafica.datosGrafica.tituloGrafica.size-1 downTo  0)) {
            for (j in (DatosGrafica.datosGrafica.tituloGrafica.get(i).size-1 downTo  0)) {
                if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.tituloGrafica.get(i).get(j))){
                    tituloComparacion.add(DatosGrafica.datosGrafica.tituloGrafica.get(i).get(j))
                    tipoDeGrafica.add(DatosGrafica.datosGrafica.tituloGrafica.get(i).get(j+1))
                }else{
                }
            }
        }
    }
    fun llenarDatos(){
        var verificador: String
        var verificador2: String
        DatosGrafica.datosGrafica.ejecutar

        for (i in 0 until tituloComparacion.size){
            if(DatosGrafica.datosGrafica.ejecutar.get(DatosGrafica.datosGrafica.contador).equals(tituloComparacion.get(i))){
                titulo=tituloComparacion.get(i);
                tipoDeGraficaParcial=tipoDeGrafica.get(i)
            }
        }

        for (i in (DatosGrafica.datosGrafica.barraEjeY.size-1 downTo  0)) {
            for (j in (DatosGrafica.datosGrafica.barraEjeY.get(i).size-1 downTo  0)) {
                if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.barraEjeY.get(i).get(j))){
                    elementoParcial.add(DatosGrafica.datosGrafica.barraEjeY.get(i).get(j+1))

                }else{

                }
            }
        }
        for (i in (DatosGrafica.datosGrafica.barraEjeX.size-1 downTo 0 )) {
            for (j in (DatosGrafica.datosGrafica.barraEjeX.get(i).size-1 downTo  0)) {
                if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.barraEjeX.get(i).get(j))){
                    elementoParcial2.add(DatosGrafica.datosGrafica.barraEjeX.get(i).get(j+1))
                }else{
                }
            }
        }
        for (i in (DatosGrafica.datosGrafica.barraUnir.size-1 downTo 0 )) {
            for (j in (DatosGrafica.datosGrafica.barraUnir.get(i).size-1 downTo  0)) {
                if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.barraUnir.get(i).get(j))){
                    elementoParcial3.add(DatosGrafica.datosGrafica.barraUnir.get(i).get(j+1))
                    elementoParcial4.add(DatosGrafica.datosGrafica.barraUnir.get(i).get(j+2))
                }else{
                }

            }
        }
        var x:Int
        var y:Int
        for (i in 0 until elementoParcial3.size){
            x=elementoParcial3.get(i).toInt()
            y=elementoParcial4.get(i).toInt()
            textoParcialGrafica.add(elementoParcial2.get(x))
            cantidadParcialGrafica.add(elementoParcial.get(y))
        }
        for (i in 0 until 2){
            System.out.println(textoParcialGrafica.get(i))
            System.out.println(cantidadParcialGrafica.get(i))
        }
        if((g and h)>0){
        if(tipoDeGraficaParcial=="Pie"){
            for (i in (DatosGrafica.datosGrafica.extraPie.size-1 downTo 0 )) {
                for (j in (DatosGrafica.datosGrafica.extraPie.get(i).size-1 downTo  0)) {
                    if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.extraPie.get(i).get(j))){
                        extraPie.add(DatosGrafica.datosGrafica.extraPie.get(i).get(j+1))
                        extraParcial=DatosGrafica.datosGrafica.extraPie.get(i).get(j+1)
                        System.out.println(extraParcial)
                    }else{
                    }
                }
            }


            for (i in (DatosGrafica.datosGrafica.tipoGraficaPie.size-1 downTo 0 )) {
                for (j in (DatosGrafica.datosGrafica.tipoGraficaPie.get(i).size-1 downTo  0)) {
                    if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.tipoGraficaPie.get(i).get(j))){
                        tipoPie.add(DatosGrafica.datosGrafica.tipoGraficaPie.get(i).get(j+1))
                        tipoParcial=DatosGrafica.datosGrafica.tipoGraficaPie.get(i).get(j+1)
                        System.out.println(tipoParcial)
                    }else{
                    }
                }
            }
            if(f>0){
            if(tipoParcial=="Cantidad"){
                for (i in (DatosGrafica.datosGrafica.totalPie.size-1 downTo 0 )) {
                    for (j in (DatosGrafica.datosGrafica.totalPie.get(i).size-1 downTo  0)) {
                        if(DatosGrafica.datosGrafica.getEjecutar().get(DatosGrafica.datosGrafica.contador).equals(DatosGrafica.datosGrafica.totalPie.get(i).get(j))){
                            totalPie.add(DatosGrafica.datosGrafica.totalPie.get(i).get(j+1))
                            totalParcial=DatosGrafica.datosGrafica.totalPie.get(i).get(j+1)
                            System.out.println(totalParcial)
                        }else{
                        }
                    }
                }
            }}}
        }
    }
}