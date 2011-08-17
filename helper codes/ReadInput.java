import java.io.*;
import java.util.*;

public class ReadInput{


  public String[] readAllStdin(){

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList inp = new ArrayList();
    try{
      String temp = br.readLine();
      while(temp != null){
          inp.add(temp);
          temp = br.readLine();
        }
    }
    catch(Exception ex){}

    String[] inp_str = new String[inp.size()];
    inp.toArray(inp_str);
    return inp_str;
  }

  public static void main(String[] args){

    String[] out = new ReadInput().readAllStdin();
    for(String s: out)
      System.out.println(s);

  }
}
