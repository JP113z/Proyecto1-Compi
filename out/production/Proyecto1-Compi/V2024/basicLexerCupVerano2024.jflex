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
<YYINITIAL>"_verano_" { return symbol(sym.MAIN); }



/* Tipo de dato char solo reconoce un caractarer dentro del char (se asume así por el anexo del enunciado del proyecto)*/
<YYINITIAL>\'([^\\'\n\\r]|\\[bfnrt\'\\])\' {
    return symbol(sym.L_CHAR, yytext().charAt(1));
}

/* Tipo de dato string */
<YYINITIAL>\"([^\"\\]|\\[bfnrt\"\\])*\" {
    return symbol(sym.L_STRING, yytext().substring(1, yytext().length() - 1));
}


/* Identificadores validos */
<YYINITIAL>{Identifier} {
    return symbol(sym.IDENTIFICADOR);
}



/* Apertura de bloques de código */
<YYINITIAL>"abrecuento" { return symbol(sym.corcheteIzquierdo); }
<YYINITIAL>"cierracuento" { return symbol(sym.corcheteDerecho); }

/* Apertura y cierre de arreglos */
<YYINITIAL>"abreempaque" { return symbol(sym.CORCHETEAPERTURA); }
<YYINITIAL>"cierraempaque" { return symbol(sym.CORCHETECIERRE); }

/* Tipos de datos */
<YYINITIAL>"rodolfo" { return symbol(sym.INTEGER); }
<YYINITIAL>"bromista " { return symbol(sym.FLOAT); }
<YYINITIAL>"trueno " { return symbol(sym.BOOL); }
<YYINITIAL>"cupido" { return symbol(sym.CHAR); }
<YYINITIAL>"cometa" { return symbol(sym.STRING); }

<YYINITIAL>".." { return symbol(sym.PUNTOS); }

<YYINITIAL>"true" { return symbol(sym.TRUE); }
<YYINITIAL>"false" { return symbol(sym.FALSE); }

/* Operador de asignación */
<YYINITIAL>"entrega" { return symbol(sym.ASIGNA); }

/* Paréntesis para  operadores y operandos */
<YYINITIAL>"abreregalo" { return symbol(sym.PARENTESISAPERTURA); }
<YYINITIAL>"cierraregalo" { return symbol(sym.PARENTESISCIERRE); }

/* Separador */
<YYINITIAL>"," { return symbol(sym.COMA); }

/* Operadores unarios */
<YYINITIAL>"quien" { return symbol(sym.INCREMENTO); }
<YYINITIAL>"grinch" { return symbol(sym.DECREMENTO); }
<YYINITIAL>"-" { return symbol(sym.NEGATIVO); }


/* Operadores relacionales */
<YYINITIAL>"snowball" { return symbol(sym.MENOR); }
<YYINITIAL>"evergreen" { return symbol(sym.MENOR_IGUAL); }
<YYINITIAL>"minstix" { return symbol(sym.MAYOR); }
<YYINITIAL>"upatree" { return symbol(sym.MAYOR_IGUAL); }
<YYINITIAL>"mary" { return symbol(sym.IGUAL); }
<YYINITIAL>"openslae" { return symbol(sym.DIFERENTE); }

/* Operadores lógicos */
<YYINITIAL>"melchor" { return symbol(sym.CONJUNCION); }
<YYINITIAL>"gaspar" { return symbol(sym.DISYUNCION); }
<YYINITIAL>"baltazar" { return symbol(sym.NEGACION); }

/* Delimitador de final de expresión */
<YYINITIAL>"finregalo" { return symbol(sym.FIN_EXPRESION); }


/* Estructuras de control */
<YYINITIAL>"elfo" { return symbol(sym.IF); }
<YYINITIAL>"hada" { return symbol(sym.ELSE); }
<YYINITIAL>"envuelve" { return symbol(sym.WHILE); }
<YYINITIAL>"duende" { return symbol(sym.FOR); }
<YYINITIAL>"varios" { return symbol(sym.SWITCH); }
<YYINITIAL>"historia" { return symbol(sym.CASE); }
<YYINITIAL>"ultimo" { return symbol(sym.DEFAULT); }
<YYINITIAL>"corta" { return symbol(sym.BREAK); }
<YYINITIAL>"envia" { return symbol(sym.RETURN); }
<YYINITIAL>"sigue" { return symbol(sym.DOS_PUNTOS); }

/* Operaciones de entrada/salida */
<YYINITIAL>"narra" { return symbol(sym.PRINT); }
<YYINITIAL>"escucha" { return symbol(sym.READ); }

/* literales */
    <YYINITIAL>{DecIntegerLiteral} {
        try {
            if (yytext().contains(".")) {
                return symbol(sym.L_FLOAT, Double.parseDouble(yytext())); // Si es decimal
            } else {
                return symbol(sym.L_INTEGER, Integer.parseInt(yytext())); // Si es entero
            }
        } catch (NumberFormatException e) {
            System.err.println("Error léxico: Número mal formado '" + yytext() + "' en línea " + yyline + ", columna " + yycolumn);
        }
    }


<YYINITIAL> {
    /* operators */
    "navidad" { return symbol(sym.SUMA); }
    "intercambio" { return symbol(sym.RESTA); }
    "reyes" { return symbol(sym.DIVISION); }
    "nochebuena" { return symbol(sym.MULTIPLICACION); }
    "magos" { return symbol(sym.MODULO); }
    "adviento" { return symbol(sym.POTENCIA); }

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