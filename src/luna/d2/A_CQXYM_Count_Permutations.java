package luna.d2;
/* Author: Luna
 * Date: 01-October-2021
 * Time: 13:06:18
 * Problem Link: 'https://codeforces.com/contest/1581/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_CQXYM_Count_Permutations
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            long n = in.nextInt();

            n = n * 2;

            long ans = 1;
            for(int i=3;i<=n;i++)
            {
                ans = (ans*i) % 1_000_000_007;
            }
            System.out.println(ans);
        }
        in.close();
    }
}