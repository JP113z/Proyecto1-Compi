package Main;

import ParserLexer.BasicLexerCupV;
import java_cup.runtime.Symbol;
import jflex.exceptions.SilentExit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class MainJFlexCup {

    public void iniLexerParser(String rutaLexer, String rutaParser) throws Exception {
        try {
            GenerateLexer(rutaLexer);
            GenerateParser(rutaParser);
        } catch (Exception e) {
            System.err.println("Error al generar el lexer o parser: " + e.getMessage());
            throw e;
        }
    }

    public void GenerateLexer(String ruta) throws IOException, SilentExit {
        System.out.println("Generando lexer desde: " + ruta);
        jflex.Main.generate(new String[]{ruta});
    }

    public void GenerateParser(String ruta) throws Exception {
        System.out.println("Generando parser desde: " + ruta);
        java_cup.Main.main(new String[]{ruta});
    }

    public void ejercicioLexerV2024(String rutaScanear) throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(rutaScanear))) {
            BasicLexerCupV lexer = new BasicLexerCupV(reader);
            Symbol token;
            int i = 0;
            System.out.println("Iniciando análisis léxico...");
            generateFile("", false);
            while ((token = lexer.next_token()).sym != 0) {
                String action = String.format(
                        "Token %d: %s, Valor: %s%n",
                        token.sym,
                        lexer.yytext(),
                        token.value == null ? lexer.yytext() : token.value.toString()
                );
                i++;
                System.out.printf(action);
                generateFile(action, true);
            }
            System.out.println("Análisis léxico completado. Tokens encontrados: " + i);
        } catch (Exception e) {
            System.err.println("Error durante el análisis léxico: " + e.getMessage());
        }

    }

    private void generateFile(String action, boolean replace)
    {
        try (
                FileWriter writer = new FileWriter("tokens_salida.txt", replace)
        ) {
            // Escribe en archivo en modo append
            writer.write(action);
        } catch (IOException e) {
            System.err.println("Error escribiendo en el archivo: " + e.getMessage());
        }

    }
}

