package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc066/tasks/arc077_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 5:04 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PushPush {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            // ans = [an, an-2, an-4, an-2, an-5, an-3, an-1] (n = 6)

            int ans[] = new int[n];

            int index = 0;
            for(int i=n-1;i>=0;i = i-2)
            {
                ans[index++] = a[i];
            }

            for(int i=n%2;i<n;i = i+2)
            {
                ans[index++] = a[i];
            }

            for(int i:ans)
            {
                System.out.print(i+" ");
            }
            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}