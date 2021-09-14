package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc065/tasks/arc076_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 4:48 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Reconciled {
    static int MOD = (int)1e9 + 7;
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            if (Math.abs(n - m) > 1) {
                System.out.println(0);
                return;
            }

            int factn = fact(n);
            int factm = fact(m);

            int ans = mulmod(factn, factm, MOD);
            if(n==m)
            {
                System.out.println((ans*2)%MOD);
            }
            else{
                System.out.println(ans);
            }





        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int fact(int n)
    {
        int ans = 1;
        for(int i=1;i<=n;i++)
        {
            ans = mulmod(ans, i, MOD);
        }
        return ans;
    }
    public static int mulmod(int a, int b, int mod) {
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