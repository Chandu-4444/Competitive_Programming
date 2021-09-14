package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc063/tasks/arc075_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 3:21 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Bugged {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int s[] = new int[n];

            int ans = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
                sum = sum + s[i];
                if(s[i]%10!=0)
                {
                    ans = Math.min(ans, s[i]);
                }
            }

            if(sum%10!=0)
            {
                System.out.println(sum);
            }
            else{
                if(sum%10==0 && ans==Integer.MAX_VALUE)
                {
                    System.out.println(0);
                }
                else{
                    System.out.println(sum - ans);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}