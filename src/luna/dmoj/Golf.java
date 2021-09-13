package luna.dmoj;
/*
  Author: Luna
  Date: 13/09/21
  Time: 12:14 PM
 */
// https://dmoj.ca/problem/ccc00s4
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Golf {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int dist = in.nextInt();
            int n = in.nextInt();
            int clubs[] = new int[n];
            for (int i = 0; i < n; i++) {
                clubs[i] = in.nextInt();
            }

            int dp[] = new int[dist+1];
            Arrays.fill(dp, 10000);

            dp[0] = 0;

            for(int i=0;i<=dist;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i + clubs[j]<=dist)
                    {
                        dp[i+clubs[j]] = Math.min(dp[i+clubs[j]], dp[i]+1);
                    }
                }
            }

            if(dp[dist]!=10000)
            {
                System.out.println("Roberta wins in "+dp[dist]+" strokes.");
            }
            else
            {
                System.out.println("Roberta acknowledges defeat.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}