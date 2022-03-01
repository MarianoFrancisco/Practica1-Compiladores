package lector;

import java.util.ArrayList;

public class DatosGrafica {
    private ArrayList<String[]> tituloGrafica;
    private ArrayList<String[]> barraEjeX;
    private ArrayList<String[]> barraEjeY;
    private ArrayList<String[]> barraUnir;
    private ArrayList<String> ejecutar;
    private ArrayList<String[]> extraPie;
    private ArrayList<String[]> totalPie;
    private ArrayList<String[]> tipoGraficaPie;
    private int contador;
    public static DatosGrafica datosGrafica= new DatosGrafica(null,null,null,null,null,null,null,null,0);

    public DatosGrafica(ArrayList<String[]> tituloGrafica, ArrayList<String[]> barraEjeX, ArrayList<String[]> barraEjeY, ArrayList<String[]> barraUnir, ArrayList<String> ejecutar, ArrayList<String[]> extraPie, ArrayList<String[]> totalPie, ArrayList<String[]> tipoGraficaPie, int contador) {
        this.tituloGrafica = tituloGrafica;
        this.barraEjeX = barraEjeX;
        this.barraEjeY = barraEjeY;
        this.barraUnir = barraUnir;
        this.ejecutar = ejecutar;
        this.extraPie = extraPie;
        this.totalPie = totalPie;
        this.tipoGraficaPie = tipoGraficaPie;
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ArrayList<String[]> getExtraPie() {
        return extraPie;
    }

    public void setExtraPie(ArrayList<String[]> extraPie) {
        this.extraPie = extraPie;
    }

    public ArrayList<String[]> getTotalPie() {
        return totalPie;
    }

    public void setTotalPie(ArrayList<String[]> totalPie) {
        this.totalPie = totalPie;
    }

    public ArrayList<String[]> getTipoGraficaPie() {
        return tipoGraficaPie;
    }

    public void setTipoGraficaPie(ArrayList<String[]> tipoGraficaPie) {
        this.tipoGraficaPie = tipoGraficaPie;
    }

    public ArrayList<String> getEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(ArrayList<String> ejecutar) {
        this.ejecutar = ejecutar;
    }

    public ArrayList<String[]> getTituloGrafica() {
        return tituloGrafica;
    }

    public void setTituloGrafica(ArrayList<String[]> tituloGrafica) {
        this.tituloGrafica = tituloGrafica;
    }

    public ArrayList<String[]> getBarraEjeX() {
        return barraEjeX;
    }

    public void setBarraEjeX(ArrayList<String[]> barraEjeX) {
        this.barraEjeX = barraEjeX;
    }

    public ArrayList<String[]> getBarraEjeY() {
        return barraEjeY;
    }

    public void setBarraEjeY(ArrayList<String[]> barraEjeY) {
        this.barraEjeY = barraEjeY;
    }

    public ArrayList<String[]> getBarraUnir() {
        return barraUnir;
    }

    public void setBarraUnir(ArrayList<String[]> barraUnir) {
        this.barraUnir = barraUnir;
    }
}
