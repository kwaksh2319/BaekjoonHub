import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		int coin[]=new int[n];
		for(int i=0;i<n;i++) {
			int tmp=scan.nextInt();
			coin[i]=tmp;
		
		}
		int dp[]=new int[k+1];
		//1~10dp
		//초기값
		dp[0]=1;

		for(int i=0;i<n;i++) {
			//1,2,5 coin
			for(int j=coin[i];j<=k;j++) {
				dp[j]=dp[j]+dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
