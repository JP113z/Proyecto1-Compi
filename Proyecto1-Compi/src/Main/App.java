package Main;

import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    /**
     * Método: GenerarLexerParser
     * Objetivo: Generar el lexer y parser utilizando los archivos .jflex y .cup, eliminando archivos previos
     *           y moviendo los archivos generados a la carpeta llamada ParserLexer.
     * Entradas: Ninguna.
     * Salida: Genera y mueve los archivos `sym.java`, `BasicLexerCupV.java` y `parser.java`
     *         a la carpeta `ParserLexer`.
     * Restricciones:
     *   - Los archivos .jflex y .cup deben existir en las rutas especificadas.
     */
    public static void GenerarLexerParser() throws Exception {
        String basePath = System.getProperty("user.dir");

        // Actualiza las rutas para que coincidan con la estructura actual
        String lexerPath = basePath + "\\Proyecto1-Compi\\src\\V2024\\basicLexerCupVerano2024.jflex";
        String parserPath = basePath + "\\Proyecto1-Compi\\src\\V2024\\parserV2024Ini.cup";

        String parserFile = "parser.java";
        String lexerFile = "BasicLexerCupV.java";

        // Instancia para la gestión del lexer y parser
        MainJFlexCup mainTool = new MainJFlexCup();

        // Eliminar archivos generados previamente en la carpeta ParserLexer
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\sym.java"));
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\BasicLexerCupV.java"));
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\parser.java"));

        // Generar lexer y parser
        mainTool.iniLexerParser(lexerPath, parserPath);

        // **Mover los archivos generados**
        // sym.java
        if (Files.exists(Paths.get(basePath + "\\sym.java"))) {
            Files.move(
                    Paths.get(basePath + "\\sym.java"),
                    Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\sym.java")
            );
        } else {
            System.err.println("Error: No se generó el archivo sym.java.");
        }

        // BasicLexerCupV.java
        if (Files.exists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\V2024\\" + lexerFile))) {
            Files.move(
                    Paths.get(basePath + "\\Proyecto1-Compi\\src\\V2024\\" + lexerFile),
                    Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + lexerFile)
            );
        } else {
            System.err.println("Error: No se generó el archivo BasicLexerCupV.java.");
        }

        // parser.java
        if (Files.exists(Paths.get(basePath + "\\" + parserFile))) {
            Files.move(
                    Paths.get(basePath + "\\" + parserFile),
                    Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + parserFile)
            );
        } else {
            System.err.println("Error: No se generó el archivo parser.java.");
        }
    }

    /**
     * Método: PruebasLexerParser
     * Objetivo: Ejecuta el analisis lexico del archivo de entrada haciendo una llamada al metodo 'ejercicioLexerV2024'
     * que se encuentra en la clase MainJFlexCup.
     * Entradas:
     *   - inputPath: Ruta del archivo fuente a analizar.
     * Salida: Ninguna, solo llama a ese metodo, es el metodo al que llama que tiene salidas.
     * Restricciones:
     *   - El archivo fuente especificado en `inputPath` debe existir y estar correctamente formateado.
     */
    public static void PruebasLexerParser(String inputPath) throws Exception {
        MainJFlexCup mainTool = new MainJFlexCup();

        // Probar el lexer con un archivo de entrada
        mainTool.ejercicioLexerV2024(inputPath);
    }

    /**
     * Método: main
     * Objetivo: Punto de entrada principal del programa. Ejecuta los metodos para generar
     *           el lexer/parser y probar el analisis léxico sobre un archivo de ejemplo.
     * Entradas: Ninguna.
     * Salida: Ninguna, solo llama a ese metodo, es el metodo al que llama que tiene salidas.
     * Restricciones:
     *   - La ruta del archivo fuente debe existir.
     *   - Los archivos .jflex y .cup deben estar correctamente configurados.
     */
    public static void main(String[] args) {
        try {
            GenerarLexerParser();
            PruebasLexerParser(System.getProperty("user.dir") + "\\Proyecto1-Compi\\src\\codigoPrueba\\ejemplo1.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

