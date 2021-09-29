package luna.d2;
/*
  Author: Luna
  Date: 28/08/21
  Time: 3:35 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BurglarMatches {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            int arr[][] = new int[m][2];

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();

                arr[i][0] = a;
                arr[i][1] = b;
            }

            Arrays.sort(arr, (int a1[], int a2[]) -> a2[1] - a1[1]);

            int ans = 0;

            for (int i = 0; i < m && n > 0; i++) {
                if (n >= arr[i][0]) {
                    ans += arr[i][0] * arr[i][1];
                    n = n - arr[i][0];
                } else {
                    ans += n * arr[i][1];
                    n = 0;
                }
//                System.out.println("n = "+n+" Ans = "+ans);
            }
            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}