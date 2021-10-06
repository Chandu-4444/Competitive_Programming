package luna.timus;

/* Author: Luna
 * Date: 05-October-2021
 * Time: 17:39:41
 * Problem Link: 'https://acm.timus.ru/problem.aspx?space=1&num=1100',
*/
import java.util.*;
import java.io.*;
public class Final_Standings_1100
{
    public static void main(String args[])
    {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++)
        {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Arrays.sort(arr, (i, j)->j[1] - i[1]);
        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}