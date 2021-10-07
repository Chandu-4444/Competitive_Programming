package luna.spoj;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 15:26:26
 * Problem Link: 'https://www.spoj.com/problems/COURAGE/',
*/
import java.util.*;
import java.io.*;
public class Living_with_Courage
{
    public static void build(long arr[], long segTree[][], int start, int end, int treeIdx)
    {
        if(start==end)
        {
            segTree[treeIdx][0] = arr[start];
            segTree[treeIdx][1] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        build(arr, segTree, start, mid, 2*treeIdx+1);
        build(arr, segTree, mid+1, end, 2*treeIdx+2);

        segTree[treeIdx][0] = segTree[2*treeIdx+1][0] + segTree[2*treeIdx+2][0];
        segTree[treeIdx][1] = Math.min(segTree[2*treeIdx+1][1], segTree[2*treeIdx+2][1]);
    }

    public static void update(long arr[], long segTree[][], int start, int end, int treeIdx, int idx, int query, int val)
    {
        if(start==end)
        {
            if(query==0)
            {
                // Do addition operation i.e "GROW"
                arr[idx] += val;
                segTree[treeIdx][0] += val;
                segTree[treeIdx][1] += val;
                return;
            }
            else if(query==1)
            {
                // Do subtraction i.e "EAT"
                arr[idx]  = Math.max(0, arr[idx] - val);
                segTree[treeIdx][0] = Math.max(0, segTree[treeIdx][0] - val);
                segTree[treeIdx][1] = Math.max(0, segTree[treeIdx][0]);
                return;
            }
        }

        int mid = (start+end)/2;

        if(idx > mid)
        {
            update(arr, segTree, mid+1, end, 2*treeIdx + 2, idx, query, val);
        }
        else
        {
            update(arr, segTree, start, mid, 2*treeIdx+1, idx, query, val);
        }

        segTree[treeIdx][0] = segTree[2*treeIdx+1][0] + segTree[2*treeIdx+2][0];
        segTree[treeIdx][1] = Math.min(segTree[2*treeIdx+1][1], segTree[2*treeIdx+2][1]);

    }

    public static long[] query(long segTree[][], int start, int end, int treeIdx, int left ,int right)
    {
        if(start > right || end < left)
        {
            // Complete outside
            return (new long[]{0, Integer.MAX_VALUE});
        }
        if(start>=left && end <=right)
        {
            // Complete inside
            return (new long[]{segTree[treeIdx][0], segTree[treeIdx][1]});
        }
        int mid = (start + end)/2;
        long a1[] = query(segTree, start, mid, 2*treeIdx+1, left, right);
        long a2[] = query(segTree, mid+1, end, 2*treeIdx+2, left, right);
        
        return (new long[]{(a1[0]+a2[0]), (Math.min(a1[1], a2[1]))});
    }

    public static void main(String args[])
    {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        long arr[] = new long[n];
        for(int i=0; i<n;i++)
        {
            arr[i] = in.nextLong();
        }
        long segTree[][] = new long[4*n][2];
        for(int i=0; i<segTree.length; i++)
        {
            segTree[i][1] = Integer.MAX_VALUE;
        }
        build(arr, segTree, 0, n-1, 0);
        // System.out.println("****");
        // for(int i=0;i <segTree.length; i++)
        // {
        //     System.out.println(i+"-->"+segTree[i][0]+" "+segTree[i][1]);
        // }
        // System.out.println("****");
        int q = in.nextInt();

        while(q-->0)
        {
            // printArray(arr);
            String s = in.next();
            
            if(s.equals("COUNT"))
            {
                int l = in.nextInt();
                int r = in.nextInt();

                long ans[] = query(segTree, 0, n-1, 0, l, r);
                System.out.println(ans[0] - ans[1]);
            }
            else if(s.equals("EAT"))
            {
                int val = in.nextInt();
                int idx = in.nextInt();
                update(arr, segTree, 0, n-1, 0, idx, 1, val);
                // System.out.println("**EAT**");
                // for(int i=0;i <segTree.length; i++)
                // {
                //     System.out.println(i+"-->"+segTree[i][0]+" "+segTree[i][1]);
                // }
                // System.out.println("****");
            }
            else if(s.equals("GROW"))
            {
                int val = in.nextInt();
                int idx = in.nextInt();
                update(arr, segTree, 0, n-1, 0, idx, 0, val);
                // System.out.println("**GROW**");
                // for(int i=0;i <segTree.length; i++)
                // {
                //     System.out.println(i+"-->"+segTree[i][0]+" "+segTree[i][1]);
                // }
                // System.out.println("****");
            }
        }

        // in.close();
    }
    //     private static void printArray(long[] arr) {
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