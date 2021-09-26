package luna.D2;

// Problem Link: https://codeforces.com/contest/1551/problem/B1
/*
  Author: Luna
  Date: 24/09/21
  Time: 8:46 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class WonderfulColoringI {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                String s = in.next();
                int freq[] = new int[256];

                for(int i=0;i<s.length();i++)
                {
                    freq[s.charAt(i)]++;
                }

                int ans = 0;
                for(int i=0;i<freq.length;i++)
                {
                    if(freq[i]>=2)
                    {
                        ans = ans + 2;
                    }
                    else if(freq[i]!=0)
                    {
                        ans = ans + 1;
                    }
                }

                ans = ans/2;
                System.out.println(ans);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}