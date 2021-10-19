/* Author: Luna
 * Date: 13-October-2021
 * Time: 20:06:13
 * Problem Link: 'https://codeforces.com/contest/1593/problem/0',
*/
import java.util.*;
import java.io.*;
public class A_Elections
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();



            int x = Math.max(b,c);
            System.out.print(Math.max(0, x - a + 1)+" ");
            x = Math.max(a,c);
            System.out.print(Math.max(0, x - b + 1)+" ");
            x = Math.max(a,b);
            System.out.println(Math.max(0, x - c + 1));
        }
        in.close();
    }
}