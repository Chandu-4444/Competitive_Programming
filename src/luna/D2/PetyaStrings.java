package luna.D2;
/*
  Author: Luna
  Date: 28/08/21
  Time: 1:06 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class PetyaStrings {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s1 = in.next();
            String s2 = in.next();

            int value = s1.compareToIgnoreCase(s2);

            if (value == 0) {
                System.out.println(0);
            } else if (value > 0) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }

        } catch (Exception e) {
            System.out.print(e);
            return;
        }
    }
}