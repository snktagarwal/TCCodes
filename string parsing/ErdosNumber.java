import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

public class ErdosNumber{


  public String[] calculateNumbers(String[] publications){


    TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
    tm.put("ERDOS", 0);
    int s = publications.length;

    for(int i=0;i<s;i++)
      for(int j=0;j<s;j++){

         Iterator it = tm.keySet().iterator();
         TreeSet<String> tempIt = new TreeSet<String>();

         while(it.hasNext())
           tempIt.add((String)it.next());

         it = tempIt.iterator();

         while(it.hasNext()){
            String matched = (String)it.next();
            ArrayList al = new ArrayList();

            for(String str: publications[j].split(" "))
              al.add(str);

            if(al.contains(matched)){

              String[] parts = publications[j].split(" ");
              // find the minimum value amongst them
              for(String st: parts){
                if(!tm.containsKey(st))
                    tm.put(st, tm.get(matched)+1);
                else if(tm.get(st) > tm.get(matched)+1)
                    tm.put(st, tm.get(matched)+1);
              }
            }
         }
      }

    ArrayList out = new ArrayList();
    Iterator it = tm.keySet().iterator();

    while(it.hasNext()){
      String key = (String)it.next();
      out.add(key+" "+tm.get(key));
    }

    Collections.sort(out);

    String[] output = new String[out.size()];
    out.toArray(output);

    return output;

  }

  public static void main(String[] args){

    String[] inp = {"ERDOS A", "A B", "B AA C"};
    String[] out = new ErdosNumber().calculateNumbers(inp);

    for(String s: out)
      System.out.println(s);
  }
}


