package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 07/09/21
  Time: 8:25 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class KnapsackTwo {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int W = in.nextInt();

            int w[] = new int[n];
            int v[] = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            long dp[] = new long[W];

//            for (int i = 0; i < n; i++) {
//                for (int j = W; j >= w[i]; j--) {
//                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
//                }
//            }

            System.out.println(dp[W]);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static long solution(int N, int W, int w[], int v[], long dp[][]) {
        if (N == -1 || W <= 0) {
            return 0;
        }
        if (dp[N][W] != -1) {
            return dp[N][W];
        } else if (W >= w[N]) {
            dp[N][W] = Math.max(solution(N - 1, W - w[N], w, v, dp) + v[N], solution(N - 1, W, w, v, dp));
            return dp[N][W];
        } else {
            dp[N][W] = solution(N - 1, W, w, v, dp);
            return dp[N][W];
        }

    }
}