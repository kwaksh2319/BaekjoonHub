import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
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
		Arrays.sort(coin);
		int dp[]=new int[k+1];
		for(int i=0;i<k+1;i++) {
			dp[i]=100001;
		}
		dp[0]=0;
		
		for(int i=0;i<n;i++) {
		
			for(int j=coin[i];j<=k;j++) {
				
			dp[j]=Math.min(dp[j], dp[j-coin[i]]+1);
			}
			
		}
		//System.out.println();
		if(dp[k] == 100001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
		//System.out.println(dp[k]);
	}
	
}