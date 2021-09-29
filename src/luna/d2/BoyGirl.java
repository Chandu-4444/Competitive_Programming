package luna.d2;
/*
  Author: Luna
  Date: 28/08/21
  Time: 1:12 PM
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyGirl {
    public static void main(String args[]) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            Set<Character> set = new HashSet<Character>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            System.out.println((set.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!"));


        } catch (Exception e) {
            System.out.print(e);
            return;
        }
    }
}