package luna.d2;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 23:13:33
 * Problem Link: 'https://codeforces.com/contest/78/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Easter_Eggs
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String colors[] = {"G", "B", "I", "V"};
        int n = in.nextInt();
        String ans = "ROY";
        for(int i=3;i<n;i++)
        {
            ans = ans + colors[i%4];
        }
        
        System.out.println(ans);
        in.close();
    }
}