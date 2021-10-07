package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 23:06:15
 * Problem Link: 'https://codeforces.com/problemset/problem/1327/A',
*/
import java.util.*;
import java.io.*;
public class A_Sum_of_Odd_Integers
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            long n = in.nextInt();
            long k = in.nextInt();
            if(k*k>n)
            {
                System.out.println("NO");
                continue;
            }
            if(n%2==k%2)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        in.close();
    }
}