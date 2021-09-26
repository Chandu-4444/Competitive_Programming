package luna.D2;

// Problem Link: https://codeforces.com/gym/101628/problem/J
/*
  Author: Luna
  Date: 24/09/21
  Time: 4:38 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class JennyBatteries {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long k = in.nextLong();
            int a[] = new int[n];
            int b[] = new int[n];
            int c[] = new int[n];
            long low = 0, high = 0;

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                c[i] = in.nextInt();
                high += a[i];
            }

            // Binary search on answer: Check if it's possible to get mid number of batteries charged with k cost

            while (high - low > 1) {
                long mid = low + (high - low) / 2;
                if (possible(a, b, c, mid, k)) {
                    high = mid;
                } else {
                    low = mid;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(int[] a, int[] b, int[] c, long mid, long k) {
        // Need to complete
        // TODO: Complete JennyBatteries Predicate function

        return true;
    }
}