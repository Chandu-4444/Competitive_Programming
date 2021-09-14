package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc067/tasks/arc078_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 5:29 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class SplittingPile {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }

            long ans = Long.MAX_VALUE;
            long cumSum = 0;
            for (int i = 0; i < n; i++) {
                cumSum += a[i];
                if(i+1<n)
                    ans = Math.min(ans, Math.abs((sum - 2 * cumSum)));
            }

            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}