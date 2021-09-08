package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 08/09/21
  Time: 9:47 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class LCS {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            String t = in.next();

            int sl = s.length();
            int tl = t.length();

            int dp[][] = new int[s.length() + 1][t.length() + 1];

            for (int i = 0; i <= sl; i++) {
                for (int j = 0; j <= tl; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            String ans = "";
            int i = sl, j = tl;
            while (i > 0 && j > 0) {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    ans = ans + s.charAt(i-1);
                    i--;
                    j--;
                }
                // Move in the greater value direction
                else if(dp[i-1][j]>dp[i][j-1])
                {
                    i--;
                }
                else{
                    j--;
                }

            }

            String ansRev = (new StringBuilder(ans)).reverse().toString();
            System.out.println(ansRev);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}