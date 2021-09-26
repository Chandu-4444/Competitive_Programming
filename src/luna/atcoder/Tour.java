package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc204/tasks/abc204_c
/*
  Author: Luna
  Date: 26/09/21
  Time: 9:08 PM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Tour {
    static long ans = 0;

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
            }

            dfsUtil(graph, n, m);

            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void dfsUtil(ArrayList<Integer>[] graph, int n, int m) {
        // Mark all the visitable nodes from each node, and count the total visited nodes for each node
        for (int i = 0; i < n; i++) {
            boolean visited[] = new boolean[n];
            dfs(i, graph, visited);
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    ans++;
                }
            }

        }
    }

    private static void dfs(int src, ArrayList<Integer>[] graph, boolean[] visited) {
        if (visited[src]) {
            return;
        }
        visited[src] = true;
        ListIterator<Integer> it = graph[src].listIterator();
        while (it.hasNext()) {
            int neighbor = it.next();
            dfs(neighbor, graph, visited);
        }
    }
}