//package luna.usaco;

// Problem Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=572
/*
  Author: Luna
  Date: 29/09/21
  Time: 10:23 PM
 */

import java.io.*;
import java.util.StringTokenizer;

public class BreedCounting {
    public static void main(String args[]) throws IOException {
        try {
//            Reader in = new Reader();
//            PrintWriter out = new PrintWriter(System.out);
            BufferedReader read = new BufferedReader((new FileReader("bcount.in")));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
            StringTokenizer initial = new StringTokenizer(read.readLine());
            int n = Integer.parseInt(initial.nextToken());
            int q = Integer.parseInt(initial.nextToken());
            int a[] = new int[n+1];
            int b[] = new int[n+1];
            int c[] = new int[n+1];
            for (int i = 1; i <= n; i++) {
                int ele = Integer.parseInt(read.readLine());
                if (ele == 1) {
                    a[i] = 1;
                } else if (ele == 2) {
                    b[i] = 1;
                } else {
                    c[i] = 1;
                }
            }

            for (int i = 1; i <= n; i++) {
                    a[i] = a[i] + a[i - 1];
                    b[i] = b[i] + b[i - 1];
                    c[i] = c[i] + c[i - 1];
            }
            while (q-- > 0) {
                StringTokenizer query = new StringTokenizer(read.readLine());
                int l = Integer.parseInt(query.nextToken());
                int r = Integer.parseInt(query.nextToken());
                out.println((a[r] - a[l-1]) + " " + (b[r] - b[l-1]) + " " + (c[r] - c[l-1]));
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
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