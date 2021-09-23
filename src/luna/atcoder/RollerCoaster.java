package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc142/tasks/abc142_b
/*
  Author: Luna
  Date: 15/09/21
  Time: 9:22 PM
 */

import java.util.*;
import java.io.IOException;

public class RollerCoaster {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int ans =0;
            for(int i=0;i<n;i++)
            {
                int h = in.nextInt();
                if(h>=k)
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