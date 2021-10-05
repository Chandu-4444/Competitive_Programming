package luna.d2;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 17:12:25
 * Problem Link: 'https://codeforces.com/contest/88/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Chord
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String c[] = s.split("\\s");
        String notes[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
        int index[] = new int[12];

        for(int i=0; i<notes.length; i++)
        {
            if(notes[i].equals(c[0]) || notes[i].equals(c[1]) || notes[i].equals(c[2]))
            {
                index[i] = 1;
            }
        }

        for(int i=0;i<notes.length; i++)
        {
            if(index[i]==1)
            {
                if(index[(i+3)%12]==1 && index[(i+7)%12]==1)
                {
                    System.out.println("minor");
                    return;
                }
                else if(index[(i+4)%12]==1 && index[(i+7)%12]==1)
                {
                    System.out.println("major");
                    return;
                }
                
            }
        }
        System.out.println("strange");
        
        in.close();
    }
}