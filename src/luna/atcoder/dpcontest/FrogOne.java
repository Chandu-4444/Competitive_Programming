package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 07/09/21
  Time: 9:48 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class FrogOne {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int h[] = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }

            int dp[] = new int[n + 1];

            if (n == 2) {
                System.out.println(Math.abs(h[0] - h[1]));
            }


            dp[1] = Math.abs(h[1] - h[0]);
            dp[2] = Math.abs(h[2] - h[0]);

            for (int i = 2; i < n; i++) {
                dp[i] = Math.min(Math.abs(h[i] - h[i - 1]) + dp[i - 1], Math.abs(h[i] - h[i - 2]) + dp[i - 2]);
            }

            System.out.println(dp[n - 1]);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

}