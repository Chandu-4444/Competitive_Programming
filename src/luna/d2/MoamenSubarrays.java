package luna.d2;

// Problem Link: https://codeforces.com/problemset/problem/1557/B
/*
  Author: Luna
  Date: 25/09/21
  Time: 11:39 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MoamenSubarrays {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();

                int a[] = new int[n];

                HashMap<Integer, Integer> map = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                    map.put(a[i], i);
                }
                Arrays.sort(a);

                int ans = 1;

                for (int i = 1; i < n; i++) {
                    if (map.get(a[i - 1]) + 1 != map.get(a[i])) {
                        ans++;
                    }

                }
//                System.out.println(ans);
                if (ans <= k) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}