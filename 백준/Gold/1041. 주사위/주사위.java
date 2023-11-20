import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		long n=scan.nextLong();
		ArrayList<Long>dice=new ArrayList<>(); 
		for(int i=0;i<6;i++) {
			long tmp=scan.nextLong();
			dice.add(tmp);
		}
		//
		long minthreesum=dice.get(0)+dice.get(1)+dice.get(2);//a b c
		 minthreesum=Math.min(minthreesum,dice.get(0)+dice.get(1)+dice.get(3));//a  b d
		 minthreesum=Math.min(minthreesum,dice.get(0)+dice.get(2)+dice.get(4));//a  d e
		 minthreesum=Math.min(minthreesum,dice.get(0)+dice.get(3)+dice.get(4));//a  c e
		 
		 minthreesum=Math.min(minthreesum,dice.get(5)+dice.get(1)+dice.get(2));//b  d f
		 minthreesum=Math.min(minthreesum,dice.get(5)+dice.get(1)+dice.get(3));//b  c f
		 minthreesum=Math.min(minthreesum,dice.get(5)+dice.get(2)+dice.get(4));//d  e  f
		 minthreesum=Math.min(minthreesum,dice.get(5)+dice.get(3)+dice.get(4));//c  e  f
		
		 long mintwosum=dice.get(0)+dice.get(1);// a b
		 
		 mintwosum=Math.min(mintwosum,dice.get(0)+dice.get(2)); //a c
		 mintwosum=Math.min(mintwosum,dice.get(0)+dice.get(3)); //a d
		 mintwosum=Math.min(mintwosum,dice.get(0)+dice.get(4)); //a e
		 
		 mintwosum=Math.min(mintwosum,dice.get(5)+dice.get(1)); //f b
		 mintwosum=Math.min(mintwosum,dice.get(5)+dice.get(2)); //f c
		 mintwosum=Math.min(mintwosum,dice.get(5)+dice.get(3)); //f d
		 mintwosum=Math.min(mintwosum,dice.get(5)+dice.get(4)); //f e
		 
		 mintwosum=Math.min(mintwosum,dice.get(1)+dice.get(3)); //b d
		 mintwosum=Math.min(mintwosum,dice.get(1)+dice.get(2)); //b c
		 mintwosum=Math.min(mintwosum,dice.get(4)+dice.get(3)); //e d
		 mintwosum=Math.min(mintwosum,dice.get(4)+dice.get(2)); //e c
		 
		
		Collections.sort(dice);
		//1,2,3,4,5,6
		long sum=0;
		if(n==1) {
			for(int i=0;i<5;i++) {
				sum+=dice.get(i);
			}
		}else {
			
			//윗꼭지점
			//3개
			sum=sum+( minthreesum )*4;
			
			//바닥 꼭지점
			sum=sum+( mintwosum )*4;
			
			//totalsize=totalsize-8;
			
			
			long topsideline=8 * ( n-2 );
			long bottomline= 4 * ( n-2 );
			//윗변
			sum=sum+( mintwosum )*topsideline;
			//아랫변
			sum=sum+( dice.get(0) )*bottomline;
			
			//나머지
			
			long mod=(n-2)*(n-2)*5;
			sum=sum+( dice.get(0) )*mod;
			
			
		}
		System.out.println(sum);

	}
}