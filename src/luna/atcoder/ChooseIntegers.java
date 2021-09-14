package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc060/tasks/abc060_b
/*
  Author: Luna
  Date: 14/09/21
  Time: 12:00 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class ChooseIntegers {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int mod = c%b;

            boolean found = false;

            for(int i=1;i<=b;i++)
            {
                if((a*i)%b==mod)
                {
                    found = true;
                }
            }

            if(found)
            {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}