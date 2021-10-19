/* Author: Luna
 * Date: 17-October-2021
 * Time: 15:23:55
 * Problem Link: 'https://www.codechef.com/SNCKQL21/problems/LUCKYNUM',
*/
import java.util.*;
import java.io.*;
public class Lucky_Number
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if(a==7 || b==7 || c==7)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        in.close();
    }
}