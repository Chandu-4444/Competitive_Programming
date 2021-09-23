package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc071/tasks/arc081_a
/*
  Author: Luna
  Date: 15/09/21
  Time: 3:27 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MakeRectangle {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            long s1 = 0, s2 = 0;
            Arrays.sort(a);

            for (int i = n - 1; i > 0; i--) {
                if (a[i] == a[i - 1] && s1 == 0) {
                    s1 = a[i];
                    i--;
                } else if (a[i] == a[i - 1] && s1 != 0 && s2 == 0) {
                    s2 = a[i];
                    i--;
                    break;
                }
            }

            System.out.println(s1*s2);




        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}