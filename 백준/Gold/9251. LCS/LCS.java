import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		String x=scan.nextLine();
		String y=scan.nextLine();
		int xsize=x.length();
		int ysize=y.length();
		int lists[][]=new int[ xsize+1 ][ ysize+1 ];
		
		for(int i=0;i<xsize+1;i++) {
			for(int j=0;j<ysize+1;j++) {
				lists[i][j]=0;
			}
		}
		
		for(int i=0;i<xsize+1;i++) {
			for(int j=0;j<ysize+1;j++) {
				if(i==0||j==0) {
					continue;
				}
				
				if(x.charAt(i-1)==y.charAt(j-1)) {
					lists[i][j]=lists[ i-1 ][ j-1 ]+1;
				}else {
					lists[i][j]=Math.max(lists[i-1][j], lists[i][j-1]);
				}
			}
		}
		
		System.out.print(lists[xsize][ysize]);
	}
}
