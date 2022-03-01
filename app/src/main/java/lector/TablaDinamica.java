package lector;

import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class TablaDinamica {
    private TableLayout tabla;
    private Context context;
    private String[]header;
    private ArrayList<String[]>data;
    private TableRow fila;
    private TextView columna;
    private int indexF;
    private int indexC;
    private boolean mColor=false;
    private int pColor,sColor;
    public TablaDinamica(TableLayout tabla,Context context){
        this.tabla=tabla;
        this.context=context;
    }
    public void addHeader(String[]header){
        this.header=header;
        crearHeader();
    }
    public void addData(ArrayList<String[]>data){
        this.data=data;
        crearDatosTabla();
    }
    public void nuevaFila(){
        fila=new TableRow(context);
    }
    private void nuevaColumna(){
        columna=new TextView(context);
        columna.setGravity(Gravity.CENTER);//definimos posicion
        columna.setTextSize(25);//tamanio de letra

    }
    private void crearHeader(){
        indexF=0;
        nuevaFila();
        //datos en arreglo
        while (indexC<header.length){
            nuevaColumna();
            columna.setText(header[indexC++]);
            fila.addView(columna,nuevaFilaParametros());
        }
        tabla.addView(fila);
    }
    private void crearDatosTabla(){
        String info;
        for (indexF=1;indexF<=data.size();indexF++){
            nuevaFila();
            for (indexC=0;indexC<=header.length;indexC++){
                nuevaColumna();
                String[] filas=data.get(indexF-1);
                info=(indexC<filas.length)?filas[indexC]:"";
                columna.setText(info);
                fila.addView(columna,nuevaFilaParametros());
            }
            tabla.addView(fila);
        }
    }
    public void colorear(int color){
        indexF=0;
        mColor=!mColor;//cambio de true a false y viceversa
        //datos en arreglo
        while (indexC<header.length){
            columna=conseguirColumna(data.size()-1,indexC++);
            columna.setBackgroundColor((mColor)?pColor:sColor);

        }
        tabla.addView(fila);
    }
    public void fondo(int color){
        indexC=0;
        //datos en arreglo
        while (indexC<header.length){
            columna=conseguirColumna(0,indexC++);
            columna.setBackgroundColor(color);
        }
    }
    public void pintarLinea(int color){
        indexF=0;
        while(indexF<=data.size()){
            conseguirFila(indexF++).setBackgroundColor(color);
        }
    }
    public void pintarTextoDatos(int color){
        for (indexF=1;indexF<= data.size();indexF++){
            for (indexC=0;indexC<= header.length;indexC++){
                conseguirColumna(indexF,indexC).setTextColor(color);
            }
        }
    }
    public void pintarTextoEncabezado(int color){
        indexC=0;
        while(indexC< header.length){
            conseguirColumna(0,indexC++).setTextColor(color);
        }
    }
    public void pintarDatos(int pColor,int sColor){
        for (indexF=1;indexF<=data.size();indexF++){
            mColor=!mColor;//cambio de true a false y viceversa
            for (indexC=0;indexC<=header.length;indexC++){
                columna=conseguirColumna(indexF,indexC);
                columna.setBackgroundColor((mColor)?pColor:sColor);
            }
        }
        this.pColor=pColor;
        this.sColor=sColor;
    }

    private TableRow conseguirFila(int index){
        return (TableRow) tabla.getChildAt(index);

    }
    private TextView conseguirColumna(int filaIndex,int columnaIndex){
        fila=conseguirFila(filaIndex);
        return (TextView) fila.getChildAt(columnaIndex);

    }
    /*
    public void agregarItems(String[]item){
            String info;
            data.add(item);
            indexC=0;
            nuevaFila();
            while(indexC<header.length){
                nuevaColumna();
                info=(indexC<item.length)?item[indexC]:"";
                columna.setText(info);
                fila.addView(columna,nuevaFilaParametros());
            }
            tabla.addView(fila,data.size());
    }*/
    private TableRow.LayoutParams nuevaFilaParametros(){
        TableRow.LayoutParams parametros=new TableRow.LayoutParams();
        parametros.setMargins(1,1,1,1);
        parametros.weight=1;
        return parametros;
    }

}
