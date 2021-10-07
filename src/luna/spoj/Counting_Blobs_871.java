package luna.spoj;
// package luna.UVa;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 22:55:21
 * Problem Link: 'https://onlinejudge.org/external/8/871.pdf',
*/
import java.util.*;
import java.io.*;
public class Counting_Blobs_871
{
    public static int count = 0;
    public static void main(String args[]) throws IOException
    {
        // Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuffer sAns = new StringBuffer();
        in.readLine();
        while(t-->0)
        {
            count = 0;
            ArrayList<String> grid = new ArrayList<String>();
            String s;
            while((s = in.readLine())!=null && s.length()>0)
            {
                grid.add(s);
            }
            int matrix[][] = new int[grid.size()][grid.get(0).length()];
            for(int i=0;i<grid.size(); i++)
            {
                for(int j=0;j<grid.get(i).length();j++)
                {
                    matrix[i][j] = (grid.get(i).charAt(j) == '1'?1:0);
                }
            }

            boolean visited[][] = new boolean[grid.size()][grid.get(0).length()];

            int ans = 0;
            for(int i=0;i<matrix.length; i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(!visited[i][j] && matrix[i][j]==1)
                    {
                        floodFill(matrix, visited, i, j);
                        ans = Math.max(count, ans);
                        count = 0;
                    }
                }  
            }
            sAns.append(ans).append("\n");
            if(t!=0)
            {
                sAns.append("\n");
            
            }
        }
        System.out.print(sAns.toString());

    }
    static int dx[]={1,-1,0,0,1,-1,1,-1};
    static int dy[]={0,0,1,-1,1,1, -1,-1};
    private static void floodFill(int[][] matrix, boolean[][] visited, int i, int j) {
        if(j<0 || i<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]==0 || visited[i][j])
        {
            return;
        }
        visited[i][j] = true;
        count++;
        for(int k=0;k<8;k++)
        {
            floodFill(matrix, visited, i+dx[k], j+dy[k]);
        }


    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;


// public class Main  {

// 	public static int rows;
// 	public static int cols;
// 	public static ArrayList<String>grid;
// 	public static boolean [][]visited;
// 	public static int cnt;
	
// 	public static boolean isValid(int r,int c)
// 	{
// 		if((r>=0 && r<rows) && (c>=0 && c<cols))
// 			return true;
// 		else
// 			return false;
// 	}
	
// 	public static void floodFill(int r,int c)
// 	{
// 		if(!isValid(r,c) || grid.get(r).charAt(c)=='0' || visited[r][c])
// 			return;
		
// 		visited[r][c]=true;
// 		cnt++;
		
// 		floodFill(r+1, c); // Down
// 		floodFill(r-1, c); // UP
// 		floodFill(r, c-1); // Left
// 		floodFill(r, c+1); // Right
// 		floodFill(r-1, c-1); // UP-Left
// 		floodFill(r+1, c-1); // Down -Left
// 		floodFill(r-1, c+1); // UP - Right
// 		floodFill(r+1, c+1); // Down - Right	
		
// 	}
	
// 	public static void main(String[] args) throws NumberFormatException, IOException {
// 		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// 		StringBuilder ans = new StringBuilder();
// 		int t = Integer.parseInt(in.readLine());		
// 		in.readLine();
// 		for(int i=0;i<t;i++)
// 		{			
// 			cnt =0;
// 			grid = new ArrayList<String>();
// 			String temp;
// 			while((temp = in.readLine())!=null && temp.length()!=0 )			
// 				grid.add(temp);
			
// 			rows = grid.size();
// 			cols = grid.get(0).length();
// 			visited = new boolean [rows][cols];
// 			for(int j=0;j<rows;j++)
// 			{
// 				for(int k=0;k<cols;k++)
// 				{
// 					int tm = cnt;
// 					cnt=0;
// 					if(!visited[j][k] && grid.get(j).charAt(k)!='0')
// 						floodFill(j, k);
// 					cnt = Math.max(cnt, tm);
// 				}
// 			}
// 			ans.append(cnt).append("\n");
// 			if(i!=t-1)
// 				ans.append("\n");
// 		}
// 		System.out.print(ans.toString());
// 	}
// }