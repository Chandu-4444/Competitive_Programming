package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc198/tasks/abc198_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 12:03 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class CompassWalking {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            double r = in.nextDouble();
            long x = in.nextLong();
            long y = in.nextLong();
            
            double dist = Math.sqrt(x * x + y * y);
            if (dist < r) {
                System.out.println(2);
            } else {
                System.out.println((long) Math.ceil(dist / r));
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}