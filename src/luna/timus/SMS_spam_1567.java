package luna.timus;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 00:08:35
 * Problem Link: 'https://acm.timus.ru/problem.aspx?space=1&num=1567',
*/
import java.util.*;
import java.io.*;
public class SMS_spam_1567
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int c[] = new int[256];
        c['a'] = 1;
        c['b'] = 2;
        c['c'] = 3;
        c['d'] = 1;
        c['e'] = 2;
        c['f'] = 3; 
        c['g'] = 1;
        c['h'] = 2;
        c['i'] = 3;
        c['j'] = 1;
        c['k'] = 2;
        c['l'] = 3;
        c['m'] = 1;
        c['n'] = 2;
        c['o'] = 3;
        c['p'] = 1;
        c['q'] = 2;
        c['r'] = 3;
        c['s'] = 1;
        c['t'] = 2;
        c['u'] = 3;
        c['v'] = 1;
        c['w'] = 2;
        c['x'] = 3;
        c['y'] = 1;
        c['z'] = 2;
        c['.'] = 1;
        c[','] = 2;
        c['!'] = 3;
        c['_'] = 1;
        c[' '] = 1;

        long ans = 0;

        for(int i=0;i<s.length(); i++)
        {
            // System.out.println(s.charAt(i)+"-->"+c[s.charAt(i)]);
            ans = ans + c[s.charAt(i)];
        }
        System.out.println(ans);
        

        in.close();
    }
}