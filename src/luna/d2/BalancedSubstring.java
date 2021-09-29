package luna.d2;
/*
  Author: Luna
  Date: 08/09/21
  Time: 8:06 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class BalancedSubstring {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                String s = in.next();

                int a = 0, b = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == 'a') {
                        a++;
                    } else {
                        b++;
                    }
                }

                if (a == b) {
                    System.out.println("1 " + n);
                } else if (s.length() == 1 || a == 0 || b == 0) {
                    System.out.println("-1 -1");
                } else {
                    for (int i = 0; i < n - 1; i++) {
                        if (s.charAt(i) != s.charAt(i + 1)) {
                            System.out.println((i + 1) + " " + (i + 2));
                            break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}