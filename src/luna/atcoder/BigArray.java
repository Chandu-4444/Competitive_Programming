package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc061/tasks/abc061_c
/*
  Author: Luna
  Date: 14/09/21
  Time: 11:17 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class BigArray {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            long K = in.nextLong();
            long count[] = new long[100000+1];

            for (int i = 0; i < N; i++) {
                int ai = in.nextInt();
                int bi = in.nextInt();
                count[ai] = count[ai] + bi;
            }

            long sum = 0;
            for (int i = 1; i <= 100000; i++) {
                sum = sum + count[i];
                if(K<=sum)
                {
                    System.out.println(i);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}