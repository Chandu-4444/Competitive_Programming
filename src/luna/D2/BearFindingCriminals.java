package luna.D2;
/*
  Author: Luna
  Date: 28/08/21
  Time: 3:22 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class BearFindingCriminals {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a = in.nextInt();
            a = a - 1;

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int ans = arr[a] == 1 ? 1 : 0;
            int left = a - 1;
            int right = a + 1;
//            System.out.println("Initial Ans "+ans);

            while (left >= 0 && right < n) {
                if (arr[left] == arr[right] && arr[left] == 1) {
                    ans += 2;
                }
//                System.out.println("At "+left+" "+right+" Ans = "+ans);
                left--;
                right++;
            }

            while (left >= 0) {
                ans += arr[left] == 1 ? 1 : 0;
//                System.out.println("At "+left+" "+right+" Ans = "+ans);

                left--;
            }
            while (right < n) {
                ans += arr[right] == 1 ? 1 : 0;
//                System.out.println("At "+left+" "+right+" Ans = "+ans);

                right++;
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}