package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 13:05:29
 * Problem Link: 'https://codeforces.com/contest/688/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Lovely_Palindromes
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String ans = s + (new StringBuilder(s)).reverse().toString();
        System.out.println(ans);
        in.close();
    }
}