import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ParkAmusement
{
	public double getProbability(String[] landings, int startLanding, int K)
	{
		double[][] dp = new double[landings.length][K+1];

		// i represent the position to start and j represent the number of steps
		int N = landings.length;

		for(int i=0;i<N;i++)
			for(int j=0;j<=K;j++)
				dp[i][j] = -1;

		for(int i=0;i<N;i++)
			if(landings[i].charAt(i) == 'E'){
				dp[i][0] = 1.0;
				for(int j=1;j<=K;j++)
					dp[i][j]=0;
			}
			else if(landings[i].charAt(i) == 'P'){
				for(int j=0;j<=K;j++)
					dp[i][j] = 0;
			}

		// apply the DP

		for(int i=0;i<N;i++)
			if(dp[i][0] == -1) dp[i][0] = 0;

		for(int k=1;k<=K;k++){

			for(int i=0;i<N;i++){

        if(dp[i][k] != -1) continue;

				int den = 0;
				double temp = 0.0;

				for(int l=0;l<N;l++){
					if(landings[i].charAt(l) == '1'){
						temp += dp[l][k-1];
						den++;
					}
				}
				System.out.println("den: "+den);
				if(den==0) dp[i][k]=0;
				else{
					temp /= den;
					dp[i][k]=temp;
				}
			}
		}

		// solve
		double den=0.0;
		for(int i=0;i<N;i++)
			den += dp[i][K];

		return dp[startLanding][K]/den;

	}
public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;

		time = System.currentTimeMillis();
		answer = new ParkAmusement().getProbability(new String[]{"E000", "1000", "1000", "1000"}, 1, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.3333333333333333D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ParkAmusement().getProbability(new String[]{"E000", "1000", "1001", "000P"}, 1, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.6666666666666666D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ParkAmusement().getProbability(new String[]{"01000100", "00111000", "00001010", "000E0000", "0000E000", "00000P00", "000000P0", "01000000"}, 1, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.14285714285714288D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ParkAmusement().getProbability(new String[]{"0100", "0010", "0001", "000E"}, 0, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.0D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ParkAmusement().getProbability(new String[]{"E00", "0E0", "010"}, 0, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.0D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
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
//Powered by [KawigiEdit] 2.0!
