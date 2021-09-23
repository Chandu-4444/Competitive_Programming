package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc072/tasks/arc082_a
/*
  Author: Luna
  Date: 15/09/21
  Time: 5:19 PM
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Together {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int aMinusOne = a-1;
                int aPlusOne = a+1;

                map.put(aMinusOne, map.getOrDefault(aMinusOne, 0)+1);
                map.put(a, map.getOrDefault(a, 0)+1);
                map.put(aPlusOne, map.getOrDefault(aPlusOne, 0)+1);
            }

            int ans = -1;
            for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
//                System.out.println(itr.getKey() + " " + itr.getValue());
                ans = Math.max(ans, itr.getValue());
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}