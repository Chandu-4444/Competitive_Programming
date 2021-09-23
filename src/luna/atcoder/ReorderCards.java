package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc213/tasks/abc213_c
/*
  Author: Luna
  Date: 17/09/21
  Time: 10:45 AM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReorderCards {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            int rowCount = 0;
            int colCount = 0;
            int row[] = new int[n];
            int col[] = new int[n];

            for (int i = 0; i < n; i++) {
                row[i] = in.nextInt();
                col[i] = in.nextInt();
            }

            int rowOri[] = row.clone();
            int colOri[] = col.clone();

            Arrays.sort(row);
            Arrays.sort(col);

            int index = 1;
            HashMap<Integer, Integer> mapRow = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!mapRow.containsKey(row[i])) {
                    mapRow.put(row[i], index);
                    index++;
                }
            }

//            for (Map.Entry<Integer, Integer> itr: mapRow.entrySet())
//            {
//                System.out.println(itr.getKey()+"-->"+itr.getValue());
//            }

                index = 1;
            HashMap<Integer, Integer> mapCol = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!mapCol.containsKey(col[i])) {
                    mapCol.put(col[i], index);
                    index++;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(mapRow.get(rowOri[i]) + " " + mapCol.get(colOri[i]));
            }


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}