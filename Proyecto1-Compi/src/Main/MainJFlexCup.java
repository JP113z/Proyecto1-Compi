package Main;

import ParserLexer.BasicLexerCupV;
import java_cup.internal_error;
import java_cup.parser;
import java_cup.runtime.Symbol;
import jflex.exceptions.SilentExit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MainJFlexCup {

    public void iniLexerParser(String rutaLexer, String rutaParser) throws internal_error, Exception {
        GenerateLexer(rutaLexer);
        GenerateParser(rutaParser);
    }

    // Genera el archivo del lexer
    public void GenerateLexer(String ruta) throws IOException, SilentExit {
        String[] strArr = {ruta};
        jflex.Main.generate(strArr);
    }

    // Genera los archivos del parser
    public void GenerateParser(String ruta) throws internal_error, IOException, Exception {
        String[] strArr = {ruta};
        java_cup.Main.main(strArr);
    }

    // Esta usa el Lexer modificado del ParserLexer DE VERANO
// Usa Symbol de cup
    public void ejercicioLexerV2024(String rutaScanear) throws IOException {
        Reader reader = new BufferedReader(new FileReader(rutaScanear));
        reader.read();

        BasicLexerCupV lex = new BasicLexerCupV(reader);

        int i = 0;
        Symbol token;

        while (true) {
            token = lex.next_token();
            if (token.sym != 0) {
                System.out.println("Token: " + token.sym + ", Valor: " +
                        (token.value == null ? lex.yytext() : token.value.toString()));
            } else {
                System.out.println("Cantidad de lexemas encontrados: " + i);
                return;
            }
            i++;
        }
    }

}
