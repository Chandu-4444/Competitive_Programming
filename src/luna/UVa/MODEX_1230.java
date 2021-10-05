package luna.UVa;
/* Author: Luna
 * Date: 02-October-2021
 * Time: 15:01:51
 * Problem Link: 'https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3671',
*/
import java.util.*;
import java.io.*;
public class MODEX_1230
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            long x = in.nextLong();
            long y = in.nextLong();
            long n = in.nextLong();

            // Binray Exponentiation
            long res = 1;

            while(y>0)
            {
                if((y&1)==1)
                {
                    res = res * x %n;
                }
                x = x*x %n;
                y = y>>1;
            }
            System.out.println(res%n);

        }


        in.close();
    }
}