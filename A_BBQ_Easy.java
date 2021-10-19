/* Author: Luna
 * Date: 19-October-2021
 * Time: 23:02:07
 * Problem Link: 'https://atcoder.jp/contests/agc001/tasks/agc001_a',
*/
import java.util.*;
import java.io.*;
public class A_BBQ_Easy
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        n = 2*n;
        int arr[] = new int[n];
        for(int i=0; i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<arr.length; i+=2)
        {
            ans = ans + Math.min(arr[i], arr[i+1]);
        }
        System.out.println(ans);
        in.close();
    }
}