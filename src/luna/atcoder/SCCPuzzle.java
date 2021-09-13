 package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc055/tasks/arc069_a
/*
  Author: Luna
  Date: 13/09/21
  Time: 9:38 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class SCCPuzzle {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            long ns = in.nextLong();
            long nc = in.nextLong();

            // If S is more, then ans would be number of nc
            if (ns >= nc/2) {
                System.out.println(nc/2);
                return;
            }
            // total number of nc/2 is greater than ns
            long ans = ns; // We can form atleast ns pairs of scc

            nc = nc - ns * 2; // remaining c's after pairing with ns s's
            ans = ans + nc / 4; // pairs we can form with remaining c's

            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}