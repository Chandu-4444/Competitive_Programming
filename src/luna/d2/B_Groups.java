package luna.d2;
/* Author: Luna
 * Date: 10-October-2021
 * Time: 17:37:54
 * Problem Link: 'https://codeforces.com/contest/1598/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Groups
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

            

            int arr[][] = new int[n][5];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<5;j++)
                {
                    arr[i][j] = in.nextInt();

                }
            }


            for(int i=0;i<5;i++)
            {
                
                int pos[] = new int[n];
                int sum1 = 0, sum2;
                for(int j=0;j<n;j++)
                {
                    sum1 += arr[j][i];
                    if(arr[j][i]==1)
                    {
                        pos[j] = 1;
                    }
                }
                // System.out.println("Sum at "+i+" = "+sum1);

                if(sum1<(n/2))
                {
                    continue;
                }


                for(int k=0;k<5;k++)
                {
                    sum2 = 0;
                    int diff = 0;

                    if(k==i)
                    {
                        continue;
                    }
                    for(int j=0;j<n;j++)
                    {
                        if(pos[j]==1 && arr[j][k]==1)
                        {
                            diff++;
                            sum2++;
                        }
                        else if(arr[j][k]==1)
                        {
                            sum2++;
                        }

                    }
                    // System.out.println("Sum and diff at "+k+" = "+sum2+" "+diff);

                    if(sum1 + sum2 - diff == n && sum2>=(n/2))
                    {
                        // System.out.println(i+" "+k);
                        System.out.println("YES");
                        return;
                    }
                    // System.out.println();
                }


            }
            System.out.println("NO");
            return;


    }
}