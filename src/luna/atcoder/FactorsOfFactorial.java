package luna.atcoder;
/*
  Author: Luna
  Date: 04/09/21
  Time: 12:30 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class FactorsOfFactorial {
    public static void main(String args[]) throws IOException {
//        long startTime = System.currentTimeMillis();
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            long factors[] = new long[n + 1];

            for (int i = n; i > 1; i--) {
//                System.out.println(i);
                int num = i;
                for (int d = 2; d <= num; d++) {
//                    System.out.println("d = "+d);
                    while (num % d == 0) {
                        factors[d]++;
                        num = num / d;
                    }
                }
            }

            int MOD = (int) 1e9 + 7;

            int ans = 1;

            for (int i = 1; i <= n; i++) {
                if (factors[i] != 0) {
                    factors[i] = (factors[i] % MOD + 1) % MOD;
                    ans = mulmod(ans, factors[i], MOD);
                }
            }
            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Execution Time: "+(endTime - startTime)+"ms");
    }

    static int mulmod(int a, long b,
                      int mod) {
        int res = 0; // Initialize result
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res + a) % mod;
            }

            // Multiply 'a' with 2
            a = (a * 2) % mod;

            // Divide b by 2
            b /= 2;
        }

        // Return result
        return res % mod;
    }
}