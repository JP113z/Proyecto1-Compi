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

Identifier = {jletter} {jletterdigit}*

/* Literals */
DecIntegerLiteral = 0 | [1-9][0-9]* /* ojo no permite negativos */
digit = [0-9]
digitoNoCero = [1-9]
DecIntegerLiteral = {digitoNoCero} {digit}*

%state STRING

%%
/* keywords */
<YYINITIAL>"rodolfo" { return symbol(sym.INTEGER); }
<YYINITIAL>"cometa" { return symbol(sym.STRING); }
<YYINITIAL>"cupido" { return symbol(sym.CHAR); }

<YYINITIAL> {
    /* identifiers */
    {Identifier} { return symbol(sym.IDENTIFICADOR); }

    /* literals */
    {DecIntegerLiteral} { return symbol(sym.L_INTEGER); }

    "\"" { string.setLength(0); yybegin(STRING); }

    /* operators */
    "=" { return symbol(sym.ASIGNA); }
    "==" { return symbol(sym.COMPARACION); }
    "+" { return symbol(sym.SUMA); }

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
