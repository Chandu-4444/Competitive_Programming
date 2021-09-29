package luna.d2;

// Problem Link: https://codeforces.com/contest/1579/problem/B
/*
  Author: Luna
  Date: 29/09/21
  Time: 11:03 AM
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShiftingSort {
    public static void main(String args[]) throws IOException {
        try {
//            Reader in = new Reader();
//            PrintWriter out = new PrintWriter(System.out);

            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int a[] = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    a[i] = in.nextInt();
                }

                int aSort[] = a.clone();
                int aCopy[] = a.clone();

                Arrays.sort(aSort);

                int k = 0;

                HashMap<Integer, Integer> map = new HashMap<>();

                for (int i = 1; i <= n; i++) {
                    int min = Integer.MAX_VALUE, mi = i;
                    for (int j = i; j <= n; j++) {
                        if (a[j] < min) {
                            min = a[j];
                            mi = j;
                        }
                    }

                    if (mi != i) {
                        map.put(i, i+mi);
                        for(int j = mi-1; j>=i;j--)
                        {
                            int temp = a[j];
                            a[j + 1] = a[j];
                            a[j] = temp;
                        }
                    }

                }

                System.out.println(map.size());
                for(Map.Entry<Integer, Integer> it: map.entrySet())
                {
                    int i = it.getKey();
                    int j = it.getValue() - i;

                    System.out.println(i+" "+j+" "+(j-i));
                }


            }

//            out.println();
//            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static void printArray(int a[], int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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