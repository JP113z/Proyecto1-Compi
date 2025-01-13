/* JFlex example: partial Java language lexer specification */
package ParserLexer;

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 *
 * Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer.
 * Este lexer es utilizado por por el parser generado por BasicLexerCup (parser.java que se genera).
 */


/**
  * Este video se tomo como ejemplo para comprender el funcionamiento que debe cumplir el scanner
  * sin embargo se uso la estructura del ejemplo del profesor como base para el desarrollo
  * video: https://www.youtube.com/watch?v=5mIRrn2yEe8&t=393s
  */

%%
%class BasicLexerCupV
%public
%unicode
%cup
%line
%column

%{
/* Definiciones de código Java */
StringBuffer string = new StringBuffer();

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}
%}

/* Definiciones de saltos de linea, espacios en blanco */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]


/* Identificadores de tipo _nombre_ */
Identifier = "_" [a-zA-Z0-9]+ "_"

/* Identificadores invalidos como: _var, var_ o _var _*/
IdentificadorInicioInv = [a-zA-Z0-9]+ "_"
IdentificadorFinInv = "_" [a-zA-Z0-9]+
IdentificadorInv = "_" [^a-zA-Z0-9_]+ "_"


/* Literales */
digit = [0-9]
digitoNoCero = [1-9]
signo = [-]?
DecIntegerLiteral = {signo}({digit}+|{digit}+"."+{digit}+)


%state STRING

%%

/* Procedimiento main */
<YYINITIAL>"_verano_" { return symbol(sym.MAIN, "_verano_"); }

/* Tipos de datos */
<YYINITIAL>"rodolfo" { return symbol(sym.INTEGER, "rodolfo"); }
<YYINITIAL>"cometa" { return symbol(sym.STRING, "cometa"); }
<YYINITIAL>"bromista" { return symbol(sym.FLOAT, "bromista"); }
<YYINITIAL>"trueno" { return symbol(sym.BOOL, "trueno"); }
<YYINITIAL>"cupido" { return symbol(sym.CHAR, "cupido"); }


/* Tipo de dato char solo reconoce un caractarer dentro del char (se asume así por el anexo del enunciado del proyecto)*/
<YYINITIAL>\'([^\\'\n\\r]|\\[bfnrt\'\\])\' {
    return symbol(sym.L_CHAR, yytext().charAt(1));
}

/* Tipo de dato string */
<YYINITIAL>\"([^\"\\]|\\[bfnrt\"\\])*\" {
    return symbol(sym.L_STRING, yytext().substring(1, yytext().length() - 1));
}

/* Separador */
<YYINITIAL>"," { return symbol(sym.COMA, ","); }

/* Apertura de bloques de código */
<YYINITIAL>"abrecuento" { return symbol(sym.corcheteIzquierdo, "abrecuento"); }
<YYINITIAL>"cierracuento" { return symbol(sym.corcheteDerecho, "cierracuento"); }

/* Apertura y cierre de arreglos */
<YYINITIAL>"abreempaque" { return symbol(sym.CORCHETEAPERTURA, "abreempaque"); }
<YYINITIAL>"cierraempaque" { return symbol(sym.CORCHETECIERRE, "cierraempaque"); }


/* Identificadores válidos */
<YYINITIAL>{Identifier} {
    return symbol(sym.IDENTIFICADOR, yytext());
}

<YYINITIAL>"true" { return symbol(sym.TRUE, "true"); }
<YYINITIAL>"false" { return symbol(sym.FALSE, "false"); }

/* Operador de asignación */
<YYINITIAL>"entrega" { return symbol(sym.ASIGNA, "entrega"); }

/* Paréntesis para  operadores y operandos */
<YYINITIAL>"abreregalo" { return symbol(sym.PARENTESISAPERTURA, "abreregalo"); }
<YYINITIAL>"cierraregalo" { return symbol(sym.PARENTESISCIERRE, "cierraregalo"); }

/* Operadores unarios */
<YYINITIAL>"quien" { return symbol(sym.INCREMENTO, "quien"); }
<YYINITIAL>"grinch" { return symbol(sym.DECREMENTO, "grinch"); }
<YYINITIAL>"-" { return symbol(sym.NEGATIVO, "-"); }


/* Operadores relacionales */
<YYINITIAL>"snowball" { return symbol(sym.MENOR, "snowball"); }
<YYINITIAL>"evergreen" { return symbol(sym.MENOR_IGUAL, "evergreen"); }
<YYINITIAL>"minstix" { return symbol(sym.MAYOR, "minstix"); }
<YYINITIAL>"upatree" { return symbol(sym.MAYOR_IGUAL, "upatree"); }
<YYINITIAL>"mary" { return symbol(sym.IGUAL, "mary"); }
<YYINITIAL>"openslae" { return symbol(sym.DIFERENTE,"openslae"); }

/* Operadores lógicos */
<YYINITIAL>"melchor" { return symbol(sym.CONJUNCION, "melchor"); }
<YYINITIAL>"gaspar" { return symbol(sym.DISYUNCION, "gaspar"); }
<YYINITIAL>"baltazar" { return symbol(sym.NEGACION, "baltazar"); }

/* Delimitador de final de expresión */
<YYINITIAL>"finregalo" { return symbol(sym.FIN_EXPRESION, "finregalo"); }


/* Estructuras de control */
<YYINITIAL>"elfo" { return symbol(sym.IF, "elfo"); }
<YYINITIAL>"hada" { return symbol(sym.ELSE, "hada"); }
<YYINITIAL>"envuelve" { return symbol(sym.WHILE, "envuelve"); }
<YYINITIAL>"duende" { return symbol(sym.FOR, "duende"); }
<YYINITIAL>"varios" { return symbol(sym.SWITCH, "varios"); }
<YYINITIAL>"historia" { return symbol(sym.CASE, "historia"); }
<YYINITIAL>"ultimo" { return symbol(sym.DEFAULT, "ultimo"); }
<YYINITIAL>"corta" { return symbol(sym.BREAK, "corta"); }
<YYINITIAL>"envia" { return symbol(sym.RETURN, "envia"); }
<YYINITIAL>"sigue" { return symbol(sym.DOS_PUNTOS, "sigue"); }

/* Operaciones de entrada/salida */
<YYINITIAL>"narra" { return symbol(sym.PRINT, "narra"); }
<YYINITIAL>"escucha" { return symbol(sym.READ, "escucha"); }

/* literales */
    <YYINITIAL>{DecIntegerLiteral} {
        try {
            if (yytext().contains(".")) {
                return symbol(sym.L_FLOAT, Float.parseFloat(yytext())); // Si es decimal
            } else {
                return symbol(sym.L_INTEGER, Integer.parseInt(yytext())); // Si es entero
            }
        } catch (NumberFormatException e) {
            System.err.println("Error léxico: Número mal formado '" + yytext() + "' en línea " + yyline + ", columna " + yycolumn);
        }
    }


<YYINITIAL> {
    /* operators */
    "navidad" { return symbol(sym.SUMA, "navidad"); }
    "intercambio" { return symbol(sym.RESTA, "intercambio"); }
    "reyes" { return symbol(sym.DIVISION, "reyes"); }
    "nochebuena" { return symbol(sym.MULTIPLICACION, "nochebuena"); }
    "magos" { return symbol(sym.MODULO, "magos"); }
    "adviento" { return symbol(sym.POTENCIA, "adviento"); }

    /* whitespace que representa los espacios en blanco */
    {WhiteSpace} { /* ignore */ }
}

<YYINITIAL> {
    /* Comentarios de una sola línea */
    "#" {InputCharacter}* { /* Ignore  */ }

    /* Comentarios de múltiples líneas */
    "\\_" ([^\\_])* "_/" { /* Ignore */ }
}

// Recuperación de errores el [^] es el que captura cualquier cosa no definida en la gramatica
//Se manejan los errores por identificadores mal formados como casos especificos para dar un mensaje de error más especifico
<YYINITIAL>{
    {IdentificadorInicioInv} {
            System.err.println("Error léxico: Identificador debe iniciar con '_': '" + yytext() + "' en línea "
                + (yyline + 1) + ", columna " + (yycolumn + 1));
        }
        {IdentificadorFinInv} {
            System.err.println("Error léxico: Identificador debe terminar con '_': '" + yytext() + "' en línea "
                + (yyline + 1) + ", columna " + (yycolumn + 1));
        }
        {IdentificadorInv} {
            System.err.println("Error léxico: Identificador mal formado (caracteres no válidos o espacios): '" + yytext() +
                "' en línea " + (yyline + 1) + ", columna " + (yycolumn + 1));
        }

        [a-zA-Z_][a-zA-Z0-9_]* {
            System.err.println("Error léxico: Palabra no permitida '" + yytext() + "' en línea "
                + (yyline + 1) + ", columna " + (yycolumn + 1));
        }


        [^ \t\r\n]+ {
            System.err.println("Error léxico: Secuencia no válida '" + yytext() +
                "' en línea " + (yyline + 1) + ", columna " + (yycolumn + 1));
        }
        /* El atrapa cualquier caracter no permitido*/
        [^] {
            System.err.println("Error léxico: Token no reconocido '" + yytext() +
                "' en línea " + (yyline + 1) + ", columna " + (yycolumn + 1));
        }
}


 <<EOF>> { return symbol(sym.EOF); }