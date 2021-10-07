package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 20:10:32
 * Problem Link: 'https://codeforces.com/contest/79/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Colorful_Field
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int waste[][] = new int[k][2];
        for(int i=0; i<k; i++)
        {
            waste[i][0] = in.nextInt();
            waste[i][1] = in.nextInt();
        }

        while(q-->0)
        {
            solve(in, waste, n, m);
        }

        in.close();
    }

    private static void solve(Scanner in, int waste[][], int n, int m) {
        int x = in.nextInt();
        int y = in.nextInt();

        // System.out.println("Coords = "+x+" "+y);
        int countRow = 0, countCol = 0, countWaste = 0;
        for(int i=0;i<waste.length;i++)
        {
            if(x==waste[i][0] && y==waste[i][1])
            {
                System.out.println("Waste");
                return;
            }
            if(x>waste[i][0] || (x==waste[i][0] && y>=waste[i][1]))
            {
                // System.out.println("Incremented at: "+waste[i][0]+" "+waste[i][1]);
                countWaste++;
            }
            
        }

        int totCells = (x-1)*m + y - countWaste - 1;
        // System.out.println("Total Cell  = "+totCells+" Waste Cells = "+countWaste);
        int rem = totCells%3;
        String crops[] = {"Carrots", "Kiwis", "Grapes"};
        System.out.println(crops[rem]);
    

    }
}