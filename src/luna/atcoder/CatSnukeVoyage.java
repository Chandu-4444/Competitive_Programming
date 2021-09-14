package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc068/tasks/arc079_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 8:32 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatSnukeVoyage {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();

            int count[] = new int[2_00_000+1];

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (a == 1) {
                    count[b]++;
                } else if (b == 1) {
                    count[a]++;
                }

                if (a == n) {
                    count[b]++;
                } else if (b == n) {
                    count[a]++;
                }
            }

            boolean flag= false;
            for(int i=0;i<=n;i++)
            {
                if(count[i]==2)
                {
                    flag = true;
                }
            }

            if(flag)
            {
                System.out.println("POSSIBLE");
            }
            else{
                System.out.println("IMPOSSIBLE");

            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}