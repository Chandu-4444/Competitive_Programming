package luna.D2;

// Problem Link: https://codeforces.com/contest/1183/problem/C
/*
  Author: Luna
  Date: 24/09/21
  Time: 4:14 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class ComputerGame {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            while (t-- > 0) {
                int k = in.nextInt();
                int n = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();

                long low = 0, high = n;

                while(high-low>1)
                {
                    long mid = low + (high - low)/2;

                    if(possible(k, a, b, n, mid))
                    {
                        low = mid;
                    }
                    else
                    {
                        high = mid;
                    }
                }

//                System.out.println(low+" "+high);

                long ans = -1;
                if(possible(k, a, b, n, low))
                {
                    ans = Math.max(low, ans);
                }
                if (possible(k, a, b, n, high))
                {
                    ans = Math.max(ans, high);
                }
                System.out.println(ans);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(long k, long a, long b, long n, long mid) {
        if(a*mid + b*(n-mid) < k)
        {
            return true;
        }
        return false;
    }
}