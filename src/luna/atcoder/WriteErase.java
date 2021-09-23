package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc073/tasks/abc073_c
/*
  Author: Luna
  Date: 15/09/21
  Time: 5:14 PM
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class WriteErase {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++)
            {
                int a = in.nextInt();
                if(set.contains(a))
                {
                    set.remove(a);
                }
                else
                {
                    set.add(a);
                }
            }
            System.out.println(set.size());

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}