package luna.d2;

import java.io.IOException;
import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int row = -1, column = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int value = in.nextInt();
                    if (value == 1) {
                        row = i;
                        column = j;
                    }
                }
            }
            System.out.println(Math.abs(row - 2) + Math.abs(column - 2));

        } catch (Exception e) {
            System.out.print(e);
            return;
        }

    }
}