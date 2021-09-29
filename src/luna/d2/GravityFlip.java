package luna.d2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            for (int i : a) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.out.print(e);
            return;
        }
    }
}