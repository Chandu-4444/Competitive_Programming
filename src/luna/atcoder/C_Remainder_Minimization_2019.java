package luna.atcoder;
/* Author: Luna
 * Date: 30-September-2021
 * Time: 17:54:28
*/

import java.util.Scanner;
public class C_Remainder_Minimization_2019
{
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long r = in.nextLong();

        long MOD = 2019;

        if(r - l>=2019)
        {
            System.out.println(0);
        }
        else{
            int min = Integer.MAX_VALUE;
            for(long i=l;i<=r;i++)
            {
                for(long j=i+1;j<=r;j++)
                {
                    long t = (i*j)%MOD;
                    min = (int)Math.min(min, t);
                }
            }
            System.out.println(min);
        }

    

        in.close();


    }
}