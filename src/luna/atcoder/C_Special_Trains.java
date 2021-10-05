package luna.atcoder;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 17:01:12
 * Problem Link: 'https://atcoder.jp/contests/abc084/tasks/abc084_c',
*/
import java.util.*;
import java.io.*;
public class C_Special_Trains
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int C[] = new int[n];
        int S[] = new int[n];
        int F[] = new int[n];
        for(int i=0;i<n-1;i++)
        {
            C[i] = in.nextInt();
            S[i] = in.nextInt();
            F[i] = in.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            int currTime = 0;
            for(int j = i; j<n-1;j++)
            {
                if(S[j]>currTime)
                {
                    currTime = S[j];
                }
                else if(currTime%F[j]==0)
                {
                    // continue;
                }
                else
                {
                    currTime = currTime + F[j] - (currTime)%F[j];
                }
                currTime = currTime + C[j];
            }
            System.out.println(currTime);
        }
        in.close();
    }
}