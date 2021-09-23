package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc211/tasks/abc211_c
/*
  Author: Luna
  Date: 17/09/21
  Time: 5:58 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Chokudai {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            int MOD = (int)1e9 + 7;

            int dp[][] = new int[s.length() + 1][8 + 1];
            String req = "chokudai";

            for (int i = 0; i < s.length(); i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= 8; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= req.length(); j++) {
                    if (s.charAt(i - 1) == req.charAt(j - 1)) {
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[s.length()][8]);

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