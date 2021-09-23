package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc077/tasks/arc084_a
/*
  Author: Luna
  Date: 16/09/21
  Time: 11:44 AM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SnukeFestival {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int c[] = new int[n];


            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);
            Arrays.sort(c);

            long ans[] = new long[n];

            for (int i = 0; i < n; i++) {
                int index = binarySearch(c, b[i]);

                if (index == n) {
                    break;
                }
                ans[i] = (n - index);
            }

            long currAns = 0;

            for (int i = n-1; i>0; i--) {
//                if (ans[i] == 0) {
//                    break;
//                }
                ans[i-1] += ans[i];
//                currAns = ans[i];
            }
//            System.out.println("Curr Ans: "+currAns);

//            for (int i=0;i<n;i++)
//            {
//                System.out.print(ans[i]+" ");
//            }
//            System.out.println();
            long dup[] = new long[n];


            for (int i = 0; i < n; i++) {
                int index = binarySearch(b, a[i]);

                if (index == n) {
                    Arrays.fill(dup, i, n, 0);
                    break;
                }
                dup[i] = ans[index];

//                System.out.println("Found "+index+": "+dup[i]);
            }

//            System.out.println();
            for (int i = 0; i < n; i++) {
//                System.out.print(dup[i]+" ");
                currAns += dup[i];
            }
//            System.out.println();
            System.out.println(currAns);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int binarySearch(int arr[], int element) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] <= element) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        if (low < arr.length && arr[low] <= element) {
            low++;
        }
        return low;
    }
}