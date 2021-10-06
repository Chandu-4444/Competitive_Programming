package luna.d2;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 17:20:04
 * Problem Link: 'https://codeforces.com/contest/706/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Interesting_drink
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];
        for(int i=0; i<n; i++)
        {
            prices[i] = in.nextInt();
        }
        Arrays.sort(prices);
        int q = in.nextInt();
        while(q-->0)
        {
            int money = in.nextInt();
            if(money<prices[0])
            {
                System.out.println(0);
                continue;
            }
            int low = 0, high = n;
            while(high - low > 1)
            {
                int mid = low + (high - low)/2;
                if(money<prices[mid])
                {
                    high = mid;
                }
                else
                {
                    low = mid;
                }
            }
           
            System.out.println((low+1));

        }
        in.close();
    }
}