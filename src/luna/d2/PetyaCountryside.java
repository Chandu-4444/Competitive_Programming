package luna.d2;
/*
  Author: Luna
  Date: 28/08/21
  Time: 2:58 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class PetyaCountryside {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int h[] = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }

            int ans = 0;

            // Edge Cases
            if (n <= 2) {
                System.out.println(n);
                return;
            }
            for (int i = 0; i < n; i++) {
                int curr = h[i];
                int temp = 1;

                int currLeft = h[i];
                int currRight = h[i];
//                System.out.println("At "+curr);
//                 Check left side answer
//                System.out.println("Left: ");
                for (int left = i - 1; left >= 0; left--) {
                    if (h[left] <= currLeft) {
//                        System.out.print(h[left]+" ");
                        temp++;
                        currLeft = h[left];
                    } else {
                        break;
                    }
                }
//                System.out.println("\nRight: ");
//                Check right side answer
                for (int right = i + 1; right < n; right++) {
                    if (currRight >= h[right]) {
//                        System.out.println(h[right]+" ");
                        temp++;
                        currRight = h[right];
                    } else {
                        break;
                    }
                }

                ans = Math.max(ans, temp);
//                System.out.println("Current Answer "+ans);
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}