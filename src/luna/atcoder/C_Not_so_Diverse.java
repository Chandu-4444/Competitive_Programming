package luna.atcoder;
/* Author: Luna
 * Date: 30-September-2021
 * Time: 23:24:58
 * Problem Link: 'https://atcoder.jp/contests/abc081/tasks/arc086_a',
*/
import java.util.*;
import java.io.*;
public class C_Not_so_Diverse
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[2_00_000+1];

        for(int i=0;i<n;i++)
        {
            a[in.nextInt()]--;
        }
        Arrays.sort(a);
        int ans = 0;
        int counter = 0;
        for(int i=0;i<=2_00_000;i++)
        {
            if(a[i]!=0 && counter!=k)
            {
                counter++;
            }
            else{
                ans = ans + Math.abs(a[i]);
            }
        }
        System.out.println(ans);
        in.close();
    }
}