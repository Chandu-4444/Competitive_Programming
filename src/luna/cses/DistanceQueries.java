package luna.cses;

// Problem Link: https://cses.fi/problemset/task/1135
/*
  Author: Luna
  Date: 28/09/21
  Time: 7:40 PM
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class DistanceQueries {
    static int LOG = 20;
    static int up[][] = new int[200000 + 1][LOG + 1];

    public static void main(String args[]) throws IOException {
        try {
            Reader in = new Reader();
            PrintWriter out = new PrintWriter(System.out);

            int n = in.nextInt();
            int q = in.nextInt();
            int depth[] = new int[n + 1];
            ArrayList<Integer> adj[] = new ArrayList[n + 1];
//            Arrays.setAll(adj, i -> new ArrayList<>());

            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            // Scanning n-1 edges
            adj[0].add(1);
            adj[1].add(0);
            for (int i = 1; i <= n - 1; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }


            // Run a BFS/DFS
            Stack<Integer> stack = new Stack<>();
            boolean visited[] = new boolean[n + 1];
            stack.push(0);
            depth[0] = 0;
            up[0][0] = 0;
            while (stack.size() > 0) {
                int currNode = stack.pop();
                visited[currNode] = true;

                for (int j = 1; j <= LOG; j++) {
                    up[currNode][j] = up[up[currNode][j - 1]][j - 1];
                }

                for (int i : adj[currNode]) {
                    
                    if (!visited[i]) {
                        depth[i] = depth[currNode] + 1;
                        up[i][0] = currNode;
                        stack.push(i);
                    }
                }
            }

            // Now, we need to find lca and calculate the distance for every node

            while (q-- > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                int l = lca(u, v, depth);

                int ans = depth[u] + depth[v] - 2 * depth[l];
                out.println(ans);


            }
            out.println();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static int lca(int u, int v, int depth[]) {
        if (depth[u] < depth[v]) {
            u = u ^ v;
            v = u ^ v;
            u = u ^ v;
        }

        int diff = depth[u] - depth[v];

        for (int j = LOG; j >= 0; j--) {
            if ((diff & (1 << j)) > 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    // <---------- Fast IO --------->
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}