import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class InternetSecurity
{

  void printArray(Object[] arr){

    for(int i=0;i<arr.length;i++)
      System.out.println(arr[i]);

  }
	public String[] determineWebsite(String[] address, String[] keyword, String[] dangerous, int threshold)
	{
      ArrayList dang = new ArrayList();
      ArrayList dang_addr = new ArrayList();

      for(int i = 0;i<dangerous.length;i++)
          dang.add(dangerous[i]);

      do{

        // find one dangerous website
        boolean found = false;
        for(int i = 0;i<address.length;i++)
          if(dang_addr.contains(address[i])) continue;
          else{
            printArray(dang_addr.toArray());
            int count = 0;
            for(int j=0;j<dang.size();j++)
              if(keyword[i].indexOf((String)dang.get(j)) != -1) count++;

            if(count>=threshold){
              dang_addr.add(address[i]);
              String[] add_dang = keyword[i].split(" ");
              printArray(add_dang);
              for(int k=0;k<add_dang.length;k++)
                if(!dang.contains(add_dang[k])) dang.add(add_dang[k]);
              found = true;
            }
          }
          if(!found){
              for(int k=0;k<dang_addr.size();k++)
                  System.out.println((String)dang_addr.get(k));
              String[] out = new String[dang_addr.size()];
              dang_addr.toArray(out);
              return out;
            }


      }while(true);
	}

public static void main(String[] args)
	{
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;

		boolean same;
		time = System.currentTimeMillis();
		answer = new InternetSecurity().determineWebsite(new String[]{"www.topcoder.com","www.sindicate_of_evil.com","www.happy_citizens.com"}, new String[]{"hack encryption decryption internet algorithm","signal interference evil snake poison algorithm","flower baloon topcoder blue sky sea"}, new String[]{"hack","encryption","decryption","interference","signal","internet"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"www.topcoder.com", "www.sindicate_of_evil.com" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new InternetSecurity().determineWebsite(new String[]{"brokenlink","flowerpower.net","purchasedomain.com"}, new String[]{"broken","rose tulips","cheap free domain biggest greatest"}, new String[]{"biggest","enemy","hideout"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{ };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new InternetSecurity().determineWebsite(new String[]{"a..a.ab.","...aa.b"}, new String[]{"a bc def","def ghij klmno"}, new String[]{"a","b","c","d","e"}, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"a..a.ab.", "...aa.b" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new InternetSecurity().determineWebsite(new String[]{"www.tsa.gov"}, new String[]{"information assurance signal intelligence research"}, new String[]{"signal","assurance","penguin"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"www.tsa.gov" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}


}

