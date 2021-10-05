package luna.d2;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 16:53:45
 * Problem Link: 'https://codeforces.com/contest/27/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Next_Test
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[3_000+1];
        for(int i=0;i<n;i++)
        {
            a[in.nextInt()] = 1;
        }
        
        for(int i=1;i<=3000;i++)
        {
            if(a[i]!=1)
            {
                System.out.println(i);
                return;
            }
        }
        System.out.println(3001);

        
        in.close();
    }
}