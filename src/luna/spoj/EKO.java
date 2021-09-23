 package luna.spoj;

// Problem Link: https://www.spoj.com/problems/EKO/
/*
  Author: Luna
  Date: 22/09/21
  Time: 7:08 PM
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EKO {
    public static void main(String args[]) throws IOException {
        try {
            FastScanner in = new FastScanner();
            int n = in.nextInt();
            long m = in.nextInt();

            int arr[] = new int[n];
            long low = 0, high = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                high = Math.max(high, arr[i]);
            }

            long ans = -1;
            while (low <= high) {
                long mid = low + (high - low) / 2;
//                System.out.println(mid);

                long count = 0;

                for (int i = 0; i < n; i++) {
                    long diff = arr[i] - mid;

                    count = count + ((diff > 0) ? diff : 0);
                }

                if (count == m) {
                    high = mid;
                    break;
                }

                if (count < m) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(high);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(int[] arr, long m, long mid) {
        long woodCollected = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                woodCollected += (arr[i] - mid);
            }
        }

        return woodCollected >= m;
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