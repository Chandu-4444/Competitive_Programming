package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc212/tasks/abc212_c
/*
  Author: Luna
  Date: 17/09/21
  Time: 12:12 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinDiff {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            int a[] = new int[n];
            int b[] = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int lb = lowerBound(b, a[i]);
                if (lb == -1) {
                    continue;
                }
                min = Math.min(min, Math.abs(a[i] - b[lb]));
            }

            for (int i = 0; i < n; i++) {
                int ub = upperBound(b, a[i]);
                if (ub == -1) {
                    continue;
                }
                min = Math.min(min, Math.abs(a[i] - b[ub]));
            }
            System.out.println(min);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int upperBound(int arr[], int element) {
        int low = 0, high = arr.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        if (arr[low] >= element) {
            return low;
        }
        if (arr[high] >= element) {
            return high;
        }
        return -1;
    }

    public static int lowerBound(int arr[], int element) {
        int low = 0, high = arr.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (element < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        if (arr[high] <= element) {
            return high;
        }
        if (arr[low] <= element) {
            return low;
        }
        return -1;
    }


}