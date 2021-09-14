package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc057/tasks/abc057_c
/*
  Author: Luna
  Date: 14/09/21
  Time: 10:24 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class DigitsMultiplication {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            long n = in.nextLong();

            int ans = Integer.MAX_VALUE;

            for (int i = 1; i <= Math.sqrt(n); i++) {
                long a = i;
                long b = 0;
                if(n%a==0)
                {
                    b = n / a;
                    ans = Math.min(ans, Math.max((Long.toString(a)).length(), (Long.toString(b)).length()));
                }



            }
            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}