package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc184/tasks/abc184_c
/*
  Author: Luna
  Date: 27/09/21
  Time: 5:46 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class SuperRyuma {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            if(a == c && b == d)
            {
                System.out.println(0);
            }
            else if((a + b == c + d) || (a - b == c - d) || (Math.abs(a - c) + Math.abs(b - d) <= 3))
            {
                System.out.println(1);
            }
            else if((a + b + c - d)%2==0){
                System.out.println(2);
            }
            else{
                for(int i=-3;i<=3;i++)
                {
                    for(int j=-3;j<=3;j++)
                    {
                        if(Math.abs(i)+Math.abs(j) > 3)
                        {
                            continue;
                        }

                        int newa = a + i;
                        int newb = b + j;

                        if((newa + newb == c + d) || (newa - newb == c - d) || (Math.abs(newa - c) + Math.abs(newb - d) <= 3))
                        {
                            System.out.println(2);
                            return;
                        }
                    }
                }
                System.out.println(3);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}