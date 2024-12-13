package Main;

import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    public static void GenerarLexerParser() throws Exception {
        String basePath = System.getProperty("user.dir");
        // Actualiza las rutas para que coincidan con la estructura actual
        String lexerPath = basePath + "\\Proyecto1-Compi\\src\\V2024\\basicLexerCupVerano2024.jflex";
        String parserPath = basePath + "\\Proyecto1-Compi\\src\\V2024\\parserV2024Ini.cup";

        String parserFile = "parser.java";
        String lexerFile = "MyLexer.java";

        // Instancia para la gestión del lexer y parser
        MainJFlexCup mainTool = new MainJFlexCup();

        // Eliminar archivos generados previamente
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\sym.java"));
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + parserFile));
        Files.deleteIfExists(Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + lexerFile));

        // Generar lexer y parser
        mainTool.iniLexerParser(lexerPath, parserPath);

        // Mover los archivos generados a la carpeta correspondiente
        Files.move(Paths.get(basePath + "\\sym.java"), Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\sym.java"));
        Files.move(Paths.get(basePath + "\\" + lexerFile), Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + lexerFile));
        Files.move(Paths.get(basePath + "\\" + parserFile), Paths.get(basePath + "\\Proyecto1-Compi\\src\\ParserLexer\\" + parserFile));
    }

    public static void PruebasLexerParser(String inputPath) throws Exception {
        MainJFlexCup mainTool = new MainJFlexCup();

        // Probar el lexer con un archivo de entrada
        mainTool.ejercicioLexerV2024(inputPath);
    }


    public static void main(String[] args) {
        try {
            GenerarLexerParser();
            // PruebasLexerParser(System.getProperty("user.dir") + "\\Proyecto1-Compi\\src\\codigoPrueba\\ejemplo1.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

