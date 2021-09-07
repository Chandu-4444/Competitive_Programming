package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 07/09/21
  Time: 10:47 AM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FrogTwo {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();

            int h[] = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }

            int dp[] = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE-100000);


//             3 1
//             10 20 10
//             k = 1
//             for(int i=1;i<=1;i++)
//             {
//                 dp[i] = Math.abs(h[1] - h[0]);
//             }
//            dp[0] = Integer.MAX_VALUE - 100000;
//            dp[1] = Math.abs(h[1] - h[0]);

            if(k>=n)
            {
                System.out.println(Math.abs(h[0] - h[n-1]));
                return;
            }

            for (int i = 1; i <= k; i++) {
                dp[i] = Math.abs(h[i] - h[0]);
            }



            for (int i = k+1; i < n; i++) {
                for(int j=1;j<=k;j++)
                {
                    dp[i] = Math.min(dp[i], Math.abs(h[i]-h[i-j])+dp[i-j]);
                }

            }

            System.out.println(dp[n-1]);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}