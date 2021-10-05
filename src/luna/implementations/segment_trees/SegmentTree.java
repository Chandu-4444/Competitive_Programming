package luna.implementations.segment_trees;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 13:50:40
 * Problem Link: 'https://cp-algorithms.com/data_structures/segment_tree.html',
*/
import java.util.Scanner;
public class SegmentTree
{

    public static void build(int arr[], int segTree[], int start, int end, int treeIdx)
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

    public static void update(int arr[], int segTree[], int start, int end, int treeIdx, int idx, int val)
    {
        if(start == end)
        {
            arr[idx] = val;
            segTree[treeIdx] = val;
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

    public static int query(int segTree[], int start, int end, int treeIdx, int left ,int right)
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
        int a1 = query(segTree, start, mid, 2*treeIdx, left, right);
        int a2 = query(segTree, mid+1, end, 2*treeIdx+1, left, right);
        
        return (a1+a2);
    }


    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        int segTree[] = new int[4*(n)];
        build(arr, segTree, 0, n-1, 1);
        int q = in.nextInt();
        while(q-->0)
        {
            int type = in.nextInt();
            if(type==1)
            {
                int left = in.nextInt();
                int right = in.nextInt();
                System.out.println(query(segTree, 0, n-1, 1, left, right));
            }
            else
            {
                int idx = in.nextInt();
                int val = in.nextInt();
                update(arr, segTree, 0, n-1, 1, idx, val);
            }
        }
        in.close();
    }
}