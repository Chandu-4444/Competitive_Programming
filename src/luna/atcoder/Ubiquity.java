package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc178/tasks/abc178_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 6:24 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Ubiquity {
    static int MOD = (int) 1e9 + 7;
    public static void main(String args[]) throws IOException {

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            // Inclusion-exclusion principle
            // Total possible ways of selecting all 10 numbers = 10^n
            // Total possible ways of not selecting 0 = 9^n
            // Total possible ways of not selecting 1 = 9^n
            // Total possible ways such that there is no 1 or 0, but not both = 9^n + 9^n - 8^n(subtracting the ways in which there is no both 0 and 1)
            // ans = 10^n - 9^n - 9^n + 8^n

            long ans = powMod(10, n)%MOD;

            ans = (ans - powMod(9, n))%MOD;
            ans = (ans - powMod(9, n))%MOD;
            ans = (ans + powMod(8, n))%MOD;

//            long ans = (((powMod(10, n) - powMod(9, n))%MOD - powMod(9, n))%MOD + powMod(8, n))%MOD;

//            ans = ans%MOD;
            ans = (ans + MOD)%MOD;
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    static long powMod(long x, long y)
    {
        long res = 1;
        for(long i=0;i<y;i++)
        {
            res = res*x%MOD;
        }
        return res;
    }
}