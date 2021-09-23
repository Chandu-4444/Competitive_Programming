package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc075/tasks/abc075_c
/*
  Author: Luna
  Date: 15/09/21
  Time: 4:38 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class Bridge {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            int graph[][] = new int[n][n];

            for (int i = 0; i < m; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                graph[x][y] = 1;
                graph[y][x] = 1;
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        graph[i][j] = 0;
                        graph[j][i] = 0;

                        boolean visited[] = new boolean[n];

                        for (int k = 0; k < n; k++) {
                            visited[k] = false;
                        }

                        dfs(graph, 0, visited);

                        boolean bridgeFound = false;

                        for (int k = 0; k < n; k++) {
                            if (!visited[k]) {
                                bridgeFound = true;
                                break;
                            }
                        }

                        if (bridgeFound) {
                            ans++;
                        }

                        graph[i][j] = 1;
                        graph[j][i] = 1;

                    }
                }
            }

            System.out.println(ans/2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int graph[][], int src, boolean visited[]) {
        visited[src] = true;

        for(int i=0;i<graph.length;i++)
        {
            if(graph[src][i]==1 && !visited[i])
            {
                dfs(graph, i, visited);
            }
        }

    }

}