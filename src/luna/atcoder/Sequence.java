package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc059/tasks/arc072_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 2:49 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Sequence {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }



            long sum2 = 0;
            long ans2 = 0;

            // Case 2: We'll find the answer when we have all even places with sum>=0, and odd places have sum<0
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    // Odd place
                    if (sum2 + a[i] > 0) {
                        sum2 = sum2 + a[i];
                    } else {
                        // The sum is < 0, we'll increase it to 1
                        // We need to increase the sum1 to 1 (Minimum positive number), so this step calculates the total steps to achieve this
                        ans2 = ans2 - (sum2 + a[i]) + 1;
                        sum2 = 1;
                    }
                } else {
                    if (sum2 + a[i] < 0) {
                        sum2 = sum2 + a[i];
                    } else {
                        // The sum1 is > 0, we'll decrease it to -1
                        // We need to decrease the sum1 to -1 (Minimum negative number), so this step calculates the total steps to achieve this
                        ans2 = ans2 + (sum2 + a[i]) + 1;
                        sum2 = -1;
                    }
                }
            }

            long sum1 = 0;
            long ans1 = 0;

            // Case 1: We'll find the answer when we have all odd places with sum>=0, and even places have sum<0
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    // Odd place
                    if (sum1 + a[i] > 0) {
                        sum1 = sum1 + a[i];
                    } else {
                        // We need to increase the sum1 to 1 (Minimum positive number)
                        ans1 = ans1 - (sum1 + a[i]) + 1;
                        sum1 = 1;
                    }
                } else {
                    if (sum1 + a[i] < 0) {
                        sum1 = sum1 + a[i];
                    } else {
                        ans1 = ans1 + (sum1 + a[i]) + 1;
                        sum1 = -1;
                    }
                }
            }

            System.out.println(Math.min(ans1, ans2));


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}