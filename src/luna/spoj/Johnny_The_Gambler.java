package luna.spoj;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 23:51:01
 * Problem Link: 'https://www.spoj.com/problems/LCPC12F/',
*/
import java.util.*;
import java.io.*;
public class Johnny_The_Gambler
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t_ = in.nextInt();
        for(int t = 1; t<=t_; t++)
        {
            int x = in.nextInt();
            int n = in.nextInt();  
            int a[] = new int[n+1];
            int count[] = new int[1_000+1];
            for(int i=1;i<=n;i++)
            {
                a[i] = in.nextInt();
                count[a[i]]++;
            }

            long ans = 0;

            for(int i=1;i<=n; i++)
            {
                count[a[i]]--;
                int need = x - a[i];

                if(need>=0 && need <=1000)
                {
                    ans = ans + count[need];
                }
                
            }
            System.out.println(t+". "+ans);

        }
        in.close();
    }
}