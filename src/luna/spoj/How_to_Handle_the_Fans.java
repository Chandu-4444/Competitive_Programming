package luna.spoj;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 11:50:08
 * Problem Link: 'https://www.spoj.com/problems/AKVQLD03/',
*/
import java.util.*;
import java.io.*;
public class How_to_Handle_the_Fans
{
    public static void build(int arr[], long segTree[], int start, int end, int treeIdx)
    {
        // base case
        if(start == end)
        {
            segTree[treeIdx] = arr[start];
            return;
        }
        int mid = (start + end)/2;

        build(arr, segTree, start, mid, 2*treeIdx);
        build(arr, segTree, mid+1, end, 2*treeIdx+1);

        segTree[treeIdx] = segTree[2*treeIdx] + segTree[2*treeIdx+1];
    }

    public static void update(int arr[], long segTree[], int start, int end, int treeIdx, int idx, int val)
    {
        if(start == end)
        {
            arr[idx] += val;
            segTree[treeIdx] += val;
            return;
        }
        int mid = (start + end)/2;
        if(idx > mid)
        {
            update(arr, segTree, mid+1, end, 2*treeIdx + 1, idx, val);
        }
        else
        {
            update(arr, segTree, start, mid, 2*treeIdx, idx, val);
        }

        segTree[treeIdx] = segTree[2*treeIdx] + segTree[2*treeIdx+1];
    }

    public static long query(long segTree[], int start, int end, int treeIdx, int left ,int right)
    {
        if(start > right || end < left)
        {
            // Complete outside
            return 0;
        }
        if(start>=left && end <=right)
        {
            // Complete inside
            return segTree[treeIdx];
        }
        int mid = (start + end)/2;
        long a1 = query(segTree, start, mid, 2*treeIdx, left, right);
        long a2 = query(segTree, mid+1, end, 2*treeIdx+1, left, right);
        
        return (a1+a2);
    }
    public static void main(String args[])
    {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int q = in.nextInt();
        int arr[] = new int[n];
        long segTree[] = new long[4*n];
        build(arr, segTree, 0, n-1, 1);
        while(q-->0)
        {
            // printArray(arr);
            String s = in.next();
            if(s.equals("add"))
            {
                int idx = in.nextInt()-1;
                int val = in.nextInt();
                // System.out.println(s+" "+idx+" "+val);
                update(arr, segTree, 0, n-1, 1, idx, val);
            }
            else
            {
                
                int left = in.nextInt()-1;
                int right = in.nextInt()-1;
                // System.out.println(s+" "+left+" "+right);

                System.out.println(query(segTree, 0, n-1, 1, left, right));
            }
        }
    }

    // private static void printArray(int[] arr) {
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }

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