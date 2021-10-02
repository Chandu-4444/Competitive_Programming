/* Author: Luna
 * Date: 01-October-2021
 * Time: 13:34:57
 * Problem Link: 'https://codeforces.com/problemset/problem/1325/A',
*/
import java.util.*;
import java.io.*;
public class A_EhAb_AnD_gCd
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            // Using the fact that GCD(x, 1) = 1 and LCM(x, 1) = x. Therefore
            // We need to find an x such that x + 1 = n
            int n = in.nextInt();
            System.out.println((n-1)+" "+1);
        }
        in.close();
    }
}