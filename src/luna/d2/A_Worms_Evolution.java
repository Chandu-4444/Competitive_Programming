package luna.d2;
/* Author: Luna
 * Date: 04-October-2021
 * Time: 17:00:30
 * Problem Link: 'https://codeforces.com/contest/31/problem/A',
*/
import java.util.*;
import java.io.*;
public class A_Worms_Evolution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
 
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) a[i] = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) if(j != i) {
				for(int k = 0; k < n; k++) if(k != j && k != i) {
					if(a[j]+a[k] == a[i]) {
						System.out.println((i+1) + " " + (j+1) + " " + (k+1));
						return;
					}
				}
			}
		}
		System.out.println(-1);
        in.close();
    }
}