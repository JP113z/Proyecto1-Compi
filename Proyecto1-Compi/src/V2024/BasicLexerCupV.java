// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: Proyecto1-Compi/src/V2024/basicLexerCupVerano2024.jflex

/* JFlex example: partial Java language lexer specification */
package ParserLexer;

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 *
 * Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer.
 * Este lexer es utilizado por por el parser generado por BasicLexerCup (parser.java que se genera).
 */

@SuppressWarnings("fallthrough")
public class BasicLexerCupV implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\3\22\0\1\4"+
    "\1\0\1\5\7\0\1\6\2\0\1\7\1\0\1\10"+
    "\12\11\7\0\32\11\1\0\1\12\2\0\1\13\1\0"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\2\11\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\11\u0185\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\1\1\1\5\1\1"+
    "\14\5\1\6\1\7\1\1\2\0\1\10\1\0\20\5"+
    "\1\11\1\12\1\13\1\14\1\15\2\0\1\16\20\5"+
    "\3\0\1\2\10\5\1\17\23\5\1\20\11\5\1\21"+
    "\1\22\2\5\1\23\15\5\1\24\1\5\1\25\1\5"+
    "\1\26\1\5\1\27\1\30\10\5\1\31\1\32\3\5"+
    "\1\33\3\5\1\34\1\35\1\5\1\36\3\5\1\37"+
    "\3\5\1\40\1\5\1\41\1\42";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\106\0\106\0\151\0\106\0\106\0\214"+
    "\0\257\0\322\0\365\0\u0118\0\u013b\0\u015e\0\u0181\0\u01a4"+
    "\0\u01c7\0\u01ea\0\u020d\0\u0230\0\u0253\0\u0276\0\u0299\0\106"+
    "\0\u02bc\0\u02df\0\u0302\0\u0325\0\u0348\0\u036b\0\u038e\0\u03b1"+
    "\0\u03d4\0\u03f7\0\u041a\0\u043d\0\u0460\0\u0483\0\u04a6\0\u04c9"+
    "\0\u04ec\0\u050f\0\u0532\0\u0555\0\u0578\0\106\0\106\0\106"+
    "\0\106\0\106\0\u059b\0\u05be\0\106\0\u05e1\0\u0604\0\u0627"+
    "\0\u064a\0\u066d\0\u0690\0\u06b3\0\u06d6\0\u06f9\0\u071c\0\u073f"+
    "\0\u0762\0\u0785\0\u07a8\0\u07cb\0\u07ee\0\u0811\0\u0834\0\u0857"+
    "\0\u0834\0\u087a\0\u089d\0\u08c0\0\u08e3\0\u0906\0\u0929\0\u094c"+
    "\0\u096f\0\257\0\u0992\0\u09b5\0\u09d8\0\u09fb\0\u0a1e\0\u0a41"+
    "\0\u0a64\0\u0a87\0\u0aaa\0\u0acd\0\u0af0\0\u0b13\0\u0b36\0\u0b59"+
    "\0\u0b7c\0\u0b9f\0\u0bc2\0\u0be5\0\u0c08\0\257\0\u0c2b\0\u0c4e"+
    "\0\u0c71\0\u0c94\0\u0cb7\0\u0cda\0\u0cfd\0\u0d20\0\u0d43\0\257"+
    "\0\257\0\u0d66\0\u0d89\0\257\0\u0dac\0\u0dcf\0\u0df2\0\u0e15"+
    "\0\u0e38\0\u0e5b\0\u0e7e\0\u0ea1\0\u0ec4\0\u0ee7\0\u0f0a\0\u0f2d"+
    "\0\u0f50\0\257\0\u0f73\0\257\0\u0f96\0\257\0\u0fb9\0\106"+
    "\0\257\0\u0fdc\0\u0fff\0\u1022\0\u1045\0\u1068\0\u108b\0\u10ae"+
    "\0\u10d1\0\257\0\257\0\u10f4\0\u1117\0\u113a\0\106\0\u115d"+
    "\0\u1180\0\u11a3\0\257\0\257\0\u11c6\0\257\0\u11e9\0\u120c"+
    "\0\u122f\0\257\0\u1252\0\u1275\0\u1298\0\257\0\u12bb\0\257"+
    "\0\257";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\5\1\4\1\6\1\3\1\7\1\10"+
    "\1\11\1\3\1\12\1\13\1\14\1\15\1\11\1\16"+
    "\1\11\1\17\3\11\1\20\1\11\1\21\1\11\1\22"+
    "\1\23\1\24\1\25\1\26\4\11\2\27\2\3\1\27"+
    "\1\30\4\27\1\31\30\27\45\0\1\4\46\0\1\32"+
    "\1\0\1\33\43\0\1\11\2\0\27\11\11\34\1\35"+
    "\2\34\27\35\11\0\1\11\2\0\1\11\1\36\25\11"+
    "\11\0\1\11\2\0\17\11\1\37\7\11\11\0\1\11"+
    "\2\0\10\11\1\40\3\11\1\41\5\11\1\42\4\11"+
    "\11\0\1\11\2\0\13\11\1\43\7\11\1\44\3\11"+
    "\11\0\1\11\2\0\17\11\1\45\7\11\11\0\1\11"+
    "\2\0\1\46\7\11\1\47\16\11\11\0\1\11\2\0"+
    "\15\11\1\50\11\11\11\0\1\11\2\0\22\11\1\51"+
    "\4\11\11\0\1\11\2\0\14\11\1\52\12\11\11\0"+
    "\1\11\2\0\13\11\1\53\13\11\11\0\1\11\2\0"+
    "\17\11\1\54\7\11\11\0\1\11\2\0\15\11\1\55"+
    "\11\11\2\27\2\0\1\27\1\0\4\27\1\0\30\27"+
    "\5\0\1\56\4\0\1\57\14\0\1\60\3\0\1\61"+
    "\1\0\1\62\5\0\6\63\1\64\34\63\2\33\1\4"+
    "\1\5\37\33\11\34\1\0\2\34\40\0\1\35\1\0"+
    "\1\65\27\35\11\0\1\11\2\0\17\11\1\66\7\11"+
    "\11\0\1\11\2\0\14\11\1\67\12\11\11\0\1\11"+
    "\2\0\4\11\1\70\22\11\11\0\1\11\2\0\12\11"+
    "\1\71\14\11\11\0\1\11\2\0\15\11\1\72\11\11"+
    "\11\0\1\11\2\0\21\11\1\73\5\11\11\0\1\11"+
    "\2\0\4\11\1\74\22\11\11\0\1\11\2\0\10\11"+
    "\1\75\16\11\11\0\1\11\2\0\17\11\1\76\7\11"+
    "\11\0\1\11\2\0\13\11\1\77\13\11\11\0\1\11"+
    "\2\0\4\11\1\100\22\11\11\0\1\11\2\0\10\11"+
    "\1\101\16\11\11\0\1\11\2\0\3\11\1\102\23\11"+
    "\11\0\1\11\2\0\14\11\1\103\12\11\11\0\1\11"+
    "\2\0\22\11\1\104\4\11\11\0\1\11\2\0\1\105"+
    "\26\11\6\63\1\106\34\63\6\107\1\110\1\107\1\111"+
    "\32\107\11\0\1\11\2\0\4\11\1\112\22\11\11\0"+
    "\1\11\2\0\12\11\1\113\14\11\11\0\1\11\2\0"+
    "\17\11\1\114\7\11\11\0\1\11\2\0\4\11\1\115"+
    "\22\11\11\0\1\11\2\0\10\11\1\116\16\11\11\0"+
    "\1\11\2\0\17\11\1\117\7\11\11\0\1\11\2\0"+
    "\17\11\1\120\7\11\11\0\1\11\2\0\13\11\1\121"+
    "\13\11\11\0\1\11\2\0\26\11\1\122\11\0\1\11"+
    "\2\0\20\11\1\123\6\11\11\0\1\11\2\0\13\11"+
    "\1\124\13\11\11\0\1\11\2\0\4\11\1\125\22\11"+
    "\11\0\1\11\2\0\14\11\1\126\12\11\11\0\1\11"+
    "\2\0\24\11\1\127\2\11\11\0\1\11\2\0\4\11"+
    "\1\130\22\11\11\0\1\11\2\0\21\11\1\131\5\11"+
    "\6\0\1\106\1\0\1\4\32\0\6\107\1\110\42\107"+
    "\1\64\1\107\1\4\32\107\11\0\1\11\2\0\2\11"+
    "\1\132\1\11\1\133\12\11\1\134\7\11\11\0\1\11"+
    "\2\0\10\11\1\135\16\11\11\0\1\11\2\0\17\11"+
    "\1\136\7\11\11\0\1\11\2\0\21\11\1\137\5\11"+
    "\11\0\1\11\2\0\3\11\1\140\23\11\11\0\1\11"+
    "\2\0\4\11\1\141\22\11\11\0\1\11\2\0\6\11"+
    "\1\142\20\11\11\0\1\11\2\0\2\11\1\143\24\11"+
    "\11\0\1\11\2\0\21\11\1\144\5\11\11\0\1\11"+
    "\2\0\20\11\1\145\6\11\11\0\1\11\2\0\13\11"+
    "\1\146\13\11\11\0\1\11\2\0\11\11\1\147\15\11"+
    "\11\0\1\11\2\0\1\11\1\150\25\11\11\0\1\11"+
    "\2\0\13\11\1\151\13\11\11\0\1\11\2\0\17\11"+
    "\1\152\7\11\11\0\1\11\2\0\22\11\1\153\4\11"+
    "\11\0\1\11\2\0\12\11\1\154\14\11\11\0\1\11"+
    "\2\0\4\11\1\155\22\11\11\0\1\11\2\0\20\11"+
    "\1\156\6\11\11\0\1\11\2\0\1\157\26\11\11\0"+
    "\1\11\2\0\1\160\26\11\11\0\1\11\2\0\14\11"+
    "\1\161\12\11\11\0\1\11\2\0\6\11\1\162\20\11"+
    "\11\0\1\11\2\0\17\11\1\163\7\11\11\0\1\11"+
    "\2\0\7\11\1\164\17\11\11\0\1\11\2\0\10\11"+
    "\1\165\16\11\11\0\1\11\2\0\11\11\1\166\15\11"+
    "\11\0\1\11\2\0\5\11\1\167\21\11\11\0\1\11"+
    "\2\0\1\170\26\11\11\0\1\11\2\0\14\11\1\171"+
    "\12\11\11\0\1\11\2\0\4\11\1\172\22\11\11\0"+
    "\1\11\2\0\4\11\1\173\22\11\11\0\1\11\2\0"+
    "\15\11\1\174\11\11\11\0\1\11\2\0\6\11\1\175"+
    "\20\11\11\0\1\11\2\0\21\11\1\176\5\11\11\0"+
    "\1\11\2\0\2\11\1\177\1\11\1\200\12\11\1\201"+
    "\7\11\11\0\1\11\2\0\1\202\26\11\11\0\1\11"+
    "\2\0\4\11\1\203\22\11\11\0\1\11\2\0\25\11"+
    "\1\204\1\11\11\0\1\11\2\0\1\205\26\11\11\0"+
    "\1\11\2\0\14\11\1\206\12\11\11\0\1\11\2\0"+
    "\11\11\1\207\15\11\4\0\1\210\4\0\1\11\2\0"+
    "\27\11\11\0\1\11\2\0\4\11\1\211\22\11\11\0"+
    "\1\11\2\0\13\11\1\212\13\11\11\0\1\11\2\0"+
    "\1\213\26\11\11\0\1\11\2\0\1\214\26\11\11\0"+
    "\1\11\2\0\1\215\26\11\11\0\1\11\2\0\22\11"+
    "\1\216\4\11\11\0\1\11\2\0\12\11\1\217\14\11"+
    "\11\0\1\11\2\0\4\11\1\220\22\11\11\0\1\11"+
    "\2\0\4\11\1\221\22\11\11\0\1\11\2\0\4\11"+
    "\1\222\22\11\11\0\1\11\2\0\11\11\1\223\15\11"+
    "\11\0\1\11\2\0\21\11\1\224\5\11\11\0\1\11"+
    "\2\0\16\11\1\225\10\11\11\0\1\11\2\0\11\11"+
    "\1\226\15\11\4\0\1\227\4\0\1\11\2\0\27\11"+
    "\11\0\1\11\2\0\4\11\1\230\22\11\11\0\1\11"+
    "\2\0\15\11\1\231\11\11\11\0\1\11\2\0\6\11"+
    "\1\232\20\11\11\0\1\11\2\0\13\11\1\233\13\11"+
    "\11\0\1\11\2\0\14\11\1\234\12\11\11\0\1\11"+
    "\2\0\22\11\1\235\4\11\11\0\1\11\2\0\14\11"+
    "\1\236\12\11\11\0\1\11\2\0\13\11\1\237\13\11"+
    "\11\0\1\11\2\0\1\240\26\11\11\0\1\11\2\0"+
    "\1\241\26\11\11\0\1\11\2\0\4\11\1\242\22\11"+
    "\11\0\1\11\2\0\21\11\1\243\5\11\11\0\1\11"+
    "\2\0\16\11\1\244\10\11\11\0\1\11\2\0\11\11"+
    "\1\245\15\11\11\0\1\11\2\0\14\11\1\246\12\11"+
    "\11\0\1\11\2\0\22\11\1\247\4\11\11\0\1\11"+
    "\2\0\14\11\1\250\12\11\11\0\1\11\2\0\4\11"+
    "\1\251\22\11";

  private static int [] zzUnpacktrans() {
    int [] result = new int[4830];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\1\1\2\11\20\1\1\11\1\1\2\0"+
    "\1\1\1\0\20\1\5\11\2\0\1\11\20\1\3\0"+
    "\77\1\1\11\16\1\1\11\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
/* Definiciones de código Java */
StringBuffer string = new StringBuffer();

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public BasicLexerCupV(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Error("Illegal character <" + yytext() + ">");
            }
          // fall through
          case 35: break;
          case 2:
            { /* ignore */
            }
          // fall through
          case 36: break;
          case 3:
            { string.setLength(0); yybegin(STRING);
            }
          // fall through
          case 37: break;
          case 4:
            { return symbol(sym.NEGATIVO);
            }
          // fall through
          case 38: break;
          case 5:
            { System.err.println("Error léxico en línea " + yyline + ", columna " + yycolumn + ": identificador sin guiones bajos '" + yytext() + "'");
        /* si fuera solo x*/
            }
          // fall through
          case 39: break;
          case 6:
            { string.append(yytext());
            }
          // fall through
          case 40: break;
          case 7:
            { yybegin(YYINITIAL); return symbol(sym.L_STRING, string.toString());
            }
          // fall through
          case 41: break;
          case 8:
            { System.err.println("Error léxico en línea " + yyline + ", columna " + yycolumn + ": identificador mal formado '" + yytext() + "'");
        /* si falta un _ como _x o x_ o un simbolo no valido como @ */
            }
          // fall through
          case 42: break;
          case 9:
            { string.append('\"');
            }
          // fall through
          case 43: break;
          case 10:
            { string.append('\\');
            }
          // fall through
          case 44: break;
          case 11:
            { string.append('\n');
            }
          // fall through
          case 45: break;
          case 12:
            { string.append('\r');
            }
          // fall through
          case 46: break;
          case 13:
            { string.append('\t');
            }
          // fall through
          case 47: break;
          case 14:
            { return symbol(sym.IDENTIFICADOR);
            }
          // fall through
          case 48: break;
          case 15:
            { return symbol(sym.IGUAL);
            }
          // fall through
          case 49: break;
          case 16:
            { return symbol(sym.INCREMENTO);
            }
          // fall through
          case 50: break;
          case 17:
            { return symbol(sym.STRING);
            }
          // fall through
          case 51: break;
          case 18:
            { return symbol(sym.CHAR);
            }
          // fall through
          case 52: break;
          case 19:
            { return symbol(sym.DECREMENTO);
            }
          // fall through
          case 53: break;
          case 20:
            { return symbol(sym.ASIGNA);
            }
          // fall through
          case 54: break;
          case 21:
            { return symbol(sym.MAYOR);
            }
          // fall through
          case 55: break;
          case 22:
            { return symbol(sym.INTEGER);
            }
          // fall through
          case 56: break;
          case 23:
            { return symbol(sym.BOOL);
            }
          // fall through
          case 57: break;
          case 24:
            { return symbol(sym.MAYOR_IGUAL);
            }
          // fall through
          case 58: break;
          case 25:
            { return symbol(sym.DIFERENTE);
            }
          // fall through
          case 59: break;
          case 26:
            { return symbol(sym.MENOR);
            }
          // fall through
          case 60: break;
          case 27:
            { return symbol(sym.FLOAT);
            }
          // fall through
          case 61: break;
          case 28:
            { return symbol(sym.MENOR_IGUAL);
            }
          // fall through
          case 62: break;
          case 29:
            { return symbol(sym.ABRECUENTO);
            }
          // fall through
          case 63: break;
          case 30:
            { return symbol(sym.PARENTESISAPERTURA);
            }
          // fall through
          case 64: break;
          case 31:
            { return symbol(sym.ABREEMPAQUE);
            }
          // fall through
          case 65: break;
          case 32:
            { return symbol(sym.CIERRACUENTO);
            }
          // fall through
          case 66: break;
          case 33:
            { return symbol(sym.PARENTESISCIERRE);
            }
          // fall through
          case 67: break;
          case 34:
            { return symbol(sym.CIERREEMPAQUE);
            }
          // fall through
          case 68: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
