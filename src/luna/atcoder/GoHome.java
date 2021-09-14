package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc056/tasks/arc070_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 9:53 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class GoHome {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int sum = 0;

            for (int i = 1; i <= x; i++) {
                if(sum+i>=x)
                {
                    System.out.println(i);
                    return;
                }
                else{
                    sum+=i;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}