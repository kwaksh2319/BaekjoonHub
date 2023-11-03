import java.util.*;
import java.lang.*;

public class Main {
	private int p;
	private int t;
	public Main() {
		
	}
	public Main(int t,int p) {
		
		this.t=t;
		this.p=p;
	}
	public void P(int p) {
		this.p=p;
	}
	public void T(int t) {
		this.t=t;
	}
	public int P() {
		return this.p;
	}
	public int T() {
		return this.t;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		ArrayList<Main>lists=new ArrayList<>();
		ArrayList<Integer>anw=new ArrayList<>();
		for(int i=0;i<n;i++) {
		   int t=scan.nextInt();
		   int p=scan.nextInt();
		  
		   lists.add(new Main(t,p));
		   anw.add(0);
		}
		anw.add(0);
		
		for(int i=n-1;i>=0;i--) {
			
			int day=lists.get(i).T()+i;
			
			if(day>n) {
				anw.set(i, anw.get(i+1));
				continue;
			}
				
				int lastPay=anw.get(day);
				int nowPay=lists.get(i).p;

				int totalPay=Math.max(anw.get(i+1),nowPay+lastPay);
				
				anw.set(i,totalPay);
			
			
		}
	
		Collections.sort(anw);
		System.out.println(anw.get(anw.size()-1));
	}
}