package luna.atcoder;
// Problem Link: https://atcoder.jp/contests/abc050/tasks/arc066_a


/*
  Author: Luna
  Date: 03/09/21
  Time: 1:25 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LiningUp {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int MOD = (int)1e9 + 7;
            int n = in.nextInt();
            int a[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }

            int mapping[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                mapping[i] = Math.abs(Math.abs(i - 1) - Math.abs(n - i));
            }

            Arrays.sort(mapping);
            Arrays.sort(a);

            for(int i=1;i<=n;i++)
            {
                if(a[i]!=mapping[i])
                {
                    System.out.println(0);
                    return;
                }
            }

            // Solving
            int powerOfTwo = n/2;
            int ans = 1;

            for(int i=1;i<=powerOfTwo;i++)
            {
                ans = ans%MOD;
                ans = ((ans%MOD)*(2%MOD))%MOD;
            }

            System.out.println(ans);


//            for (int i = 1; i <= n; i++) {
//                System.out.println(i + " " + mapping[i] + " ");
//            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}