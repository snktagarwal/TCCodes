import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

public class BoredPhilosophers{

  void printArray(Object[] arr){

    for(int i=0;i<arr.length;i++)
      System.out.print(arr[i]);
    System.out.println();

  }

  void printTree(TreeSet<String[]> m){

    Iterator it = m.iterator();

    while(it.hasNext()){
      String[] t = (String[])it.next();
      for(int i = 0;i<t.length;i++)
        System.out.print((String)t[i]);
      System.out.println();

    }

  }


  int[] simulate(String[] inp, int N){

      int[] out = new int[N];
      String text = "";

      for(int i =0;i<inp.length;i++)
        text = text.concat(inp[i]);

      String[] parts = text.split(" ");
      printArray(parts);
      for(int i=1;i<=N;i++){
         TreeSet<String> memo = new TreeSet<String>();

         for(int j=0;j<=parts.length - i;j++){
            String temp = "";
            for(int k=0;k<i;k++)
              temp = temp+" "+parts[j+k];
            memo.add(temp);
         }

        out[i-1] = memo.size();
      }

      return out;
  }

public static void main(String[] args)
	{
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;

		boolean same;
		time = System.currentTimeMillis();
		answer = new BoredPhilosophers().simulate(new String[]{"a a a a a a a b a a b a a a b b a b a a a b a b"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{2, 4, 7, 11, 14, 17 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
	}


}



