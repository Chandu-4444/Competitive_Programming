package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 21:08:20
 * Problem Link: 'https://codeforces.com/contest/766/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Mahmoud_and_a_Triangle
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        for(int i=1;i<n-1;i++)
        {
            int a = arr[i-1];
            int b = arr[i];
            int c = arr[i+1];

            if(a+b>c && a+c>b && c+b>a)
            {
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");
        in.close();
    }
}