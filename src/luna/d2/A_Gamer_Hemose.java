package luna.d2;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 20:15:04
 * Problem Link: 'https://codeforces.com/contest/1592/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Gamer_Hemose
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
            {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int first = a[n-1];
            int second = a[n-2];

            int ans = 0;
            if(k%(first+second)==0)
            {
                ans = ans + k/(first+second)*2;
            }
            else {
                if(k%(first+second) <= first || k%(first+second) <= second)
                {
                    ans = ans + k/(first+second)*2 + 1;
                }
                else {                
                    ans = ans + k/(first+second)*2 + 2;
                }
                
            }
            System.out.println(ans);
        }
        in.close();
    }
}