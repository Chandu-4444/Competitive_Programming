package luna.UVa;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 16:26:38
 * Problem Link: 'https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3666',
*/
import java.util.*;
import java.io.*;
public class Digit_Counting_1225
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int digits[] = new int[10];
            for(int i=1;i<=n;i++)
            {
                int num = i;
                while(num>0)
                {
                    int rem =  num%10;
                    digits[rem]++;
                    num = num/10;
                }
            }
            for(int i=0;i<=9;i++)
            {
                System.out.print(digits[i]+(i!=9?" ":""));
            }
            System.out.println();
        }
        
        in.close();
    }
}