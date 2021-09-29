package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc189/tasks/abc189_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 5:10 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MandarinOrange {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }

            // Set l and move r towards the end of the array, in this process, find the minimum and find the possible ans

            int ans = 0;
            for(int l=0;l<n;l++)
            {
                int currMin = a.get(l);
                for(int r = l;r<n;r++)
                {
                    currMin = Math.min(currMin, a.get(r));
                    ans = Math.max((r - l + 1)*currMin, ans);
                }
            }
            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}