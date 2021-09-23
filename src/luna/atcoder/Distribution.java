package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc214/tasks/abc214_c
/*
  Author: Luna
  Date: 17/09/21
  Time: 10:03 AM
 */

import java.util.*;
import java.io.IOException;

public class Distribution {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int s[] = new int[n];
            int t[] = new int[n];
            for(int i=0;i<n;i++)
            {
                s[i] = in.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                t[i] = in.nextInt();
            }

            int ans[] = new int[n];
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[0] = t[0];

            for(int i=1;i<n;i++)
            {

                ans[i] = Math.min(t[i], s[i-1]+ans[i-1]);
            }

            ans[0] = Math.min(t[0], s[n-1]+ans[n-1]);
            for(int i=1;i<n;i++)
            {

                ans[i] = Math.min(t[i], s[i-1]+ans[i-1]);
            }



            for (int i = 0; i < n; i++) {
                System.out.println(ans[i]);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}