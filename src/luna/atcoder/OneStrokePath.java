package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc054/tasks/abc054_c
/*
  Author: Luna
  Date: 13/09/21
  Time: 8:51 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OneStrokePath {
    static int ans = 0;
//    static boolean visited[] = new boolean[1000];

    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> graph[] = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                graph[x].add(y);
                graph[y].add(x);
            }

            boolean visited[] = new boolean[n];
            visited[0] = true;
            dfs(graph, 0, visited);
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void dfs(ArrayList<Integer> graph[], int src, boolean visited[]) {
        boolean visitesAll = true;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                visitesAll = false;
                break;
            }
        }

        if (visitesAll == true) {
            ans++;
            return;
        }

        for (int i : graph[src]) {
//            System.out.println(i);
            if (visited[i] == false) {
                visited[i] = true;
                dfs(graph, i, visited);
                visited[i] = false;

            }
        }
    }


}