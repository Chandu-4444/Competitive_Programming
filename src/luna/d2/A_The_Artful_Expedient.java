package luna.d2;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 22:35:57
 * Problem Link: 'https://codeforces.com/contest/869/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_The_Artful_Expedient
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];

        HashSet<Integer> hs = new HashSet<Integer>();

        for(int i=0;i<n;i++)
        {
            x[i] = in.nextInt();
            hs.add(x[i]);

        }
        for(int i=0;i<n;i++)
        {
            y[i] = in.nextInt();
            hs.add(y[i]);
        }

        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                // System.out.printf("%d ^ %d = %d\n", x[i], y[j], x[i]^y[j]);
                if(hs.contains(x[i]^y[j]))
                {
                    ans++;
                }
            }
        }

        if(ans%2==0)
        {
            System.out.println("Karen");
        }
        else
        {
            System.out.println("Koyomi");
        }
        


        in.close();
    }
}