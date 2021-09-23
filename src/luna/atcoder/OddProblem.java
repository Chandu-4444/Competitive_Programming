package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/aising2020/tasks/aising2020_b
/*
  Author: Luna
  Date: 15/09/21
  Time: 10:04 PM
 */

import java.util.*;
import java.io.IOException;

public class OddProblem {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            int ans = 0;
            for(int i=1;i<=n;i++)
            {
                int ai = in.nextInt();

                if(i%2==1 && ai%2==1)
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