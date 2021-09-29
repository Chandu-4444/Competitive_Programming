package luna.d2;
/*
  Author: Luna
  Date: 08/09/21
  Time: 8:22 PM
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ChessCompetition {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            while (t-- > 0) {
                int n = in.nextInt();
                String s = in.next();
                int members[] = new int[n];
                int ones = 0, twos = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        ones++;
                    } else {
                        twos++;
                    }
                }
                if (twos == 0) {
                    System.out.println("YES");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j) {
                                System.out.print("X");
                            } else {
                                System.out.print("=");
                            }
                        }
                        System.out.println();
                    }
                } else {
                    int totalBoxes = n * n;
                    int diagonal = n;
                    int onesDeduction = ones * (n - 1) * 2;
                    int rem = totalBoxes - diagonal - onesDeduction;
                    if (twos * 2 > rem) {
                        System.out.println("NO");
                        continue;
                    }
                    System.out.println("YES");
                    char ans[][] = new char[n][n];
                    int won[] = new int[n];
                    for (int i = 0; i < n; i++) {
                        Arrays.fill(ans[i], ' ');
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (ans[i][j] == ' ') {
                                if (i == j) {
                                    ans[i][j] = 'X';
                                } else if (s.charAt(i) == '1') {
//                                System.out.print("=");
                                    ans[i][j] = '=';
                                    ans[j][i] = '=';
                                } else {
                                    if (won[i] == 0 && s.charAt(j) != '1') {
                                        ans[i][j] = '+';
                                        ans[j][i] = '-';
                                        won[i] = 1;

                                    } else if (won[i] == 1 && s.charAt(j) != '1' && won[j] != 1) {
                                        ans[i][j] = '-';
                                        ans[j][i] = '+';
                                        won[j] = 1;
                                    }

                                }
                            }

                        }
                    }

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(ans[i][j]);
                        }
                        System.out.println();
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}