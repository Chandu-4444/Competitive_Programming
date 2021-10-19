/* Author: Luna
 * Date: 17-October-2021
 * Time: 15:28:49
 * Problem Link: 'https://www.codechef.com/SNCKQL21/problems/TESTSERIES',
*/
import java.util.*;
import java.io.*;
public class Test_Match_Series
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int arr[] = new int[3];
            for(int i=0; i<5; i++)
            {
                arr[in.nextInt()]++;
            }
            
            if(arr[1]==arr[2])
            {
                System.out.println("DRAW");
            }
            else if(arr[1]>arr[2])
            {
                System.out.println("INDIA");
            }
            else
            {
                System.out.println("ENGLAND");
            }

        }
        in.close();
    }
}