package luna.UVa;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 10:39:19
 * Problem Link: 'https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3875',
 * Approach: If A&B has a bit set, then A|B will definitely have that bit set, if not then -1.
 *           Then, we'll assigne A = C, B = C (Possible answers for A&B). Then we'll set all the ones in A|B (D) to A.
 *           But the highest set bit in A|B has to be set to B as A<B. Then remaining set bits should be put in A.
*/
import java.util.*;
import java.io.*;
public class Bits_and_Pieces_12444
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            solve(in);
        }
        in.close();
    }
    public static void solve(Scanner in)
    {
        long c = in.nextLong();
            long d = in.nextLong();

            for(int i=30;i>=0;i--)
            {
                if((c&(1<<i))!=0 && (d&(1<<i))==0)
                {
                    System.out.println("-1");
                    return;
                }
            }

            long a = c, b = c;
            boolean flag = false;

            for(int i = 30; i>=0; i--)
            {
                if((c&(1<<i))==0)
                {
                    if((d&(1<<i))!=0)
                    {
                        if(flag)
                        {
                            a = a|(1<<i);
                        }
                        else
                        {
                            b = b|(1<<i);
                        }
                        flag = true;
                    }
                }
            }
            System.out.println(a+" "+b);
    }
}