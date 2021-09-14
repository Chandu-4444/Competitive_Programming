package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc060/tasks/arc073_a
/*
  Author: Luna
  Date: 14/09/21
  Time: 11:00 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class Sentou {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int T = in.nextInt();

            int t[] = new int[N];
            for(int i=0;i<N;i++)
            {
                t[i] = in.nextInt();
            }

            int ans = 0;

            if(N==1)
            {
                System.out.println(T+t[0]);
                return;
            }

            for(int i=0;i<N-1;i++)
            {
                if(t[i+1] - t[i]<T)
                {
                    ans = ans + t[i+1] - t[i];
                }
                else{
                    ans = ans + T;
                }
            }
            // For last push
            ans = ans + T;
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}