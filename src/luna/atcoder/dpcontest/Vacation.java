package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 07/09/21
  Time: 7:54 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Vacation {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int h[][] = new int[n][3];

            int dp[][] = new int[n][3];

            for(int i=0;i<n;i++)
            {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                h[i][0] = in.nextInt();
                h[i][1] = in.nextInt();
                h[i][2] = in.nextInt();
            }

            System.out.println(Math.max(choseA(h, dp, n-1), Math.max(choseB(h, dp, n-1), choseC(h, dp, n-1))));



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int choseA(int h[][], int dp[][], int n)
    {
        if(n==0)
        {
            return Math.max(h[0][1], h[0][2]);
        }
        if(dp[n][0]!=Integer.MAX_VALUE)
        {
            return dp[n][0];
        }
        else
        {
            dp[n][0] =  Math.max(choseB(h, dp, n-1), choseC(h, dp, n-1))+h[n][0];
            return dp[n][0];
        }
    }
    public static int choseB(int h[][], int dp[][], int n)
    {
        if(n==0)
        {
            return Math.max(h[0][0], h[0][2]);
        }
        if(dp[n][1]!=Integer.MAX_VALUE)
        {
            return dp[n][1];
        }
        else
        {
            dp[n][1] =  Math.max(choseA(h, dp, n-1), choseC(h, dp, n-1))+h[n][1];
            return dp[n][1];
        }
    }
    public static int choseC(int h[][], int dp[][], int n)
    {
        if(n==0)
        {
            return Math.max(h[0][0], h[0][1]);
        }
        if(dp[n][2]!=Integer.MAX_VALUE)
        {
            return dp[n][2];
        }
        else
        {
            dp[n][2] =  Math.max(choseA(h, dp, n-1), choseB(h, dp, n-1))+h[n][2];
            return dp[n][2];
        }
    }
 }