package luna.d2;
/* Author: Luna
 * Date: 10-October-2021
 * Time: 17:16:39
 * Problem Link: 'https://codeforces.com/contest/1598/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Computer_Game
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

    private static void solve(Scanner in) {
        int n = in.nextInt();
            String s[] = new String[2];
            s[0] = in.next();
            s[1] = in.next();

            int currX = 0, currY = 0;
            if(s[0].charAt(n-1)=='1' && s[1].charAt(n-1)=='1')
            {
                System.out.println("NO");
                return;
            }
            while(currX+1<n && currY<2)
            {
                if(currY==0 &&s[currY].charAt(currX+1)=='1' && s[currY+1].charAt(currX+1)=='1')
                {
                    System.out.println("NO");
                    return;
                }
                if(currY==1 &&s[currY].charAt(currX+1)=='1' && s[currY-1].charAt(currX+1)=='1')
                {
                    System.out.println("NO");
                    return;
                }
                else
                {
                    if(s[currY].charAt(currX+1)=='0')
                    {
                        currX++;
                    }
                    else if(currY==0 && s[currY+1].charAt(currX+1)=='0')
                    {
                        currY++;
                        currX++;
                    }
                    else if(currY==1 && s[currY-1].charAt(currX+1)=='0')
                    {
                        currY--;
                        currX++;
                    }
                }
            }
            System.out.println("YES");
            return;
           
    }

}