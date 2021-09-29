//package luna.cses;

// Problem Link: 
/*
  Author: Luna
  Date: 28/09/21
  Time: 4:34 PM
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class CompanyQueriesII {
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
            for(int i=0;i<=n;i++)
            {
                adj[i] = new ArrayList<>();
            }

            up[1][0] = 1;
            for (int i = 2; i <= n; i++) {
                up[i][0] = in.nextInt();
                adj[i].add(up[i][0]);
                adj[up[i][0]].add(i);
            }

            Stack<Integer> stack = new Stack<>();
            boolean visited[] = new boolean[n + 1];

            stack.push(1);
            while (stack.size() > 0) {
                int currNode = stack.pop();
                visited[currNode] = true;

                for (int i = 1; i <= LOG; i++) {
                        up[currNode][i] = up[up[currNode][i - 1]][i - 1];
                }

                for (int i : adj[currNode]) {
                    if (!visited[i]) {
                        depth[i] = depth[currNode] + 1;
                        stack.push(i);
                    }
                }
            }
//
//            for(int i=0;i<=n;i++)
//            {
//                out.print(i+"-->");
//                for(int j=0;j<=LOG;j++)
//                {
//                    out.print(up[i][j]+" ");
//                }
//                out.println();
//            }


            while (q-- > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                int a = u, b = v;

//                out.println(depth[u]+" "+depth[v]);
                if (depth[u] < depth[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
//                out.println(depth[u]+" "+depth[v]);
                int diff = depth[u] - depth[v];


//                System.out.println("Depth = "+diff);
                for (int i = LOG; i >= 0; i--) {
                    if ((diff & (1 << i)) > 0) {
//                        System.out.print(1);
                        u = up[u][i];
                    }
//                    else{
//                        System.out.print(0);
//                    }
                }
//                System.out.println();

                if (u == v) {
                    out.println(u);
                    continue;
                }

                for (int i = LOG; i >= 0; i--) {
                    if (up[u][i] != up[v][i]) {
                        u = up[u][i];
                        v = up[v][i];
                    }
                }
                out.println(up[u][0]);


            }

            out.println();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static int kthAncestor(int node, int k) {
        for (int d = LOG - 1; d >= 0; d--) {
            if ((k & (1 << d)) > 0) {
                node = up[node][d];
            }
            if (node == -1) {
                break;
            }
        }
        return node;
    }

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


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() {
            try {
                byte[] buf = new byte[10000000]; // line length
                int cnt = 0, c;
                while ((c = read()) != -1) {
                    if (c == '\n')
                        break;
                    buf[cnt++] = (byte) c;
                }
                return new String(buf, 0, cnt);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        public int nextInt() {
            int ret = 0;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                boolean neg = (c == '-');
                if (neg) c = read();
                do {
                    ret = ret * 10 + c - '0';
                } while ((c = read()) >= '0' && c <= '9');

                if (neg) return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        public long nextLong() {

            try {
                long ret = 0;
                byte c = read();
                while (c <= ' ') c = read();
                boolean neg = (c == '-');
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                }
                while ((c = read()) >= '0' && c <= '9');
                if (neg)
                    return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        public double nextDouble() {

            try {
                double ret = 0, div = 1;
                byte c = read();
                while (c <= ' ')
                    c = read();
                boolean neg = (c == '-');
                if (neg) c = read();

                do {
                    ret = ret * 10 + c - '0';
                }
                while ((c = read()) >= '0' && c <= '9');
                if (c == '.') {
                    while ((c = read()) >= '0' && c <= '9') {
                        ret += (c - '0') / (div *= 10);
                    }
                }

                if (neg) return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            try {
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}