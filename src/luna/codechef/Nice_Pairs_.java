package luna.codechef;
/* Author: Luna
 * Date: 12-October-2021
 * Time: 20:16:44
 * Problem Link: 'https://www.codechef.com/START15B/problems/NPAIRS',
*/
import java.util.*;
import java.io.*;
public class Nice_Pairs_
{
    public static void main(String args[]) throws IOException
    {
        try{
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while(t-->0)
            {
                int n = in.nextInt();
                String s = in.next();
    
                long ans = 0;
                HashMap<Integer, Integer> hm = new HashMap<>();
    
                for(int i=0; i<s.length(); i++)
                {
                    hm.put(s.charAt(i) - 48, hm.getOrDefault(s.charAt(i) - 48, 0) + 1);
                }
    
                
    
                for(int i=0;i<n;i++)
                {
                    for(int j=i+1;j<=i+9;j++)
                    {
                        if(j>=n)
                        {
                            break;
                        }
                        if(j - i == Math.abs(s.charAt(i) - s.charAt(j)))
                        {
                            ans++;
                        }
                    }
                }
                System.out.println(ans);
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}