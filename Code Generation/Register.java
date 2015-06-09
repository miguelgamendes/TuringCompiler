import java.util.*;

public class REG extends Object {

  public  int value;   // the value of register ;
  public  boolean inuse=false;
  private int regid=-1;



  public REG(int id) {
	  regid=id;
  }

  public void setId(int id){
	  regid=id;
	  }
  public int getId(){
	  return regid;
	  }


  public void setValue(int newvalue){
	  value=newvalue;
	  }

  public void use(){
	  inuse=true;
	  }

  public void release(){

	  inuse=false;

	  }


}