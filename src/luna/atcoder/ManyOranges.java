package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc195/tasks/abc195_b
/*
  Author: Luna
  Date: 27/09/21
  Time: 4:57 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class ManyOranges {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            w = w * 1000;

            int max = w / a;
            int min = -1;

            if (w % a > max * (b - a)) {
                System.out.println("UNSATISFIABLE");
                return;
            } else {
                min = (w % b == 0) ? (w / b) : (w / b + 1);
            }
            System.out.println(min + " " + max);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}