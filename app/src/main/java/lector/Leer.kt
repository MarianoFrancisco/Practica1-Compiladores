package lector
import analizador.lexer.parteLexica
import analizador.parser.SintacticoParser
import android.R.array
import java.io.Reader
import java.io.StringReader


class Leer {
    private var texto =" "
    private var temp=0
    val reporte = DatosReportes.datosReportes
    val crearGrafica = DatosGrafica.datosGrafica
    public fun Leyendo(datos:String){

        texto = datos
        val reader: Reader = StringReader(texto)
        var parteLexica = parteLexica(reader)
        var sintacticoParser = SintacticoParser(parteLexica)
        try {
            sintacticoParser.parse()
            //reportes
            reporte.setCantidadBarra(sintacticoParser.incrementarContadorBarra)
            reporte.setCantidadPie(sintacticoParser.incrementarContadorPie)
            reporte.setErrorLexico(parteLexica.errorLexico)
            reporte.setErrorSintactico(sintacticoParser.errorSintactico)
            reporte.setObtenerOcurrencias(sintacticoParser.ocurrenciaOperadores)
            //barra
            crearGrafica.setTituloGrafica(sintacticoParser.getTitulo())
            crearGrafica.setBarraEjeX(sintacticoParser.ejeX)
            crearGrafica.setBarraEjeY(sintacticoParser.ejeY)
            crearGrafica.setBarraUnir(  sintacticoParser.unirBarra)
            crearGrafica.setEjecutar(sintacticoParser.ejecutar)
            if(parteLexica.obtenerEntrarErrorLexico()==1){
                temp=1
            }else if(sintacticoParser.obtenerEntrarErrorSintactico()==1){
                temp=1
            }
            reporte.setErrorEntrada(temp)
            //pie
            crearGrafica.setExtraPie(sintacticoParser.extra)
            crearGrafica.setTotalPie(sintacticoParser.total)
            crearGrafica.setTipoGraficaPie(sintacticoParser.tipo)
            //println("Cantidad total de sumas: " + sintacticoParser.getCount())
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }


}