/* Author: Luna
 * Date: 30-September-2021
 * Time: 17:25:16
*/
package luna.atcoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class C_Green_Bin
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();

        long ans = 0;
        while(n-->0)
        {
            String s = in.next();
            char sArr[] = s.toCharArray();
            Arrays.sort(sArr);
            s = String.valueOf(sArr);
            if(hm.containsKey(s))
            {
                ans = ans + hm.get(s);
            }
            int currVal = hm.getOrDefault(s, 0);
            hm.put(s, currVal+1); 
        }
        System.out.println(ans);


        in.close();
    }
}