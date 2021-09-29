package luna.d2;

// Problem Link: https://codeforces.com/contest/1551/problem/A
/*
  Author: Luna
  Date: 24/09/21
  Time: 8:27 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class PolycarpCoins {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            while (t-- > 0) {
                int n = in.nextInt();
                if (n % 3 == 0) {
                    System.out.println((n / 3) + " " + (n / 3));
                    continue;

                }
                // if(c1>c2)
                int c2 = (n - 1) / 3;
                int c1 = c2 + 1;
                // if(c2>c1)

                int c11 = (n - 2) / 3;
                int c22 = 1 + c11;

                if (c2 * 2 + c1 == n) {
                    System.out.println(c1 + " " + c2);
                } else {
                    System.out.println(c11 + " " + c22);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}