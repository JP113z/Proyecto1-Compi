package Main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    /**
     * Método: GenerarLexerParser
     * Objetivo: Generar el lexer y parser utilizando los archivos .jflex y .cup, eliminando archivos previos
     *           y moviendo los archivos genGterados a la carpeta llamada ParserLexer.
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

        mainTool.pruebaParser(inputPath);
    }

    /**
     * Método: pedirRutaArchivo
     * Objetivo: Mostrar un pequeño menú para que el usuario ingrese la ruta del archivo a analizar, se repetira con un while
     *          hasta que el input del usuario sea valido
     * Entradas: Ninguna.
     * Salida: Ruta valida ingresada por el usuario.
     * Restricciones: La ruta debe ser valida y el archivo debe existir.
     */
    public static String pedirRutaArchivo() {
        String rutaCompleta;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingresa la ruta del archivo al que desea realizarle el análisis léxico: ");
                rutaCompleta = scanner.nextLine();

                File archivo = new File(rutaCompleta);
                if (archivo.exists() && archivo.isFile()) {
                    System.out.println("Ruta válida. Procesando el archivo...");
                    break;
                } else {
                    System.out.println("La ruta ingresada no es válida o el archivo no existe. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("Error al leer la entrada. Inténtalo nuevamente.");
                scanner.nextLine();
            }
        }
        return rutaCompleta;
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
            String rutaArchivo = pedirRutaArchivo();
            GenerarLexerParser();

            PruebasLexerParser(rutaArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

