package luna.codechef;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 23:32:17
 * Problem Link: 'https://www.codechef.com/problems/EXTRAN',
*/
import java.util.*;
import java.io.*;
public class Bear_and_Extra_Number
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n; i++)
            {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int res = -1;
            if(a[0]+1<a[1])
            {
                res = a[0];
            }
            else if(a[n-2]<a[n-1]-1)
            {
                res = a[n-1];
            }
            else
            {
                for(int i=0;i<n-1;i++)
                {
                    if(a[i]==a[i+1])
                    {
                        res = a[i];
                        break;
                    }
                }
            }
            
            System.out.println(res);

        }

        in.close();
    }
}