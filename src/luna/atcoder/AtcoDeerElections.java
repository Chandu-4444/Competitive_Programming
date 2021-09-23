package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/arc062/tasks/arc062_a
/*
  Author: Luna
  Date: 15/09/21
  Time: 10:45 PM
 */

import java.util.*;
import java.io.IOException;

public class AtcoDeerElections {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long num1 = -1, num2 = -1;
            for(int i=0;i<n;i++)
            {
                int t = in.nextInt();
                int a = in.nextInt();

                if(i==0)
                {
                    num1 = t;
                    num2 = a;
                    continue;
                }

                if(t>=num1 && a>=num2)
                {
                    num1 = t;
                    num2 = a;
                    continue;
                }
                else
                {
                    long multiple = (long)Math.max(num1%t==0?(num1/t):(num1/t)+1, num2%a==0?(num2/a):(num2/a)+1);
                    num1 = t*multiple;
                    num2 = a*multiple;
                }
            }
            System.out.println((num1+num2));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}