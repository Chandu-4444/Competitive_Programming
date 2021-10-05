package luna.spoj;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 11:14:58
 * Problem Link: 'https://www.spoj.com/problems/CSUMQ/',
*/
import java.util.*;
import java.io.*;
public class Cumulative_Sum_Query
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int prefix[] = new int[n+1];
        for(int i=0;i<n;i++)
        {
            a[i] = in.nextInt();
            prefix[i+1] = prefix[i] + a[i];
            // System.out.print(prefix[i]+" ");
        }
        // System.out.println();

        int q = in.nextInt();
        while(q-->0)
        {
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(prefix[r+1] - prefix[l]);
        }

        in.close();
    }
}