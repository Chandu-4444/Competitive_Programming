package luna.d2;
/* Author: Luna
 * Date: 07-October-2021
 * Time: 21:15:37
 * Problem Link: 'https://codeforces.com/contest/88/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Keyboard
{
    public static void main(String args[]) throws IOException 
    {
        Reader in = new Reader();
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int symbols[] = new int[256];
        char board[][] = new char[n][m];
        int size = 0;
        for(int i=0; i<n;i++)
        {
            String s = in.readLine();
            for(int j=0;j<s.length();j++)
            {
                board[i][j] = s.charAt(j);
                symbols[board[i][j]] = 1;
                if(s.charAt(j)=='S')
                {
                    size++;
                }
            }
        }
        int shift[][] = new int[size][2];
        int index = 0;
        for(int i=0; i<n;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='S')
                {
                    shift[index][0] = i;
                    shift[index++][1] = j;
                }
            }
        }

            int q = in.nextInt();
            solve(in, board, symbols, shift, n, m, x);
        
    }

    private static void solve(Reader in, char[][] board, int[] symbols, int shift[][], int n, int m, int x) throws IOException {
        String s = in.readLine();
        int ans = 0;
        for(int p=0;p<s.length();p++)
        {
            if(s.charAt(p)>='A' && s.charAt(p)<='Z' && shift.length==0)
            {
                System.out.println("-1");
                return;
            }
            char currSym = (char)Character.toLowerCase(s.charAt(p));
            if(symbols[currSym]==0)
            {
                System.out.println("-1");
                return;
            }

            char currLetter = s.charAt(p);
            if(currLetter>='a' && currLetter<='z')
            {
                continue;
            }
            else
            {
                // Calculate nearest shift distance

                int minDist = Integer.MAX_VALUE;
                currLetter = Character.toLowerCase(s.charAt(p));
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<m;j++)
                    {
                        if(board[i][j]==currLetter)
                        {
                            for(int l=0;l<shift.length; l++)
                            {
                                minDist = Math.min(minDist, calcDist(i, j, shift[l][0], shift[l][1]));
                            }
                        }
                    }
                }
                if(minDist>x)
                {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static int calcDist(int i, int j, int k, int l) {
        return (int)Math.ceil(Math.sqrt((i-k)*(i-k) + (j-l)*(j-l)));
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