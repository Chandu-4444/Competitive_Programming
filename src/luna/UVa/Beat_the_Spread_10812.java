package luna.UVa;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 23:23:45
 * Problem Link: 'https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1753',
*/
import java.util.*;
import java.io.*;
public class Beat_the_Spread_10812
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int x = in.nextInt();
            int y = in.nextInt();

            if((x+y)%2!=0)
            {
                System.out.println("impossible");
                continue;
            }

            int one = (x+y)/2;
            int two = x - one;
            if(two<0)
            {
                System.out.println("impossible");
                continue;
            }

            if(one>two)
            {
                System.out.println(one+" "+two);
            }
            else
            {
                System.out.println(two+" "+one);
            }


        }
        in.close();
    }
}