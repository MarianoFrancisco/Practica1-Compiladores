package lector;

import java.util.ArrayList;

public class DatosReportes {
    private int cantidadBarra;
    private int cantidadPie;
    private ArrayList<String[]> errorLexico;
    private ArrayList<String[]> errorSintactico;
    private ArrayList<String[]> obtenerOcurrencias;
    private int errorEntrada;

    public static DatosReportes datosReportes= new DatosReportes(0,0,null,null,null,0);

    public DatosReportes(int cantidadBarra, int cantidadPie, ArrayList<String[]> errorLexico, ArrayList<String[]> errorSintactico, ArrayList<String[]> obtenerOcurrencias, int errorEntrada) {
        this.cantidadBarra = cantidadBarra;
        this.cantidadPie = cantidadPie;
        this.errorLexico = errorLexico;
        this.errorSintactico = errorSintactico;
        this.obtenerOcurrencias = obtenerOcurrencias;
        this.errorEntrada = errorEntrada;
    }

    public ArrayList<String[]> getObtenerOcurrencias() {
        return obtenerOcurrencias;
    }

    public void setObtenerOcurrencias(ArrayList<String[]> obtenerOcurrencias) {
        this.obtenerOcurrencias = obtenerOcurrencias;
    }

    public int getErrorEntrada() {
        return errorEntrada;
    }

    public void setErrorEntrada(int errorEntrada) {
        this.errorEntrada = errorEntrada;
    }

    public ArrayList<String[]> getErrorSintactico() {
        return errorSintactico;
    }

    public void setErrorSintactico(ArrayList<String[]> errorSintactico) {
        this.errorSintactico = errorSintactico;
    }

    public ArrayList<String[]> getErrorLexico() {
        return errorLexico;
    }

    public void setErrorLexico(ArrayList<String[]> errorLexico) {
        this.errorLexico = errorLexico;
    }

    public int getCantidadBarra() {
        return cantidadBarra;
    }

    public void setCantidadBarra(int cantidadBarra) {
        this.cantidadBarra = cantidadBarra;
    }

    public int getCantidadPie() {
        return cantidadPie;
    }

    public void setCantidadPie(int cantidadPie) {
        this.cantidadPie = cantidadPie;
    }
}
