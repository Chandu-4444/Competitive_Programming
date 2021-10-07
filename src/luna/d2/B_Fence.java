package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 12:18:20
 * Problem Link: 'https://codeforces.com/contest/363/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Fence
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long arr[] = new long[n];
        long s = 0;
        for(int i=0;i <n;i++)
        {
            arr[i] = in.nextLong();
        }
        long prefix[] = new long[n+1];
        for(int i=0;i<n;i++)
        {
            s = s + arr[i];
            prefix[i] = s;
            // System.out.println(prefix[i]);
        }

        // Remove k consecutive planks
        long min = Integer.MAX_VALUE, index = 1;
        for(int i=0;i<=n;i++)
        {
            if(i+k<=n && (prefix[i+k-1] - prefix[i] + arr[i]) < min)
            {
                min = prefix[i+k-1] - prefix[i] + arr[i];
                index = i+1;
            }
        }
        System.out.println(index);
        in.close();
    }
}