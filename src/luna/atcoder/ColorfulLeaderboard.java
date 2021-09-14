package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc064/tasks/abc064_c
/*
  Author: Luna
  Date: 14/09/21
  Time: 4:24 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class ColorfulLeaderboard {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            int colors[] = new int[8];
            int newColors = 0;

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();

                if (a[i] >= 1 && a[i] <= 399) {
                    colors[0] = 1;
                }
                if (a[i] >= 400 && a[i] <= 799) {
                    colors[1] = 1;
                }
                if (a[i] >= 800 && a[i] <= 1199) {
                    colors[2] = 1;

                }
                if (a[i] >= 1200 && a[i] <= 1599) {
                    colors[3] = 1;
                }
                if (a[i] >= 1600 && a[i] <= 1999) {
                    colors[4] = 1;
                }
                if (a[i] >= 2000 && a[i] <= 2399) {
                    colors[5] = 1;
                }
                if (a[i] >= 2400 && a[i] <= 2799) {
                    colors[6] = 1;
                }
                if (a[i] >= 2800 && a[i] <= 3199) {
                    colors[7] = 1;
                }
                if (a[i] >= 3200) {
                    newColors++;
                }

            }
             int minColors = 0;
            for(int i: colors)
            {
                minColors = minColors + i;
            }



            System.out.println((minColors==0?1:minColors)+" "+(minColors+newColors));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}