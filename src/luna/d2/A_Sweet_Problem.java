package luna.d2;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 16:47:17
 * Problem Link: 'https://codeforces.com/contest/1263/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Sweet_Problem
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0)
        {
            int arr[] = new int[3];
            for(int i=0;i<3;i++)
            {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);

            if(arr[2]>=arr[0]+arr[1])
            {
                System.out.println(arr[0]+arr[1]);
            }
            else
            {
                System.out.println((arr[2]+arr[1]+arr[0])/2);
            }

        }
        in.close();
    }
}