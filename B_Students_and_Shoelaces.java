/* Author: Luna
 * Date: 13-October-2021
 * Time: 19:43:06
 * Problem Link: 'https://codeforces.com/contest/129/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Students_and_Shoelaces
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int inDegree[] = new int[n];

        int graph[][] = new int[n][n];
        for(int i=0;i<m;i++)
        {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;

            graph[x][y] = 1;
            graph[y][x] = 1;

            inDegree[x]++;
            inDegree[y]++;
        }

        int ans = 0;

        while(true)
        {
            boolean flag = true;
            boolean visited[] = new boolean[n];

            for(int i=0;i<n;i++)
            {
                if(inDegree[i]==1 && !visited[i])
                {
                    inDegree[i]--;
                    if(flag)
                    {
                        ans++;
                    }

                    flag = false;

                    for(int j=0;j<n;j++)
                    {
                        if(graph[i][j]==1)
                        {
                            inDegree[j]--;
                            visited[j] = true;
                        }
                    }
                }
            }

            if(flag)
            {
                break;
            }
        }

        System.out.println(ans);

        
        in.close();
    }
}