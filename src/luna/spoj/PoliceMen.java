package luna.spoj;

// Problem Link: https://www.spoj.com/problems/POLICEMEN/
/*
  Author: Luna
  Date: 29/09/21
  Time: 6:03 PM
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PoliceMen {
    static ArrayList<Integer> adj[];
    static int depth[];
    static int up[][];
    static int LOG = 20;
    public static void main(String args[]) throws IOException {
        try {
//            Reader in = new Reader();
//            PrintWriter out = new PrintWriter(System.out);
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            depth = new int[n];
            up = new int[n][LOG];
            adj = new ArrayList[n];
            for(int i=0;i<n;i++)
            {
                adj[i] = new ArrayList<>();
            }

            for(int i=0;i<n-1;i++)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                adj[x].add(y);
                adj[y].add(x);
            }

            // Run a DFS/BFS and update up, depth
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            depth[0] = 0;
            up[0][0] = 0;
            while (stack.size()>0)
            {
                int currNode = stack.pop();
                for (int i = 1; i < LOG; i++) {
                    up[currNode][i] = up[up[currNode][i - 1]][i - 1];
                }

                for(int i: adj[currNode])
                {
                    if(i!=up[currNode][0])
                    {
                        depth[i] = depth[currNode] + 1;
                        up[i][0] = currNode;
                        stack.add(i);
                    }
                }
            }

//            for(int i: depth)
//            {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//            for(int i=0;i<n;i++)
//            {
//                System.out.print((i+1)+"-->");
//                for(int j=0;j<LOG;j++)
//                {
//                    System.out.print(up[i][j]+" ");
//                }
//                System.out.println();
//            }

            // Process the queries, find the least distance to root
            int q = in.nextInt();
            while(q-->0)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;

                int distThief = depth[x] - depth[0];
                int distPolice = depth[y] - depth[0];

                if(distPolice>distThief)
                {
                    System.out.println("NO");
                }
                else{
                    int l = lca(x, y);
                    System.out.println("YES "+(l+1));

                }
            }




//            out.println();
//            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static int lca(int u, int v)
    {
        if(depth[u]<depth[v])
        {
            int temp = u;
            u = v;
            v = u;
        }

        int diff = depth[u] - depth[v];

        for(int i=0;i<LOG;i++)
        {
            if(((diff>>i)&1)==1)
            {
                u = up[u][i];
            }
        }
        if(u==v)
        {
            return u;
        }

        for(int i=LOG-1;i>=0;i--)
        {
            if(up[u][i]!=up[v][i])
            {
                u = up[u][i];
                v = up[v][i];
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