package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc201/tasks/abc201_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 9:27 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class SecretNumber {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            long ans = 0;
            for (int i = 0; i <= 9999; i++) {

                // Appending leading zeroes
                String num = Integer.toString(i);
                while (num.length() < 4) {
                    num = "0" + num;
                }
//                String num = String.format("%04d", i);


                boolean flag = true;
                for (int j = 0; j < 10; j++) {
                    // No need to care about '?' as this they can be anything.
                    if(s.charAt(j)=='o' && !num.contains(Integer.toString(j)))
                    {
                        flag = false;
                        break;
                    }
                    else if(s.charAt(j)=='x' && num.contains(Integer.toString(j)))
                    {
                        flag = false;
                        break;
                    }
                }

                if(flag)
                {
                    ans++;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}