package luna.dmoj;
/*
  Author: Luna
  Date: 13/09/21
  Time: 12:42 PM
 */
// https://dmoj.ca/problem/ccc12s5

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MouseJourney {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int R = in.nextInt();
            int C = in.nextInt();

            char grid[][] = new char[R][C];
            for(char arr[]: grid)
            {
                Arrays.fill(arr, '.');
            }

            int k = in.nextInt();
            for(int i=0;i<k;i++)
            {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                grid[r][c] = '#';
            }

            int paths[][] = new int[R+1][C+1];
            int sum = 0;
            for(int i=0;i<R;i++)
            {
                if(grid[i][0]=='#')
                {
                    break;
                }
                paths[i][0] = 1;
            }
            for(int i=0;i<C;i++)
            {
                if(grid[0][i]=='#')
                {
                    break;
                }
                paths[0][i] = 1;
            }

            for(int i=1;i<R;i++)
            {
                for(int j=1;j<C;j++)
                {
                    if(grid[i][j]!='#')
                    {
                        paths[i][j] = paths[i-1][j] + paths[i][j-1];
                    }
                }
            }

            System.out.println(paths[R-1][C-1]);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}