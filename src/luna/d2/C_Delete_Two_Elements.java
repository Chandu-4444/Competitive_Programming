package luna.d2;
/* Author: Luna
 * Date: 10-October-2021
 * Time: 18:45:20
 * Problem Link: 'https://codeforces.com/contest/1598/problem/C',
*/
import java.util.*;
import java.io.*;
public class C_Delete_Two_Elements
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int arr[] = new int[n];
            long sum = 0;
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for(int i = 0; i<n; i++)
            {
                arr[i] = in.nextInt();
                sum += arr[i];
                hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
            }


            
            long toSum = (2*sum);

            if(toSum%n!=0)
            {
                System.out.println(0);
                continue;
            }

            long ans = 0;


            



            
        }
        in.close();
    }
}