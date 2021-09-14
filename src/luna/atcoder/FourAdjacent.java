package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc069/tasks/arc080_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 8:45 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class FourAdjacent {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int cou2 = 0, cou4 = 0;
            for(int i=0;i<n;i++)
            {
                int a = in.nextInt();
                if(a%2==0 && a%4!=0)
                {
                    cou2++;
                }
                if(a%4==0)
                {
                    cou4++;
                }

            }

            if((cou2/2+cou4)>=n/2)
            {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}