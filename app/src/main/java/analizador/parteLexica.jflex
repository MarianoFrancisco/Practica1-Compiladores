/*primer seccion: codigo de usuario*/
package analizador.lexer;

import java_cup.runtime.*;
import analizador.parser.sym;
import java.util.ArrayList;
%%

%class parteLexica
%unicode
%line
%column
%cup
%public

//simbolos de agrupacion
LLAVEA="{"
LLAVEC="}"

//Operadores
MAS = "+"
MENOS = "-"
ASTERISCO = "*"
DIAGONAL = "/"
PARENTESISA = "("
PARENTESISC = ")"
CORCHETEA = "["
CORCHETEC = "]"

//Comentario
COMENTARIO="#"

//Palabras reservadas
DEF = (Def|def)
BARRA = "Barras"
PIE = "Pie"
TITULO = "titulo"
EJEX = "ejex"
EJEY = "ejey"
ETIQUETAS="etiquetas"
VALORES="valores"
UNIR="unir"
TOTAL="total"
EXTRA="extra"
EJECUTAR="Ejecutar"
TIPO="tipo"
CANTIDAD="Cantidad"
PORCENTAJE="Porcentaje"


//espacios
espacio=[\t|\r|\n|\f|" "|""]+
//datos que incluyen digitos
ENTERO = [0-9]+
PALABRA = [a-zA-Z]+
//Combinacion de caracteres
SIMBOLOS=[¿?_¡!$%&/()={}[]*-@´+¿';.,<>°]
COMBINACION = ({ENTERO}|{PALABRA}|{SIMBOLOS}|" ")+
TEXTO= ((\")({COMBINACION})+(\"))
//extra
COMA = ","
PUNTO = "."
DOSPUNTOS = ":"
PUNTOCOMA = ";"
%state STRCOMENTARIO
%{
    private ArrayList<String[]> errorLexico=new ArrayList<>();
    private int entrarErrorLexico=0;
    public int obtenerEntrarErrorLexico(){
            return entrarErrorLexico;
        }
    public ArrayList<String[]> getErrorLexico(){
        return errorLexico;
    }
%}
%%
//simbolos de agrupacion
<YYINITIAL> {LLAVEA}            { return new Symbol(sym.LLAVEA, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {LLAVEC}            { return new Symbol(sym.LLAVEC, yyline + 1, yycolumn + 1,new String(yytext()));  }
//Operadores
<YYINITIAL> {MAS}               { return new Symbol(sym.MAS, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {MENOS}             { return new Symbol(sym.MENOS, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {ASTERISCO}         { return new Symbol(sym.ASTERISCO, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {DIAGONAL}          { return new Symbol(sym.DIAGONAL, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {PARENTESISA}       { return new Symbol(sym.PARENTESISA, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {PARENTESISC}       { return new Symbol(sym.PARENTESISC, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {CORCHETEA}       { return new Symbol(sym.CORCHETEA, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {CORCHETEC}       { return new Symbol(sym.CORCHETEC, yyline + 1, yycolumn + 1,new String(yytext()));  }
//Comentario
<YYINITIAL> {COMENTARIO}        { yybegin(STRCOMENTARIO); System.out.println("comentario");
                                   }
<STRCOMENTARIO>[^\n]             {}
<STRCOMENTARIO>[\n]             {yybegin(YYINITIAL);
                                }

//Palabras reservadas
<YYINITIAL> {DEF}               { return new Symbol(sym.DEF, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {BARRA}             { return new Symbol(sym.BARRA, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {PIE}               { return new Symbol(sym.PIE, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {TITULO}            { return new Symbol(sym.TITULO, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {EJEX}              { return new Symbol(sym.EJEX, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {EJEY}              { return new Symbol(sym.EJEY, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {ETIQUETAS}         { return new Symbol(sym.ETIQUETAS, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {VALORES}           { return new Symbol(sym.VALORES, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {UNIR}              { return new Symbol(sym.UNIR, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {TOTAL}             { return new Symbol(sym.TOTAL, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {EXTRA}             { return new Symbol(sym.EXTRA, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {EJECUTAR}          { return new Symbol(sym.EJECUTAR, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {TIPO}              { return new Symbol(sym.TIPO, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {CANTIDAD}              { return new Symbol(sym.CANTIDAD, yyline + 1, yycolumn + 1);  }
<YYINITIAL> {PORCENTAJE}              { return new Symbol(sym.PORCENTAJE, yyline + 1, yycolumn + 1);  }
//espacio
<YYINITIAL> {espacio}*          {/*No pasa nada*/}
//datos que incluyen digitos
<YYINITIAL> {ENTERO}            { return new Symbol(sym.ENTERO, yyline + 1, yycolumn + 1, new Integer(yytext()));  }
//Combinacion de caracteres
<YYINITIAL> {TEXTO}             { return new Symbol(sym.TEXTO, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {PALABRA}           { return new Symbol(sym.PALABRA, yyline + 1, yycolumn + 1);  }
//Extra
<YYINITIAL> {COMA}              { return new Symbol(sym.COMA, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {PUNTO}             { return new Symbol(sym.PUNTO, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {DOSPUNTOS}         { return new Symbol(sym.DOSPUNTOS, yyline + 1, yycolumn + 1,new String(yytext()));  }
<YYINITIAL> {PUNTOCOMA}         { return new Symbol(sym.PUNTOCOMA, yyline + 1, yycolumn + 1,new String(yytext()));  }
//cualquier otra cosa
[^]                             {errorLexico.add(new String[]{yytext(),String.valueOf((yyline+1)),String.valueOf((yycolumn+1)),"lexico","Simbolo no existe en el lenguaje"}); entrarErrorLexico=1;}