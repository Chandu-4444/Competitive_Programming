package luna.spoj;

// Problem Link: https://www.spoj.com/problems/AGGRCOW/
/*
  Author: Luna
  Date: 21/09/21
  Time: 4:40 PM
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AggressiveCows {
    public static void main(String args[]) throws IOException {
        try {
            FastScanner in = new FastScanner();
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int c = in.nextInt();
                long x[] = new long[n];
                for (int i = 0; i < n; i++) {
                    x[i] = in.nextInt();
                }
                Arrays.sort(x);

                // Binary search on answer!

                long low = 0, high = (int)1e9;
                long ans = 0;

                while (high- low > 1) {
                    long middle = low + (high - low) / 2;

                    if (possible(x, c, middle)) {
                        low = middle;
//                        ans = middle;
                    } else {
                        high = middle;
                    }
                }

                if(possible(x, c, low))
                {
                    System.out.println(low);
                }
                else{
                    System.out.println(high);
                }
//                System.out.println(ans);

            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static boolean possible(long x[], int c, long val) {
        int prevPos = 0;
        int cows = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i] - x[prevPos] >= val) {
                cows++;
                if (cows == c) {
                    return true;
                }
                prevPos = i;

            }
        }


        return false;

    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}