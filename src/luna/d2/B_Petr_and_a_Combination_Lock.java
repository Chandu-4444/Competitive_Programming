package luna.d2;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 17:33:31
 * Problem Link: 'https://codeforces.com/problemset/problem/1097/B',
*/
import java.util.*;
import java.io.*;
public class B_Petr_and_a_Combination_Lock
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }

        for(int i=1;i<=(1<<n);i++)
        {
            int res = 0;
            int currVal = 1;
            for(int j=0;j<n;j++)
            {
                if((currVal&i)>0)
                {
                    res = res + arr[j];
                }
                else
                {
                    res = res - arr[j];
                }
                currVal<<=1;
            }
            if(res%360==0)
            {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
        in.close();
    }
}