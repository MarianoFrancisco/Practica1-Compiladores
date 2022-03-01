package com.mariano.practica1compiladores;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import lector.DatosReportes;
import lector.Leer;
import lector.TablaDinamica;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class CrearReportes extends AppCompatActivity {
    private TableLayout tablaGrafica,tablaGrafica2,tablaGrafica3;
    private String[]header={"Objeto","Cantidad de Definiciones"};
    private String[]headerOperadores={"Operador","Linea","Columna","Ejemplo de Ocurrencia"};
    private String[]headerErrores={"Lexema","Linea","Columna","Tipo","Descripcion"};
    private ArrayList<String[]> filas=new ArrayList<>();
    private ArrayList<String[]> filasOperadores=new ArrayList<>();
    private ArrayList<String[]> filasErrores=new ArrayList<>();
    private TextView textOperador;
    private TextView textGrafico;
    private TextView textError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_reportes);

        tablaGrafica=(TableLayout) findViewById(R.id.tablaReporteGrafico);
        tablaGrafica3=(TableLayout) findViewById(R.id.tablaReporteErrores);
        tablaGrafica2=(TableLayout) findViewById(R.id.tablaReporteOperadores);
        textOperador=(TextView) findViewById(R.id.textOperadores);
        textGrafico =(TextView) findViewById(R.id.textGrafico);
        textError=(TextView) findViewById(R.id.textErrores);
        TablaDinamica tablaDinamica=new TablaDinamica(tablaGrafica,getApplicationContext());
        TablaDinamica tablaDinamica2=new TablaDinamica(tablaGrafica2,getApplicationContext());
        TablaDinamica tablaDinamica3=new TablaDinamica(tablaGrafica3,getApplicationContext());
        if(DatosReportes.datosReportes.getErrorEntrada()==0){
            //ingreso datos
            tablaDinamica2.addHeader(headerOperadores);
            tablaDinamica2.addData(conseguirReporteOperadores());
            //definicion colores operadores
            tablaDinamica2.fondo(Color.BLUE);
            tablaDinamica2.pintarDatos(Color.GREEN,Color.CYAN);
            tablaDinamica2.pintarLinea(Color.BLACK);
            tablaDinamica2.pintarTextoEncabezado(Color.WHITE);
            tablaDinamica2.pintarTextoDatos(Color.BLACK);
            //ingreso datos
            tablaDinamica.addHeader(header);
            tablaDinamica.addData(conseguirReporteGrafica());
            //definicio colores grafico
            tablaDinamica.fondo(Color.BLUE);
            tablaDinamica.pintarDatos(Color.GREEN,Color.CYAN);
            tablaDinamica.pintarLinea(Color.BLACK);
            tablaDinamica.pintarTextoEncabezado(Color.WHITE);
            tablaDinamica.pintarTextoDatos(Color.BLACK);
            tablaGrafica3.setVisibility(View.GONE);
            textError.setVisibility(View.GONE);
        }else{
            //ingreso datos
            tablaDinamica3.addHeader(headerErrores);
            tablaDinamica3.addData(conseguirReporteErrores());
            //definicion colores errores
            tablaDinamica3.fondo(Color.BLUE);
            tablaDinamica3.pintarDatos(Color.GREEN,Color.CYAN);
            tablaDinamica3.pintarLinea(Color.BLACK);
            tablaDinamica3.pintarTextoEncabezado(Color.WHITE);
            tablaDinamica3.pintarTextoDatos(Color.BLACK);
            tablaGrafica.setVisibility(View.GONE);
            tablaGrafica2.setVisibility(View.GONE);
            textOperador.setVisibility(View.GONE);
            textGrafico.setVisibility(View.GONE);
        }
    }
    private ArrayList<String[]>conseguirReporteGrafica(){
        filas.add(new String[]{"Barras",String.valueOf(DatosReportes.datosReportes.getCantidadBarra())});
        filas.add(new String[]{"Pie",String.valueOf(DatosReportes.datosReportes.getCantidadPie())});
        return filas;
    }
    private ArrayList<String[]>conseguirReporteOperadores(){
        for (int i=0;i<DatosReportes.datosReportes.getObtenerOcurrencias().size();i++){
            filasOperadores.add(DatosReportes.datosReportes.getObtenerOcurrencias().get(i));
        }
        //filasOperadores.add(new String[]{"Resta","12","3","12-2"});
        return filasOperadores;
    }
    private ArrayList<String[]>conseguirReporteErrores(){
        for (int i=0;i<DatosReportes.datosReportes.getErrorLexico().size();i++){
            filasErrores.add(DatosReportes.datosReportes.getErrorLexico().get(i));
        }
        for (int i=0;i<DatosReportes.datosReportes.getErrorSintactico().size();i++){
            filasErrores.add(DatosReportes.datosReportes.getErrorSintactico().get(i));
        }
        //filasErrores.add(new String[]{"*","2","3","sintactico","esperaba titulo"});
        return filasErrores;
    }
}