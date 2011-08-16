import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MagicalGirlLevelThreeDivTwo
{
  void printArray(int[] arr){

    for(int i=0;i<arr.length;i++)
      System.out.print(arr[i]);
    System.out.println();

  }

char theDigit(String[] first, long[] M, int i, long p)
    {
    	int K = first.length;
        if (i < K ) {
            //simple
            return (first[i].charAt((int)p) );
        } else {

            long before = 0;
            int j = i-1;
            while (p >= before + M[j]) {
                before += M[j];
                j-=K;
            }
            return theDigit(first, M, j, p - before);
        }
    }

  public int theCount(String[] first, int n, long lo, long hi){

    long[] M = new long[n+1];
    int k = first.length;
    // precalculate M
    for(int i=0;i<=n;i++)
      if(i<k)
        M[i] = first[i].length();
      else{

        int j=i-1, m = 0;
        long count = 0;
        while(j-m*k >= 0){
          count += M[j-m*k];
          m++;
        }
        M[i] = count;
      }

    // find the solution
    int weight = 0;
    for(long i = lo;i<=hi;i++){
      char c = theDigit(first, M, n, i);
      if(c == '1') weight++;
      System.out.print(c);
    }

    return weight;
  }
}
//Powered by [KawigiEdit] 2.0!
