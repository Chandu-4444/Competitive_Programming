package luna.atcoder;

// Problem Link: https://atcoder.jp/contests/abc199/tasks/abc199_c
/*
  Author: Luna
  Date: 14/09/21
  Time: 8:56 PM
 */

import java.io.IOException;
import java.util.Scanner;

public class IPFL {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String s = in.next();
            int q = in.nextInt();
            n = s.length();
            boolean flip = false;
            char sArr[] = s.toCharArray();

            for (int i = 0; i < q; i++) {
                int t = in.nextInt();
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
//                System.out.println(s);


                if (t == 2) {
                    flip = flip==true?false:true;
                }
                if (t == 1) {
                    char ca;
                    char cb;
                    if(flip==true)
                    {
                        if(a<n/2)
                        {
                            a = n/2 + a;
                        }
                        else{
                            a = a - n/2;
                        }

                        if(b>=n/2)
                        {
                            b = b - n/2;
                        }
                        else{
                            b = b + n/2;
                        }


                    }

                    ca = sArr[a];
                    cb = sArr[b];



                    sArr[a] = cb;
                    sArr[b] = ca;


                }
            }

            s = new String(sArr);
            if(flip)
            {
                s = s.substring(n/2) + s.substring(0, n/2);
            }

            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}