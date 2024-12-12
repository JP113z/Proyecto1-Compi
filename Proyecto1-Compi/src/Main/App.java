package Main;

import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    public static void GenerarLexerParser() throws Exception {
        String basePath, fullPathLexer, fullPathParser, jlexer, jparser, jlexerCarpeta;
        MainJFlexCup mfjc;

        basePath = System.getProperty("user.dir");
        // java de parser y lexer
        jlexer = "parser.java";
        jparser = "MyLexer.java";
        jlexerCarpeta = "";

        mfjc = new MainJFlexCup();

        // genera el analizador léxico y sintáctico
        // elimina archivos
        Files.deleteIfExists(Paths.get(basePath + "\\src\\ParserLexer\\sym.java"));

        // Verano 2024
        fullPathLexer = basePath + "\\src\\V2024\\basicLexerCupVerano2024.jflex";
        fullPathParser = basePath + "\\src\\V2024\\parserV2024Ini.cup";

        Files.deleteIfExists(Paths.get(basePath + "\\src\\ParserLexer\\" + jparser));
        Files.deleteIfExists(Paths.get(basePath + "\\src\\ParserLexer\\" + jlexer));

        // crear analizar léxico y sintáctico
        mfjc.iniLexerParser(fullPathLexer, fullPathParser);

        // mover archivos
        Files.move(Paths.get(basePath + "\\sym.java"), Paths.get(basePath + "\\src\\ParserLexer\\sym.java"));
        Files.move(Paths.get(basePath + "\\" + jparser), Paths.get(basePath + "\\src\\ParserLexer\\" + jparser));
        Files.move(Paths.get(basePath + "\\src\\" + jlexerCarpeta + "\\" + jlexer), Paths.get(basePath + "\\src\\ParserLexer\\" + jlexer));
    }

    public static void PruebasLexerParser() throws Exception {
        String basePath, fullPathScanner, fullPathParser, fullPathParserIT2024, fullPathParserV2024;
        MainJFlexCup mfjc;

        basePath = System.getProperty("user.dir");
        fullPathScanner = basePath + "\\src\\codigoPrueba\\ejemplo1.txt";
        fullPathParser = basePath + "\\src\\codigoPrueba\\ejemploParser.txt";
        fullPathParserIT2024 = basePath + "\\src\\codigoPrueba\\ejemploParserIT2024.txt";
        fullPathParserV2024 = basePath + "\\src\\codigoPrueba\\ejemploParserV2024.txt";

        mfjc = new MainJFlexCup();
        // ejercicio de prueba scanner
        mfjc.ejercicioLexerV2024(fullPathParserV2024); // lexer cup ajustado V 2024
    }

    public static void main(String[] args) throws Exception {
        // GenerarLexerParser();
        // GenerarBasico();
        PruebasLexerParser();
    }
}
