package luna.UVa;

// Problem Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=871&page=show_problem&problem=5088
/*
  Author: Luna
  Date: 24/09/21
  Time: 5:50 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class OrchestralScores {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            while (s.isEmpty()!=true)
            {
                int p = Integer.parseInt(s.split(" ")[0]);
                int n = Integer.parseInt(s.split(" ")[1]);
                int instruments[] = new int[n];

                int low = 1, high = -1;
                for (int i = 0; i < n; i++) {
                    instruments[i] = in.nextInt();
                    high = Math.max(high, instruments[i]);
                }

                while (high - low > 1) {
                    int mid = low + (high - low) / 2;

                    if (possible(instruments, p, mid)) {
                        high = mid;
                    } else {
                        low = mid;
                    }
                }

                if (possible(instruments, p, low)) {
                    System.out.println(low);
                } else {
                    System.out.println(high);
                }
                String blank = in.nextLine();
                s = in.nextLine();

            }




        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(int[] instruments, int p, int mid) {
        int reqScores = 0;

        for (int i = 0; i < instruments.length; i++) {
            if (instruments[i] > mid) {
                reqScores += instruments[i] % mid == 0 ? (instruments[i] / mid) : (instruments[i] / mid + 1);
            } else {
                reqScores++;
            }
        }

        return reqScores <= p;

    }
}