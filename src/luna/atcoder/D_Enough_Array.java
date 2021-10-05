package luna.atcoder;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 18:11:20
 * Problem Link: 'https://atcoder.jp/contests/abc130/tasks/abc130_d',
*/
import java.util.*;
import java.io.*;
public class D_Enough_Array
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextInt();
        int a[] = new int[n];
        long prefix[] = new long[n+1];
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            a[i] = in.nextInt();
            sum = sum + a[i];

            prefix[i+1] = sum;
        }
        long ans = 0;
        for(int i=0;i<n;i++)
        {
            int low = i-1, high = n+1;
            while(high - low>1)
            {
                int middle = low + (high - low)/2;
                if(k+prefix[i] <= prefix[middle])
                {
                    high = middle;
                }
                else
                {
                    low = middle;
                }
            }
            ans = ans + (n+1 - high);
        }
        System.out.println(ans);

        in.close();
    }
}