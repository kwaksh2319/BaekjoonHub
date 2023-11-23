import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	public static boolean [] bCheck=new boolean[10];
	public static void Prints(boolean [][]bCheck,int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int myindex=bCheck[i][j] ? 1 : 0;
				System.out.print(myindex);
			}
			System.out.println();
		}
	}
	
	public static boolean checkingDecimal(long num) {
		if (num <= 1) {
	        return false;
	    }
	    for (long i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void backtracking(String k,int cnt,int limit) {
		//
		long nk=Long.parseLong(k);
		if( checkingDecimal(nk)==false) {
			return ;
		}
		if(k.length() >= limit) {
			System.out.println(k);
			return ;
		}

		
		for(int i= 0 ;i<10;i++) {
			if(bCheck[i]==false) {
				//bCheck[i]=true;
			
				backtracking( k+Integer.toString(i), cnt+1, limit);
				//bCheck[i]=false;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
	     //7331 즉 모둔 수가 소수이다!
		//n
		int n=scan.nextInt();
		for(int i=0;i<10;i++) {
			backtracking(Integer.toString(i),0,n);
		}
	}
}