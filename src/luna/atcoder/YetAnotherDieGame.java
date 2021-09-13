package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc053/tasks/arc068_a
/*
  Author: Luna
  Date: 13/09/21
  Time: 8:14 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class YetAnotherDieGame {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            long x = in.nextLong();
            long ans = 0;
            long tmp = x % 11;
            ans = x / 11;
            ans = ans * 2; // Optimal solution is to roll 6,5 alternatively

            if (tmp != 0) {
                if (tmp <= 6) {
                    ans = ans + 1;
                } else {
                    ans = ans + 2;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}