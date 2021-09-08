package luna.atcoder.dpcontest;
/*
  Author: Luna
  Date: 08/09/21
  Time: 10:20 AM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestPath {
    public static void main(String args[]) throws IOException {
        try {
            // Adjacency Matrix won't work!
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int M = in.nextInt();
            ArrayList<Integer> graph[] = new ArrayList[N];
//            int graph[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                graph[x].add(y);
//                graph[x][y] = 1;
            }

            int dp[] = new int[N + 1];
            boolean visited[] = new boolean[N];

            for (int i = 0; i < N; i++) {
                if (visited[i] == false) {
                    dfs(graph, i, dp, visited);
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
//                System.out.println(i+": "+dp[i]);
                ans = Math.max(ans, dp[i]);
            }

            System.out.println(ans);


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void dfs(ArrayList<Integer> graph[], int src, int[] dp, boolean[] visited) {
        visited[src] = true;

        for (int j = 0; j < graph[src].size(); j++) {
            if (visited[graph[src].get(j)] == false) {
                dfs(graph, graph[src].get(j), dp, visited);

            }
            // dp[src] = max(dp[src], 1+dp[child1], 1+dp[child2] .....)
            dp[src] = Math.max(dp[src], 1 + dp[graph[src].get(j)]);


        }
    }


}