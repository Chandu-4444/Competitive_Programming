package luna.d2;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 16:58:41
 * Problem Link: 'https://codeforces.com/contest/706/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Beru_taxi
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        double min = Double.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            int v = in.nextInt();
            double dist = Math.sqrt((x - a)*(x - a) + (y - b)*(y - b));
            double t = dist/v;
            min = Math.min(min, t);
        }
        System.out.println(min);
        in.close();
    }
}