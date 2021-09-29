package luna.d2;
/*
  Author: Luna
  Date: 01/09/21
  Time: 5:25 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class SumDigits {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.next();

            int ans = 0;

            while (s.length() > 1) {
                int temp = 0;
                for (int i = 0; i < s.length(); i++) {
                    temp += s.charAt(i) - '0';
                }
//                System.out.println(temp);

                s = Integer.toString(temp);
                ans++;
            }
            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}