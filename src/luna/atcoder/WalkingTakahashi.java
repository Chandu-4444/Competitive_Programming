package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc175/tasks/abc175_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 7:53 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class WalkingTakahashi {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            long x = in.nextLong();
            long k = in.nextLong();
            long d = in.nextLong();

            x = Math.abs(x);

            // Calculate the steps to bring the x to nearest 0

            long reduce = Math.min(k, x/d);

            // Remaining steps to oscillate
            k = k - reduce;

            // Update the current x
            x = x - reduce*d;

            if(k%2==0)
            {
                System.out.println(x);
            }
            else{
                System.out.println(Math.abs(x - d));
            }



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}