package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc070/tasks/abc070_c
/*
  Author: Luna
  Date: 15/09/21
  Time: 2:41 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class MultipleClocks {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long t[] = new long[n];
            for (int i = 0; i < n; i++) {
                t[i] = in.nextLong();
            }
            long ans = 1;

            for (int i = 0; i < n; i++) {
                ans = lcm(ans, t[i]);
//                System.out.println(ans);
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static long lcm(long a, long b) {
        long g = gcd(a, b);
//        System.out.println(g);
        return a/g *b;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }

}