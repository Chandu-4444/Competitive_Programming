package luna.D2;
/*
  Author: Luna
  Date: 01/09/21
  Time: 4:36 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class CaisaPylons {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int h[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                h[i] = in.nextInt();
            }

            int ans = 0;
            int energy = 0;

            for (int i = 0; i < n; i++) {
                energy += h[i] - h[i + 1];
                if (energy < 0) {
                    ans += Math.abs(energy);
                    energy = 0;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}