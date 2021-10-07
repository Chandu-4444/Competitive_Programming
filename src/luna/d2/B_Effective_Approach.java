package luna.d2;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 23:05:19
 * Problem Link: 'https://codeforces.com/contest/227/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Effective_Approach
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            int a = in.nextInt();
            arr[a] = i;
        }
        int m = in.nextInt();
        long a1=  0, a2 = 0;
        for(int i=0; i<m; i++)
        {
            int q = in.nextInt();
            a1 += arr[q];
            a2 += (n - arr[q] + 1); 
        }
        System.out.println(a1+" "+a2);
        in.close();
    }
}