package luna.timus;
/* Author: Luna
 * Date: 05-October-2021
 * Time: 16:41:53
 * Problem Link: 'https://acm.timus.ru/problem.aspx?space=1&num=1639',
*/
import java.util.*;
import java.io.*;
public class Chocolate_2_1639
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if((n*m)%2==0)
        {
            System.out.println("[:=[first]");
        }
        else
        {
            System.out.println("[second]=:]");
        }
        in.close();
    }
}