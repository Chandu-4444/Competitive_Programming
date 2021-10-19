/* Author: Luna
 * Date: 13-October-2021
 * Time: 21:02:18
 * Problem Link: 'https://codeforces.com/contest/1593/problem/D1',
*/
import java.util.*;
import java.io.*;
public class D1_All_are_Same
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int arr[] = new int[n];
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int i=0; i<n;i++)
            {
                arr[i] = in.nextInt();
                hs.add(arr[i]);
            }
            if(hs.size() == 1)
            {
                System.out.println("-1");
                continue;
            }

            hs.clear();

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(arr[i]==arr[j])
                    {
                        continue;
                    }
                    hs.add(Math.abs(arr[i] - arr[j]));
                }
            }

            System.out.println(findGCD(hs, n));



        }
        in.close();
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int findGCD(HashSet<Integer> hs, int n)
    {
        int result = 0;
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            result = gcd(result, it.next());
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
}