package Main;

import ParserLexer.BasicLexerCupV;
import ParserLexer.sym;
import java_cup.runtime.Symbol;
import jflex.exceptions.SilentExit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileWriter;
import java.util.*;

public class MainJFlexCup {

    /**
     * Método: iniLexerParser
     * Objetivo: Genera automaticamente el lexer y parser a partir de los archivos .jflex y .cup.
     * Entradas:
     *   - rutaLexer: Ruta del archivo JFlex (.jflex) para generar el lexer.
     *   - rutaParser: Ruta del archivo CUP (.cup) para generar el parser.
     * Salida: Ninguna.
     * Restricciones: Las rutas deben ser correctas y los archivos .jflex y .cup deben existir y tener un contenido coherente.
     */
    public void iniLexerParser(String rutaLexer, String rutaParser) throws Exception {
        try {
            GenerateLexer(rutaLexer);
            GenerateParser(rutaParser);
        } catch (Exception e) {
            System.err.println("Error al generar el lexer o parser: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Método: GenerateLexer
     * Objetivo: Generar el archivo lexer a partir del archivo .jflex.
     * Entradas:
     *   - ruta: Ruta del archivo .jflex.
     * Salida: Ninguna.
     * Restricciones: El archivo en la ruta debe existir y ser un archivo .jflex valido con contenido coherente.
     */
    public void GenerateLexer(String ruta) throws IOException, SilentExit {
        System.out.println("Generando lexer desde: " + ruta);
        jflex.Main.generate(new String[]{ruta});
    }

    /**
     * Método: GenerateParser
     * Objetivo: Generar el archivo parser a partir del archivo .cup.
     * Entradas:
     *   - ruta: Ruta del archivo .cup.
     * Salida: Ninguna.
     * Restricciones: El archivo en la ruta debe existir y ser un archivo .cup valido con contenido coherente.
     */
    public void GenerateParser(String ruta) throws Exception {
        System.out.println("Generando parser desde: " + ruta);
        java_cup.Main.main(new String[]{ruta});
    }


    /**
     * Método: ejercicioLexerV2024
     * Objetivo: Realizar el analisis lexico del archivo proporcionado en el main e imprime los tokens encontrados
     *           junto con sus líneas de aparicion. Hace una llamada a un metodo privado dentro de esta misma clase
     *           que guarde todo lo que este meteodo imprime en un archivo de salida.
     * Entradas:
     *   - rutaScanear: Ruta del archivo fuente a analizar.
     * Salida: No retorna nada, pero imprime toda la informacion sobre los tokens encontrados.
     * Restricciones: El archivo fuente debe existir.
     */
    public void ejercicioLexerV2024(String rutaScanear) throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(rutaScanear))) {
            BasicLexerCupV lexer = new BasicLexerCupV(reader); // Instancia del lexer
            Symbol token; // Variable para almacenar el token
            int i = 0; // Contador de lexemas encontrados

            System.out.println("Iniciando análisis léxico...");
            generateFile("", false); // Limpia el archivo de salida

            while (true) {
                token = lexer.next_token(); // Obtiene el siguiente token
                if (token.sym == 0) { // Fin del archivo (EOF)
                    System.out.println("Cantidad de lexemas encontrados: " + i);
                    return;
                }

                // Información del token: tipo, lexema, línea y columna
                String lexeme = lexer.yytext();
                int line = token.left + 1; // Línea (ajustar base 0)
                int column = token.right + 1; // Columna (ajustar base 0)

                // Construir la salida para el token
                String output = String.format(
                        "Token: %d, Lexema: %s, Línea: %d, Columna: %d%n",
                        token.sym, lexeme, line, column
                );

                // Imprimir y guardar en el archivo
                System.out.print(output);
                generateFile(output, true);
                i++;
            }
        } catch (Exception e) {
            System.err.println("Error durante el análisis léxico: " + e.getMessage());
        }
    }

    /**
     * Método: generateFile
     * Objetivo: Escribe una linea de texto en un archivo de salida.
     * Entradas:
     *   - action: Texto a escribir en el archivo.
     *   - append: Indica si se debe agregar al final del archivo (true) o sobrescribir (false), esto sirve de forma
     *   que siempre empieza como false, para que se sobreescriba ante cualquier ejecucion anterior, y luego se queda
     *   como true el resto de la ejecucion.
     * Salida: Archivo "tokens_salida.txt" con la informacion proporcionada.
     * Restricciones: El archivo debe tener permisos de escritura.
     */    private void generateFile(String action, boolean append) {
        try (FileWriter writer = new FileWriter("tokens_salida.txt", append)) {
            writer.write(action);
        } catch (IOException e) {
            System.err.println("Error escribiendo en el archivo: " + e.getMessage());
        }
    }
}

