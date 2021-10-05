package luna.cses;

// Problem Link: https://cses.fi/problemset/task/1687
/*
  Author: Luna
  Date: 28/09/21
  Time: 11:36 AM
 */


import java.io.*;
import java.util.StringTokenizer;

public class CompanyQueriesI {
    static int LOG = 20;
    static int up[][] = new int[200000 + 1][LOG+1];

    public static void main(String args[]) throws IOException {
        try {
            Reader in = new Reader();
            PrintWriter out = new PrintWriter(System.out);
            int n = in.nextInt();
            int q = in.nextInt();
            up[1][0] = -1;
            for (int i = 2; i <= n; i++) {
                up[i][0] = in.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= LOG; j++) {
                    if (up[i][j - 1] != -1) {
                        up[i][j] = up[up[i][j - 1]][j - 1];
                    }
                    else{
                        up[i][j] = -1;
                    }
                }
            }
            while (q-->0) {
                int node = in.nextInt();
                int k = in.nextInt();

                int ans = kthAncestor(node, k);

                out.println(ans);
            }
            

            out.println();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static int kthAncestor(int node, int k)
    {
        for (int d = LOG - 1; d >= 0; d--) {
            if ((k & (1 << d)) > 0) {
                node = up[node][d];
            }
            if(node==-1)
            {
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

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
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

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
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

        public FastReader(String file_name) throws IOException{
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() {
            try{
                byte[] buf = new byte[10000000]; // line length
                int cnt = 0, c;
                while ((c = read()) != -1) {
                    if (c == '\n')
                        break;
                    buf[cnt++] = (byte) c;
                }
                return new String(buf, 0, cnt);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }

        public int nextInt()  {
            int ret = 0;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                boolean neg = (c == '-');
                if (neg) c = read();
                do{
                    ret = ret * 10 + c - '0';
                }  while ((c = read()) >= '0' && c <= '9');

                if (neg) return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        public long nextLong()   {

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

        public double nextDouble()  {

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

        private void fillBuffer() throws IOException{
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException  {
            try{
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            }catch(Exception e){
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