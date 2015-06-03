/* TuringMachine.java */
/* Generated By:JavaCC: Do not edit this line. TuringMachine.java */
import java.io.*;
// c�digo Java que invoca o parser
public class TuringMachine implements TuringMachineConstants {
        public static void main(String args[]) throws ParseException, FileNotFoundException {
                TuringMachine parser = new TuringMachine(new FileInputStream(args[0]));
                parser.file();
        }

  static void error_skipto(int kind, String type) throws ParseException {ParseException e = generateParseException();
  System.out.println("OMG you wrote a " + type + " wrong!!! D:");
  Token t;
  do {
    t = getNextToken();
  } while(t.kind != kind);
  }

  static void tokenerror_skipto(int kind) throws ParseException {System.out.println("---ILLEGAL TOKEN---");
  Token t;
  do {
    t = getNextToken();
  } while(t.kind != kind);
  }

// defini��o da produ��o
  static final public void read() throws ParseException {
System.out.println("READ");
    jj_consume_token(READ_KEYWORD);
    jj_consume_token(SYMBOL);
  }

  static final public void write() throws ParseException {
System.out.println("WRITE");
    jj_consume_token(WRITE_KEYWORD);
    jj_consume_token(SYMBOL);
  }

  static final public void state() throws ParseException {
System.out.println("STATE");
    try {
      jj_consume_token(STATE_KEYWORD);
      jj_consume_token(INTEGER);
      jj_consume_token(CARD_BEG_KEYWORD);
    } catch (TokenMgrError e) {
tokenerror_skipto(CARD_BEG_KEYWORD);
    } catch (ParseException e) {
error_skipto(CARD_BEG_KEYWORD, "card header");
    }
  }

  static final public void nextstate() throws ParseException {
System.out.println("JUMP");
    jj_consume_token(JUMP_KEYWORD);
    jj_consume_token(INTEGER);
  }

  static final public void direction() throws ParseException {
System.out.println("MOVE");
    jj_consume_token(MOVE_KEYWORD);
    jj_consume_token(DIRECTION);
  }

  static final public void line() throws ParseException {
System.out.println("LINE");
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case READ_KEYWORD:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      read();
      jj_consume_token(COMMA);
      write();
      jj_consume_token(COMMA);
      direction();
      jj_consume_token(COMMA);
      nextstate();
      jj_consume_token(SEMICOLON);
    }
  }

  static final public void endstate() throws ParseException {
System.out.println("CARDEND");
    jj_consume_token(CARD_END_KEYWORD);
  }

  static final public void card() throws ParseException {int correctCard = 1;
  int wrongCard = 0;
  int correctCardCount = 0;
  int wrongCardCount = 0;
System.out.println("CARD");
    state();
    line();
    endstate();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STATE_KEYWORD:{
      card();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  static final public void file() throws ParseException {int correctCompile = 0;
  int wrongCompile = 0;
    card();
System.out.println("EOF");
    jj_consume_token(0);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public TuringMachineTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8000,0x1000,};
   }

  /** Constructor with InputStream. */
  public TuringMachine(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TuringMachine(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TuringMachineTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public TuringMachine(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TuringMachineTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public TuringMachine(TuringMachineTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TuringMachineTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[21];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 21; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
