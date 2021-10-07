package luna.UVa;
/* Author: Luna
 * Date: 06-October-2021
 * Time: 17:02:39
 * Problem Link: 'https://www.spoj.com/problems/RPLN/',
*/
import java.util.*;
import java.io.*;
public class Negative_Score
{
    public static void build(int arr[], long segTree[], int start, int end, int treeIdx)
    {
        // base case
        if(start == end)
        {
            segTree[treeIdx] = arr[start];
            return;
        }
        int mid = (start + end)/2;

        build(arr, segTree, start, mid, 2*treeIdx);
        build(arr, segTree, mid+1, end, 2*treeIdx+1);

        segTree[treeIdx] = Math.min(segTree[2*treeIdx], segTree[2*treeIdx+1]);
    }

    public static void update(int arr[], long segTree[], int start, int end, int treeIdx, int idx, int val)
    {
        if(start == end)
        {
            arr[idx] += val;
            segTree[treeIdx] += val;
            return;
        }
        int mid = (start + end)/2;
        if(idx > mid)
        {
            update(arr, segTree, mid+1, end, 2*treeIdx + 1, idx, val);
        }
        else
        {
            update(arr, segTree, start, mid, 2*treeIdx, idx, val);
        }

        segTree[treeIdx] = Math.min(segTree[2*treeIdx], segTree[2*treeIdx+1]);
    }

    public static long query(long segTree[], int start, int end, int treeIdx, int left ,int right)
    {
        if(start > right || end < left)
        {
            // Complete outside
            return Integer.MAX_VALUE;
        }
        if(start>=left && end <=right)
        {
            // Complete inside
            return segTree[treeIdx];
        }
        int mid = (start + end)/2;
        long a1 = query(segTree, start, mid, 2*treeIdx, left, right);
        long a2 = query(segTree, mid+1, end, 2*treeIdx+1, left, right);
        
        return Math.min(a1, a2);
    }
    public static void main(String args[]) throws IOException
    {
        // FastScanner in = new FastScanner();
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int t_ = in.nextInt();
        for(int t = 1; t<=t_; t++)
        {
            int n = in.nextInt();
            int q = in.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = in.nextInt();
            }
            long segTree[] = new long[4*n];
            Arrays.fill(segTree, Integer.MAX_VALUE);
            build(arr, segTree, 0, n-1, 1);
            // for(int i=1; i<4*n; i++)
            // {
            //     System.out.println(i+"-->"+segTree[i]);
            // }
            out.printf("Scenario #%d:\n", t);
            while(q-->0)
            {
                int l = in.nextInt()-1;
                int r = in.nextInt()-1;
                long ans = query(segTree, 0, n-1, 1, l, r);
                out.println(ans);
            }

        }
        out.close();
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
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
}