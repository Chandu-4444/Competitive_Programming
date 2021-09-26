package luna.D2;

// Problem Link: https://codeforces.com/contest/16/problem/C
/*
  Author: Luna
  Date: 25/09/21
  Time: 10:03 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Monitor {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            long a = in.nextInt();
            long b = in.nextInt();
            long x = in.nextInt();
            long y = in.nextInt();

            long GCD = gcd(x, y);

            // Converting to actual ratios (relatively primes)
            while(GCD!=1)
            {
                x = x/GCD;
                y = y/GCD;
                GCD = gcd(x, y);
            }

            long low = 0, high = (long)2e9 + 1;

            while (high - low > 1) {
                long mid = low + (high - low) / 2;



                if(possible(mid, x, y, a, b))
                {
                    low = mid;
                }
                else{
                    high = mid;
                }
            }

            if(possible(low, x, y, a, b))
            {
                System.out.println(low*x+" "+low*y);
            }
            else{
                System.out.println(high*x+" "+high*y);
            }



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static long gcd(long a, long b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public static boolean possible(long mid, long x, long y, long a, long b)
    {
        long side1 = mid * x;
        long side2 = mid * y;

        return (side1 <= a && side2 <= b);
    }
}