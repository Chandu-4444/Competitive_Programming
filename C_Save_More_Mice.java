/* Author: Luna
 * Date: 13-October-2021
 * Time: 20:35:28
 * Problem Link: 'https://codeforces.com/contest/1593/problem/C',
*/
import java.util.*;
import java.io.*;
public class C_Save_More_Mice
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int k = in.nextInt();

            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<k;i++)
            {
                list.add(in.nextInt());
            }
            Collections.sort(list, Collections.reverseOrder());
            int c = 0, ans = 0;

            for(int i: list)
            {
                if(c<i)
                {
                    ans =ans +1;
                }
                else
                {
                    break;
                }

                c = c + (n-i);
            }
            System.out.println(ans);
        }
        

        in.close();
    }
}