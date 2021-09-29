package luna.d2;

import java.io.IOException;
import java.util.Scanner;

public class VanyaFence {
    public static void main(String[] args) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int h = in.nextInt();
            int ans = 0;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > h) {
                    ans += 2;
                } else {
                    ans += 1;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }

    }
}