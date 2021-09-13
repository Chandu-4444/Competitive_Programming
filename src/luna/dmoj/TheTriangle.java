package luna.dmoj;

// Problem Link: https://dmoj.ca/problem/ioi94p1
/*
  Author: Luna
  Date: 13/09/21
  Time: 12:57 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheTriangle {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            ArrayList<Integer>[] triangle = new ArrayList[n];

            for(int i=0;i<n;i++)
            {
                triangle[i] = new ArrayList<>();
            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<=i;j++)
                {
                    triangle[i].add(in.nextInt());
                }
            }

            int dp[][] = new int[n+1][n+1];
            int ans = Integer.MIN_VALUE;

            for(int i=1;i<=n;i++)
            {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
                for(int j=1;j<=triangle[i-1].size();j++)
                {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i-1].get(j-1);
                    if(i==n)
                    {
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }

//            for (int i = 0; i <= n; i++) {
//                for(int j=0;j<=n;j++)
//                {
//                    System.out.printf("%10d",dp[i][j]);
//                }
//                System.out.println();
//            }
            System.out.println(ans);



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}