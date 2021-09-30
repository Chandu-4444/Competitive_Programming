package luna.atcoder;
/* Author: Luna
 * Date: 30-September-2021
 * Time: 23:36:35
 * Problem Link: 'https://atcoder.jp/contests/abc082/tasks/abc082_b',
*/
import java.util.*;
import java.io.*;
public class B_Two_Anagrams
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();

        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i=0;i<t.length()/2;i++)
        {
            char temp = tArr[i];
            tArr[i] = tArr[t.length()-1-i];
            tArr[t.length()-1-i] = temp;
        }

        // System.out.println(String.valueOf(tArr));

        int i = 0, j = 0;
        while(i<s.length() && j<t.length())
        {
           if(sArr[i]>tArr[j])
            {
                System.out.println("No");
                return;
            }
            else if(sArr[i]<tArr[j]){
                System.out.println("Yes");
                return;
            }
            i++; j++;
        }
        if(s.length()>=t.length())
        {
            System.out.println("No");
            return;
        }
        else{
            System.out.println("Yes");
        }
        in.close();
    }
}