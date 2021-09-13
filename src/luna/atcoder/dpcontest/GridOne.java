package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 08/09/21
  Time: 3:52 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class GridOne {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int h = in.nextInt();
            int w = in.nextInt();

            char grid[][] = new char[h][w];

            for (int i = 0; i < h; i++) {
                    String line = in.next();
                    grid[i] = line.toCharArray();

            }

            int dp[][] = new int[h + 1][w + 1];

            for (int i = 0; i < w; i++) {
                if (grid[0][i] == '#') {
                    break;
                }
                dp[0][i] = 1;
            }

            for (int i = 0; i < h; i++) {
                if (grid[i][0] == '#') {
                    break;
                }
                dp[i][0] = 1;
            }



            int MOD = (int) 1e9 + 7;
            for (int i = 1; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    if(grid[i][j]!='#')
                        dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD)%MOD;
                }
            }
//            for(int i=0;i<h;i++)
//            {
//                for(int j=0;j<w;j++)
//                {
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }


            System.out.println(dp[h - 1][w - 1]);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}