/* JFlex example: partial Java language lexer specification */
package ParserLexer;

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 *
 * Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer.
 * Este lexer es utilizado por por el parser generado por BasicLexerCup (parser.java que se genera).
 */
%%
%class BasicLexerCupV
%public
%unicode
%cup
%line
%column

{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*]* "*"+ "/"
/* Comment can be the last line of the file, without line terminator */
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent}* "*"+ "/"
CommentContent = [^*] | "*" [^/]

/* Identificadores de tipo _nombre_ */
Identifier = _ [a-zA-Z0-9]+ _


/* Literals */
DecIntegerLiteral = 0 | [1-9][0-9]* /* ojo no permite negativos */
digit = [0-9]
digitoNoCero = [1-9]
DecIntegerLiteral = {digitoNoCero} {digit}*

%state STRING

%%
/* Apertura de bloques de código */
<YYINITIAL>"abrecuento" { return symbol(sym.ABRECUENTO); }
<YYINITIAL>"cierracuento" { return symbol(sym.CIERRACUENTO); }

/* Apertura y cierre de arreglos */
<YYINITIAL>"abreempaque" { return symbol(sym.ABREEMPAQUE); }
<YYINITIAL>"cierraempaque" { return symbol(sym.CIERREEMPAQUE); }

/* Tipos de datos */
<YYINITIAL>"rodolfo" { return symbol(sym.INTEGER); }
<YYINITIAL>"bromista " { return symbol(sym.FLOAT); }
<YYINITIAL>"trueno " { return symbol(sym.BOOL); }
<YYINITIAL>"cupido" { return symbol(sym.CHAR); }
<YYINITIAL>"cometa" { return symbol(sym.STRING); }
<<EOF>> { return symbol(sym.EOF); }

/* Operador de asignación */
<YYINITIAL>"entrega" { return symbol(sym.ASIGNA); }

/* Paréntesis para  operadores y operandos */
<YYINITIAL>"abreregalo" { return symbol(sym.PARENTESISAPERTURA); }
<YYINITIAL>"cierraregalo" { return symbol(sym.PARENTESISCIERRE); }


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

/* Identificadores y validación de errores (siempre debe ser tipo _x_) */
<YYINITIAL> {
    /* Identificadores válidos */
    {Identifier} { return symbol(sym.IDENTIFICADOR); }

    /* Identificadores mal formados */
    "_" [^a-zA-Z0-9]+ {
        System.err.println("Error léxico en línea " + yyline + ", columna " + yycolumn + ": identificador mal formado '" + yytext() + "'");
        /* si falta un _ como _x o x_ o un simbolo no valido como @ */
    }
    [a-zA-Z0-9]+ {
        System.err.println("Error léxico en línea " + yyline + ", columna " + yycolumn + ": identificador sin guiones bajos '" + yytext() + "'");
        /* si fuera solo x*/
    }
}



<YYINITIAL> {
    /* literals */
    {DecIntegerLiteral} { return symbol(sym.L_INTEGER); }

    "\"" { string.setLength(0); yybegin(STRING); }

    /* operators */
    "navidad" { return symbol(sym.SUMA); }
    "intercambio" { return symbol(sym.RESTA); }
    "reyes" { return symbol(sym.DIVISION); }
    "nochebuena" { return symbol(sym.MULTIPLICACION); }
    "magos" { return symbol(sym.MODULO); }
    "adviento" { return symbol(sym.POTENCIA); }

    /* comments */
    {Comment} { /* ignore */ }

    /* whitespace */
    {WhiteSpace} { /* ignore */ }
}

<STRING> {
    "\"" { yybegin(YYINITIAL); return symbol(sym.L_STRING, string.toString()); }
    [^\n\r\"\\]+ { string.append(yytext()); }
    "\\t" { string.append('\t'); }
    "\\n" { string.append('\n'); }
    "\\r" { string.append('\r'); }
    "\\\"" { string.append('\"'); }
    "\\\\" { string.append('\\'); }
}

/* error fallback */
[^] { throw new Error("Illegal character <" + yytext() + ">"); }
