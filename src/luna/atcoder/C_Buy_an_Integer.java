package luna.atcoder;
import java.util.Scanner;
public class C_Buy_an_Integer
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long x = in.nextLong();

        // if(a>=x || b>=x)
        // {
        //     System.out.println(0);
        // }

        long low = 1, high = 1000000000;

        while(high - low>1)
        {
            long middle = low + (high - low)/2;
            if(possible(a, b, x, middle))
            {
                low = middle;
            }
            else{
                high = middle;
            }
        }

        if(possible(a, b, x, high))
        {
            System.out.println(high);
        }
        else if(possible(a, b, x, low))
        {
            System.out.println(low);
        }
        else{
            System.out.println(0);
        }

        in.close();
    }
    public static boolean possible(long a, long b, long x, long digit)
    {
        long cost = a * digit + b * (Long.toString(digit)).length();
        return cost <=x;
    }
}
