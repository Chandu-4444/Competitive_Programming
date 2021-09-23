package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc210/tasks/abc210_c
/*
  Author: Luna
  Date: 17/09/21
  Time: 6:11 PM
 */

import java.util.*;
import java.io.IOException;

public class ColorfulCandies {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int c[] = new int[n];

            for(int i=0;i<n;i++)
            {
                c[i] = in.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0;i<k;i++)
            {
                map.put(c[i], map.getOrDefault(c[i], 0)+1);
            }

            int ans = map.size();

            for(int i=k;i<n;i++)
            {
                map.put(c[i], map.getOrDefault(c[i], 0)+1);

                int currCount = map.get(c[i-k]) - 1;

                map.put(c[i-k], currCount);

                if(map.get(c[i-k])==0)
                {
                    map.remove(c[i-k]);
                }

                ans = Math.max(ans, map.size());
            }

            System.out.println(ans);



        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int upperBound(int arr[], int element) {
        int low = 0, high = arr.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] >= element) {
            return low;
        }
        if (arr[high] >= element) {
            return high;
        }
        return -1;
    }

    public static int lowerBound(int arr[], int element) {
        int low = 0, high = arr.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (element < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (arr[high] <= element) {
            return high;
        }
        if (arr[low] <= element) {
            return low;
        }
        return -1;
    }

}