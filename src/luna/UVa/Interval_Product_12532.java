package luna.UVa;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 17:41:45
 * Problem Link: 'https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3977',
*/
import java.util.*;
import java.io.*;
public class Interval_Product_12532
{
    public static void build(int arr[], long segTree[], int start, int end, int treeIdx)
    {
        // base case
        if(start == end)
        {
            if(arr[start]==0)
            {
                segTree[treeIdx] = 0;
            }
            else if(arr[start]<0)
            {
                segTree[treeIdx] = -1;
            }
            else
            {
                segTree[treeIdx] = 1;
            }
            return;
        }
        int mid = (start + end)/2;

        build(arr, segTree, start, mid, 2*treeIdx);
        build(arr, segTree, mid+1, end, 2*treeIdx+1);

        segTree[treeIdx] = segTree[2*treeIdx] * segTree[2*treeIdx+1];
    }

    public static void update(int arr[], long segTree[], int start, int end, int treeIdx, int idx, int val)
    {
        if(start == end)
        {
            arr[idx] = val;
            if(val==0)
            {
                segTree[treeIdx] = 0;
            }
            else if(val<0)
            {
                segTree[treeIdx] = -1;
            }
            else
            {
                segTree[treeIdx] = 1;
            }
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

        segTree[treeIdx] = segTree[2*treeIdx] * segTree[2*treeIdx+1];
    }

    public static long query(long segTree[], int start, int end, int treeIdx, int left ,int right)
    {
        if(start > right || end < left)
        {
            // Complete outside
            return 1;
        }
        if(start>=left && end <=right)
        {
            // Complete inside
            return segTree[treeIdx];
        }
        int mid = (start + end)/2;
        long a1 = query(segTree, start, mid, 2*treeIdx, left, right);
        long a2 = query(segTree, mid+1, end, 2*treeIdx+1, left, right);
        
        return (a1*a2);
    }
    public static void main(String args[]) throws IOException
    {
        // Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = in.readLine()) !=null && line.length()>0)
        {
            int n = Integer.parseInt(line.split("\\s")[0]);
            int q = Integer.parseInt(line.split("\\s")[1]);

            int arr[] = new int[n];
            String array[] = (in.readLine()).split("\\s");
            for(int i=0;i <n; i++)
            {
                arr[i] = Integer.parseInt(array[i]);
            }

            long segTree[] = new long[4*n];
            Arrays.fill(segTree, 1);
            build(arr, segTree, 0, n-1, 1);
            // for(int i=0; i<segTree.length; i++)
            // {
            //     System.out.println(i+"-->"+segTree[i]);
            // }
            while(q-->0)
            {
                String que[] = (in.readLine()).split("\\s");
                if(que[0].equals("C"))
                {
                    int idx = Integer.parseInt(que[1])-1;
                    int val = Integer.parseInt(que[2]);
                    update(arr, segTree, 0, n-1, 1, idx, val);
                }
                else if(que[0].equals("P"))
                {
                    int l = Integer.parseInt(que[1])-1;
                    int r = Integer.parseInt(que[2])-1;

                    long pro = query(segTree, 0, n-1, 1, l, r);
                    if(pro==0)
                    {
                        System.out.print("0");
                    }
                    else if(pro<0)
                    {
                        System.out.print("-");
                    }
                    else if(pro>0)
                    {
                        System.out.print("+");
                    }
                }

            }
            System.out.println();

        }

    }
}