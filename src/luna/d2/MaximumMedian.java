package luna.d2;

// Problem Link: https://codeforces.com/contest/1201/problem/C
/*
  Author: Luna
  Date: 23/09/21
  Time: 10:52 AM
 */

import java.util.*;
import java.io.IOException;

public class MaximumMedian {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Arrays.sort(a);

            long low = a[n / 2];
            long high = a[n - 1] + k;

            while (high - low > 1) {
                long mid = low + (high - low) / 2;

                if (possible(a, k, mid)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            if (possible(a, k, high)) {
                System.out.println(high);
            } else {
                System.out.println(low);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(int[] a, int k, long mid) {
        long tot = 0;

        for (int i = a.length / 2; i < a.length; i++) {
            if (a[i] < mid) {
                tot += (mid - a[i]);
            }
        }

        return tot <= k;


    }
}