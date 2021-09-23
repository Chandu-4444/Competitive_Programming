package luna.spoj;

// Problem Link: https://www.spoj.com/problems/BOOKS1/
/*
  Author: Luna
  Date: 22/09/21
  Time: 5:12 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CopyingBooks {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            while (t-- > 0) {
                int n = in.nextInt();
                int workers = in.nextInt();

                int pages[] = new int[n];

                long low = -1, high = 0;
                ArrayList<String> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    pages[i] = in.nextInt();
                    ans.add(Integer.toString(pages[i]));
                    high += pages[i];
                    low = Math.max(pages[i], low);
                }


                while (low < high) {
                    long middle = low + (high - low) / 2;

                    if (possible(pages, workers, middle, ans)) {
                        high = middle;
                    } else {
                        low = middle + 1;
                    }
                }

                Collections.reverse(ans);
//                System.out.println(high);
                printAns(pages, workers, high);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void printAns(int arr[], int w, long max) {
        long sum = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int count = 1;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(sum + arr[i] > max || i==w - count - 1)
            {
                sum = 0;
                ans.add(-1);
                count++;
            }
            sum = sum + arr[i];
            ans.add(arr[i]);
        }
        Collections.reverse(ans);

        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i)==-1)
            {
                System.out.print("/ ");
            }
            else{
                System.out.print(ans.get(i)+" ");
            }
        }
        System.out.println();



    }

    public static boolean possible(int arr[], int w, long middle, ArrayList<String> ans) {
        ans.clear();
        int curr = 1;
        long sum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > middle) {
                return false;
            }
            if (sum + arr[i] <= middle) {
                ans.add(Integer.toString(arr[i]));
                sum += arr[i];
            } else {
                ans.add("/");
                curr++;
                sum = arr[i];
                ans.add(Integer.toString(arr[i]));
            }
        }

        return curr <= w;
    }
}