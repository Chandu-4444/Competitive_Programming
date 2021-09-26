package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc220/tasks/abc220_b
/*
  Author: Luna
  Date: 26/09/21
  Time: 5:33 PM
 */

import java.util.*;
import java.io.IOException;

public class BaseK {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();

            long a = in.nextLong(k);
            long b = in.nextLong(k);

            long ans = a*b;

            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}