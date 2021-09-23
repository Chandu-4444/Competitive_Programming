package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc080/tasks/abc080_b
/*
  Author: Luna
  Date: 15/09/21
  Time: 10:06 PM
 */

import java.util.*;
import java.io.IOException;

public class HarshadNumber {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int copy = n;
            int sum = 0;
            while(copy>0)
            {
                int rem = copy%10;
                copy = copy/10;
                sum += rem;
            }

            System.out.println((n%sum)==0?"Yes":"No");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}