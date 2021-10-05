package luna.d2;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 20:58:21
 * Problem Link: 'https://codeforces.com/contest/1592/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Hemose_Shopping
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int x = in.nextInt();
            int a[][] = new int[n][2];
            int aSort[][] = new int[n][2];
            for(int i=0;i<n;i++)
            {
                a[i][0] = in.nextInt();
                a[i][1] = i;
                aSort[i][0] = a[i][0];
                aSort[i][1] = i; 
            }
            



        }
        in.close();
    }
}