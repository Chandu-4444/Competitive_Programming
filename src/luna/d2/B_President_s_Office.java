package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 12:53:47
 * Problem Link: 'https://codeforces.com/contest/6/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_President_s_Office
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        char c = in.next().charAt(0);
        char grid[][] = new char[rows][cols];
        for(int i=0;i<rows;i++)
        {
            String s = in.next();
            for(int j=0;j<s.length();j++)
            {
                grid[i][j] = s.charAt(j);
            }
        }

        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols; j++)
            {
                if(grid[i][j]==c)
                {
                    if(i!=0 && grid[i-1][j]!=c && grid[i-1][j]!='.')
                    {
                        ans++;
                        set.add(grid[i-1][j]);
                    }
                    if(j!=cols-1 && grid[i][j+1]!=c && grid[i][j+1]!='.')
                    {
                        ans++;
                        set.add(grid[i][j+1]);
                    }
                    if(i!=rows-1 && grid[i+1][j]!=c && grid[i+1][j]!='.')
                    {
                        ans++;
                        set.add(grid[i+1][j]);
                    }
                    if(j!=0 && grid[i][j-1]!=c && grid[i][j-1]!='.')
                    {
                        ans++;
                        set.add(grid[i][j-1]);
                    }
                }

            }
        }System.out.println(set.size());
        in.close();
    }
}