package luna.atcoder;
/* Author: Luna
 * Date: 03-October-2021
 * Time: 16:35:35
 * Problem Link: 'https://atcoder.jp/contests/abc082/tasks/arc087_a',
*/
import java.util.*;
import java.io.*;
public class C_Good_Sequence
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count[] = new int[1_00_000 + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int val = in.nextInt();
            hm.put(val, hm.getOrDefault(val, 0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> it: hm.entrySet())
        {
            if(it.getValue()>=it.getKey())
            {
                ans = ans + it.getValue() - it.getKey();
            }
            else
            {
                ans = ans + it.getValue();
            }
        }
        System.out.println(ans);
        in.close();
    }
}