package luna.atcoder;
/*
  Author: Luna
  Date: 04/09/21
  Time: 11:55 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class BackAndForth {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);

            printString(dy, 'U');
            printString(dx, 'R');

            printString(dy, 'D');
            printString(dx, 'L');

            System.out.print("L");
            printString(dy + 1, 'U');
            printString(dx + 1, 'R');
            System.out.print("D");

            System.out.print("R");
            printString(dy+1, 'D');
            printString(dx+1, 'L');
            System.out.print("U");
            System.out.println();



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void printString(int len, char c) {
        for (int i = 0; i < len; i++) {
            System.out.print(c);
        }
    }
}