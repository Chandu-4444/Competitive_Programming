package luna.d2;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 17:43:14
 * Problem Link: 'https://codeforces.com/problemset/problem/550/B',
*/
import java.util.*;
import java.io.*;
public class B_Preparing_Olympiad
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int x = in.nextInt();

        int diff[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            diff[i] = in.nextInt();
        }
    
        for(int i=0;i<=(1<<n); i++)
        {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, propCount = 0, currVal = 1, tot = 0;
            for(int j=0;j<n;j++)
            {
                if((currVal&i)>0)
                {
                    propCount++;
                    tot = tot + diff[j];
                    min = Math.min(min, diff[j]);
                    max = Math.max(max, diff[j]);
                }
                currVal = currVal<<1;
            }

            if(tot>=l && tot<=r && (max - min)>=x && propCount>=2)
            {
                ans++;
            }
        }
        System.out.println(ans);
        in.close();
    }
}