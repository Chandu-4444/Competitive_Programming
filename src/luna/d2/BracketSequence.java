package luna.d2;

// Problem Link: https://codeforces.com/contest/1574/problem/A
/*
  Author: Luna
  Date: 20/09/21
  Time: 8:11 PM
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BracketSequence {
    public static void main(String args[]) throws IOException {
        try {
            FastScanner in = new FastScanner();
            int n = in.nextInt();
            long arr[] = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                sum += arr[i];
            }
//            Arrays.sort(arr);
            arr = Arrays.stream(arr).boxed().sorted().mapToLong($ -> $).toArray();

            int m = in.nextInt();
            while (m-- > 0) {
                long x = in.nextLong();
                long y = in.nextLong();
                long ans1 = 0, ans2 = 0;
                if (x <= arr[0]) {
                    ans1 = Math.max((y - (sum - arr[0])), 0);
                } else if (arr[n - 1] <= x) {
                    ans1 = x - arr[n - 1] + Math.max(y - (sum - arr[n - 1]), 0);
                } else {
//                    arr[0] < x < arr[n-1]

//                    int low = 0, high = arr.length - 1;
//                    int pos1 = -1, pos2 = -1;
//
//                    while (high - low > 1) {
//                        int mid = (high + low) / 2;
//                        if(x<=arr[mid])
//                        {
//                            high = mid;
//                        }
//                        else
//                        {
//                            low = mid;
//                        }
//                    }
//                    pos1 = high;
                    int pos1 = Arrays.binarySearch(arr, x);
                    if (pos1 < 0) {
                        pos1 = pos1 + 1;
                        pos1 = pos1 * (-1);
                    }
                    ans1 = Math.min(Math.max(y - (sum - arr[pos1]), 0), x - arr[pos1 - 1] + Math.max(y - (sum - arr[pos1 - 1]), 0));
                }
                System.out.println(ans1);

            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


    public static int upperBound(long arr[], long element) {
        if (element > arr[arr.length - 1]) {
            return -1;
        }
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

    public static int lowerBound(long arr[], long element) {
        if (element < arr[0]) {
            return -1;
        }
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

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}