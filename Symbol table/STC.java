import java.util.*;

public class STC extends Object {


  String type;  // type,in calculator expample there only is one type==> Int.
  String value; // value, the value in here is a string not a integer value.
  int state;

  public STC(String itype, String ivalue, String istate) {
    type=itype;
    value=ivalue;
    state = Integer.parseInt(istate);
  }

  public STC(String itype, String ivalue, int istate) {
    type=itype;
    value=ivalue;
    state = istate;
  }
}