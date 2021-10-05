package luna.codechef;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 11:30:56
 * Problem Link: 'https://www.codechef.com/problems/CULPRO',
*/
import java.util.*;
import java.io.*;
public class Cultural_Programme
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            start[i] = in.nextInt();
            end[i] = in.nextInt();
            max = Math.max(max, end[i]);
        }

        int count[] = new int[max+1];

        for(int i=0;i<n ;i++)
        {
            count[start[i]] = 1;
            count[end[i]] = -1;
        }

        int ans = 0, sum = 0;
        for(int i=0; i<=max; i++)
        {
            if(count[i]==1)
            {
                sum++;
                ans = Math.max(ans, sum);
            }
            else if(count[i]==-1)
            {
                sum--;
            }
        }
        System.out.println(ans);

        in.close();
    }
}