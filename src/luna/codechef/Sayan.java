package luna.codechef;
/*
  Author: Luna
  Date: 05/09/21
  Time: 9:22 AM
 */

import java.io.IOException;
import java.util.Scanner;

public class Sayan {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int m = in.nextInt();

                int box[][] = new int[n][n];

                for (int i = 0; i < m; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();

                    box[x - 1][y - 1] = 1;
                }

                int prefixSum[][] = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int currVal = box[i][j] == 1 ? 1 : 0;
                        if (i == 0 && j == 0) {
                            prefixSum[i][j] = currVal;
                        } else if (i == 0) {
                            prefixSum[i][j] += prefixSum[i][j - 1] + currVal;
                        } else if (j == 0) {
                            prefixSum[i][j] += prefixSum[i - 1][j] + currVal;
                        } else {
                            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + currVal - prefixSum[i - 1][j - 1];
                        }
                    }
                }
                int currBest = 0;
                int currAns = -1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
//                        System.out.printf("%4d",topLeft[i][j]);
                        int topLeftSum = prefixSum[i][j];
                        int topRightSum = prefixSum[i][n-1] - prefixSum[i][j];
                        int bottomLeftSum = prefixSum[n-1][j] - prefixSum[i][j];
                        int bottomRightSum = prefixSum[n-1][n-1] - prefixSum[i][j];

                        currBest = Math.min(topLeftSum, Math.min(topRightSum, Math.min(bottomLeftSum, bottomRightSum)));
                        currAns = Math.max(currAns, currBest);

                    }
//                    System.out.println();
                }
                System.out.println(currAns);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}