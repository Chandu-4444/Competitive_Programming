package luna;

// Problem Link: https://atcoder.jp/contests/abc220/tasks/abc220_c
/*
  Author: Luna
  Date: 26/09/21
  Time: 5:37 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class LongSequence {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            long a[] = new long[n];
            long prefixSum[] = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                sum = sum + a[i];
                prefixSum[i] = sum;
            }

            long x = in.nextLong();

            long quotient = x / sum;

            long ans = quotient * n;

            long rem = x - sum * quotient;

//            if (rem == 0) {
//                System.out.println(ans);
//                return;
//            }

            for(int i=0;i<n;i++)
            {
                if(prefixSum[i]>rem)
                {
                    ans = ans + i + 1;
                    break;
                }
            }

            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}