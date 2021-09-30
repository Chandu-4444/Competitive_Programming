package luna.atcoder;
/* Author: Luna
 * Date: 30-September-2021
 * Time: 23:05:17
 * Problem Link: 'https://atcoder.jp/contests/abc129/tasks/abc129_c',
*/
import java.util.*;
import java.io.*;
public class C_Typical_Stairs
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n+1];
        int MOD = 1_000_000_007;

        for(int i=0;i<m;i++)
        {
            int broken = in.nextInt();
            a[broken] = -1;
        }
        if(a[1]!=-1)
        {
            a[1] = 1;
        }
        if(n>1 && a[2]!=-1)
        {
            a[2] = a[1]!=-1?(a[1]+1):1;
        }

        for(int i=3;i<=n;i++)
        {
            if(a[i]!=-1)
            {
                int prevOne = a[i-2]!=-1?a[i-2]:0;
                int prevTwo = a[i-1]!=-1?a[i-1]:0;

                a[i] = (prevTwo%MOD + prevOne%MOD)%MOD;
            }
        }
        // for (int i = 0; i < a.length; i++) {
        //     System.out.println(i+"-->"+a[i]);
        // }

        System.out.println(a[n]);

        in.close();
    }
}