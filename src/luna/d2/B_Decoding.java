package luna.d2;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 23:37:52
 * Problem Link: 'https://codeforces.com/contest/746/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Decoding
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int index = 0;
        String ans = "";

        for(int i=((n-1)/2)*2;i>=0;i = i-2)
        {
            ans = s.charAt(i)+ans;
        }
        for(int i=1;i<n;i=i+2)
        {
            ans = s.charAt(i)+ans;
        }
        System.out.println(n%2==0?(new StringBuilder(ans)).reverse().toString():ans);
        in.close();
    }
}