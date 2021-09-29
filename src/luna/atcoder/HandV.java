package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc173/tasks/abc173_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 8:23 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class HandV {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int h = in.nextInt();
            int w = in.nextInt();
            int k = in.nextInt();

            char grid[][] = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = in.next();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }


            int ans = 0;
            // This is like, selecting/not selecting 0th row, 1st row, 2nd row,....,Hth row etc;
            // Map this to binary numbers 2^H (0000=> not painting all rows, 0011=> painting 0th and 1st row etc)
            // similarly for columns

            for (int maskR = 0; maskR < 1 << h; maskR++) {
                for (int maskC = 0; maskC < 1 << w; maskC++) {
                    int count = 0;

                    for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                            // If the current row, column is not selected to paint
                            if ((maskR >> i & 1) == 0 && (maskC >> j & 1) == 0 && grid[i][j] == '#') {
                                count++;
                            }
                        }
                    }
                    if (count == k) {
                        ans++;
                    }
                }

            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}