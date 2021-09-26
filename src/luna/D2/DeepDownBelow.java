package luna.D2;

// Problem Link: https://codeforces.com/problemset/problem/1561/C
/*
  Author: Luna
  Date: 26/09/21
  Time: 12:19 AM
 */

import java.util.*;
import java.io.IOException;

public class DeepDownBelow {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            while(t-->0)
            {
                int n = in.nextInt();
                long ans = -1;
                for(int i=0;i<n;i++)
                {
                    int k = in.nextInt();
                    int a[] = new int[k];

                    for(int j=0;j<k;j++)
                    {
                        a[j] = in.nextInt();
                    }

                    Arrays.sort(a);

                    int low = 0, high = (int)1e9;

                    while(high - low > 1)
                    {
                        int mid = low + (high - low)/2;

                        if(possible(a, mid))
                        {
                            high = mid;
                        }
                        else{
                            low = mid;
                        }
                    }

                    if(possible(a, low))
                    {
                        ans = Math.max(ans, low);
                    }
                    else{
                        ans = Math.max(ans, high);
                    }
                }
                System.out.println(ans);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static boolean possible(int[] a, int val) {
        int energy = val;

        for(int i=0;i<a.length;i++)
        {
            if(energy > a[i])
            {
                energy++;
            }
            else{
                return false;
            }
        }

        return true;
    }
}