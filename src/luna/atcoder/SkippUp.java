package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc167/tasks/abc167_c
/*
  Author: Luna
  Date: 29/09/21
  Time: 5:11 PM
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SkippUp {
    public static void main(String args[]) throws IOException {
        try {
            Reader in = new Reader();
            PrintWriter out = new PrintWriter(System.out);
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();

            int c[] = new int[n];
            int books[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
                for (int j = 0; j < m; j++) {
                    books[i][j] = in.nextInt();
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int maskR = 0; maskR <= 1 << n; maskR++) {
                int currSkills[] = new int[m];
                int cost = 0;
                Arrays.fill(currSkills, 0);

                for (int i = 0; i < n; i++) {
                    if (((maskR >> i) & 1) == 1) {
                        cost = cost + c[i];
                        for (int skill = 0; skill < m; skill++) {
                            currSkills[skill] = currSkills[skill] + books[i][skill];
                        }
                    }
                }

                boolean flag = true;

                for (int i = 0; i < m; i++) {
                    if (currSkills[i] < x) {
                        flag = false;
                        break;
                    }
                }

                if(flag)
                {
                    ans = Math.min(ans, cost);
                }
            }

            out.println(ans!=Integer.MAX_VALUE?ans:-1);


            out.println();
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