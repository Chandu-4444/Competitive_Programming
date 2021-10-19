/* Author: Luna
 * Date: 13-October-2021
 * Time: 20:22:14
 * Problem Link: 'https://codeforces.com/contest/1593/problem/B',
*/
import java.util.*;
import java.io.*;
public class B_Make_it_Divisible_by_25
{
    public static void main(String args[])
    {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            String s = in.next();
            long n = Long.parseLong(s);

            if(n%25==0)
            {
                System.out.println(0);
            }
            else
            {
                s = (new StringBuffer(s).reverse()).toString();
                ArrayList<Integer> ans = new ArrayList<Integer>();

                int first = 0, second = 0;

                boolean flag = false;
                for(int i=0; i<s.length(); i++)
                {
                    if(s.charAt(i)=='0')
                    {
                        first = i+1;
                        flag = true;
                        break;
                    }
                }

                if(flag)
                {
                    for(int i = first; i<s.length(); i++)
                    {
                        if(s.charAt(i)=='0' || s.charAt(i)=='5')
                        {
                            second = i+1;
                            flag = true;
                            break;
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }

                if(flag)
                {
                    ans.add((first - 1) + (second - first  - 1));
                }

                for(int i=0; i<s.length(); i++)
                {
                    if(s.charAt(i)=='5')
                    {
                        first = i+1;
                        flag = true;
                        break;
                    }
                    else
                    {
                        flag = false;
                    }
     
                }


                if(flag)
                {
                    for(int i = first; i<s.length(); i++)
                    {
                        if(s.charAt(i)=='2' || s.charAt(i)=='7')
                        {
                            second = i+1;
                            flag = true;
                            break;
                        }
                        else
                    {
                        flag = false;
                    }
                    }
                    
                }

                if(flag)
                {
                    ans.add((first - 1) + (second - first  - 1));
                }

                // System.out.println(ans);

                System.out.println(Collections.min(ans));


            }
        }
        in.close();
    }

}