package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 14:56:54
 * Problem Link: 'https://codeforces.com/contest/451/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Sort_the_Array
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int aSort[] = new int[n];
        for(int i=0; i<n;i++)
        {
            arr[i] = in.nextInt();
            aSort[i] = arr[i];
        }
        Arrays.sort(aSort);
        int l = -1, r = n;
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=aSort[i])
            {
                l = i;
                break;
            }
        }
        for(int i=n-1; i>=0;i--)
        {
            if(arr[i]!=aSort[i])
            {
                r = i;
                break;
            }
        }

        if(l==-1 && r==n)
        {
            System.out.println("yes");
            System.out.println("1 1");
        }
        else
        {
            reverse(arr, l, r);
            boolean ans = true;
            for(int i=0;i<n;i++)
            {
                if(arr[i]!=aSort[i])
                {
                    ans = false;
                    break;
                }
            }

            if(ans==false)
            {
                System.out.println("no");
            }
            else
            {
                System.out.println("yes");
                System.out.println((l+1)+" "+(r+1));
            }
        }

        in.close();
    }

    private static void reverse(int[] arr, int l, int r) {
        for(; l<=r;l++, r--)
        {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }
}