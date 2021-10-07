package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 15:41:48
 * Problem Link: 'https://codeforces.com/contest/810/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Summer_sell_off
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[][] = new int[n][2];
        int at[] = new int[n];
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            ans = ans + Math.min(arr[i][0], arr[i][1]);
            at[i] = Math.min(2*arr[i][0], arr[i][1]) - Math.min(arr[i][0], arr[i][1]);
        }

        Arrays.sort(at);
        int f = 0;
        for(int i=n-1; i>=0; i--)
        {
            if(f==k)
            {
                break;
            }
            ans = ans + at[i];
            f++;

        }
        System.out.println(ans);
        in.close();
    }
}