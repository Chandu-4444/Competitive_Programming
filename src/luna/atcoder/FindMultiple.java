package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc220/tasks/abc220_a
/*
  Author: Luna
  Date: 26/09/21
  Time: 5:30 PM
 */

import java.util.*;
import java.io.IOException;

public class FindMultiple {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int ans = -1;

            for(int i=a;i<=b;i++)
            {
                if(i%c==0)
                {
                    ans = i;
                    break;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}