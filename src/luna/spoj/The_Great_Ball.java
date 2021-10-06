package luna.spoj;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 15:17:25
 * Problem Link: 'https://www.spoj.com/problems/BYTESE2/',
*/
import java.util.*;
import java.io.*;
public class The_Great_Ball
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            int m = -1;
            for(int i=0; i<n; i++)
            {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
                m = Math.max(m, end[i]);
            }

            int count[] = new int[m+1];
            for(int i=0; i<n; i++)
            {
                count[start[i]] = 1;
                count[end[i]] = -1;
            }


            long ans = 0, s=0;
            for(int i=0;i<=m; i++)
            {
                if(count[i]==1)
                {
                    s++;
                    ans = Math.max(ans, s);
                }
                else if(count[i]==-1)
                {
                    s--;
                }

            }
            System.out.println(ans);

           

            
        }
        in.close();
    }
}