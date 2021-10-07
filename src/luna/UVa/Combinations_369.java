package luna.UVa;

/* Author: Luna
 * Date: 07-October-2021
 * Time: 11:22:29
 * Problem Link: 'https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=305',
*/
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Combinations_369
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            if(n==0 && k==0)
            {
                break;
            }
            
            BigInteger a = fact(n);
            BigInteger b = fact(k);
            BigInteger c = fact(n-k);

            System.out.println(n+" things taken "+k+" at a time is "+a.divide(b.multiply(c))+" exactly.");
        }
        in.close();
    }
    public static BigInteger fact(int n)
    {
        BigInteger f = new BigInteger("1");

        for(int i=2; i<=n; i++)
        {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}