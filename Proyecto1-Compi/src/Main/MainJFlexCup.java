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
        Map<Integer, Map<String, Set<Integer>>> tokenMap = new HashMap<>(); // Map para tipo -> (lexema -> líneas)

        try (Reader reader = new BufferedReader(new FileReader(rutaScanear))) {
            BasicLexerCupV lexer = new BasicLexerCupV(reader);
            Symbol token;

            System.out.println("Iniciando análisis léxico...");
            generateFile("", false); // Limpiar el archivo de salida al inicio

            while (true) {
                try {
                    token = lexer.next_token();
                    if (token.sym == 0) break; // EOF (fin de archivo)

                    String lexeme = lexer.yytext(); // Lexema del token
                    int line = token.left + 1;     // Línea donde aparece el token (+1 por base 0)
                    int tokenType = token.sym;     // Tipo de token (sym de CUP)

                    // Guardar en el mapa: Tipo -> Lexema -> Líneas
                    tokenMap.putIfAbsent(tokenType, new HashMap<>());
                    tokenMap.get(tokenType).putIfAbsent(lexeme, new TreeSet<>()); // Las lineas se ordenan solas
                    tokenMap.get(tokenType).get(lexeme).add(line);

                } catch (Exception e) {
                    System.err.println("Error léxico: " + e.getMessage());
                }
            }

            // Generar salida con tokens y líneas de aparición
            for (Map.Entry<Integer, Map<String, Set<Integer>>> entry : tokenMap.entrySet()) {
                int tokenType = entry.getKey(); // Tipo de token
                for (Map.Entry<String, Set<Integer>> lexemeEntry : entry.getValue().entrySet()) {
                    String lexeme = lexemeEntry.getKey(); // Lexema del token
                    Set<Integer> lines = lexemeEntry.getValue(); // Líneas de aparición

                    String action = String.format(
                            "Token: %s, Tipo: %s, Líneas de aparición: %s%n",
                            lexeme,
                            getTokenName(tokenType), // Obtener tipo del token
                            lines.toString() // Convertir las líneas a string
                    );

                    System.out.print(action);
                    generateFile(action, true); // Guardar en el archivo
                }
            }

            System.out.println("Análisis léxico completado.");
        } catch (Exception e) {
            System.err.println("Error durante el análisis léxico: " + e.getMessage());
        }
    }

    /**
     * Método: getTokenName
     * Objetivo: Obtener la descripción del tipo de token a partir de su identificador `sym` declarado en el .jflex.
     * Entradas:
     *   - tokenSym: Identificador numerico del token.
     * Salida: Nombre descriptivo del token.
     * Restricciones: El token debe existir en la lista definida de `sym` dentro del archivo .jflex.
     */
    private String getTokenName(int tokenSym) {
        switch (tokenSym) {
            // Tipos de datos
            case sym.INTEGER: return "Tipo de dato (entero)";
            case sym.FLOAT: return "Tipo de dato (flotante)";
            case sym.BOOL: return "Tipo de dato (booleano)";
            case sym.CHAR: return "Tipo de dato (carácter)";
            case sym.STRING: return "Tipo de dato (cadena)";

            // Literales
            case sym.L_INTEGER: return "Literal (entero)";
            case sym.L_FLOAT: return "Literal (flotante)";
            case sym.L_STRING: return "Literal (cadena)";

            // Identificadores
            case sym.IDENTIFICADOR: return "Identificador";

            // Operadores aritméticos
            case sym.SUMA: return "Operador aritmético (suma)";
            case sym.RESTA: return "Operador aritmético (resta)";
            case sym.DIVISION: return "Operador aritmético (división)";
            case sym.MULTIPLICACION: return "Operador aritmético (multiplicación)";
            case sym.MODULO: return "Operador aritmético (módulo)";
            case sym.POTENCIA: return "Operador aritmético (potencia)";
            case sym.INCREMENTO: return "Operador unario (incremento)";
            case sym.DECREMENTO: return "Operador unario (decremento)";
            case sym.NEGATIVO: return "Operador unario (negativo)";

            // Operadores relacionales
            case sym.MENOR: return "Operador relacional (menor)";
            case sym.MENOR_IGUAL: return "Operador relacional (menor o igual)";
            case sym.MAYOR: return "Operador relacional (mayor)";
            case sym.MAYOR_IGUAL: return "Operador relacional (mayor o igual)";
            case sym.IGUAL: return "Operador relacional (igual)";
            case sym.DIFERENTE: return "Operador relacional (diferente)";

            // Operadores lógicos
            case sym.CONJUNCION: return "Operador lógico (conjunción)";
            case sym.DISYUNCION: return "Operador lógico (disyunción)";
            case sym.NEGACION: return "Operador lógico (negación)";

            // Asignación
            case sym.ASIGNA: return "Operador de asignación";

            // Delimitadores y paréntesis
            case sym.ABRECUENTO: return "Apertura de bloque (abrecuento)";
            case sym.CIERRACUENTO: return "Cierre de bloque (cierracuento)";
            case sym.ABREEMPAQUE: return "Apertura de arreglo (abreempaque)";
            case sym.CIERREEMPAQUE: return "Cierre de arreglo (cierraempaque)";
            case sym.PARENTESISAPERTURA: return "Paréntesis de apertura";
            case sym.PARENTESISCIERRE: return "Paréntesis de cierre";
            case sym.FIN_EXPRESION: return "Delimitador de fin de expresión";

            // Estructuras de control
            case sym.IF: return "Estructura de control (if)";
            case sym.ELSE: return "Estructura de control (else)";
            case sym.WHILE: return "Estructura de control (while)";
            case sym.FOR: return "Estructura de control (for)";
            case sym.SWITCH: return "Estructura de control (switch)";
            case sym.CASE: return "Estructura de control (case)";
            case sym.DEFAULT: return "Estructura de control (default)";
            case sym.BREAK: return "Control de flujo (break)";
            case sym.RETURN: return "Control de flujo (return)";
            case sym.DOS_PUNTOS: return "Delimitador (dos puntos)";

            // Operaciones de entrada/salida
            case sym.PRINT: return "Operación de salida (print)";
            case sym.READ: return "Operación de entrada (read)";

            // Token principal
            case sym.MAIN: return "Procedimiento principal (_verano_)";

            // Otros
            case sym.EOF: return "Fin de archivo (EOF)";

            default: return "Token desconocido";
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

