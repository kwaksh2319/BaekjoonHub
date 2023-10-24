import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer> lists=new ArrayList<>();
	public static ArrayList<Boolean> bCheck=new ArrayList<>();
	public static int gdel=0;
	public static boolean bFind=false;
	public static int gcnt=0;
	public static void dfs(int k) {
		//boolean bFind=false;
		if(bFind==false) {
			bFind=true;
			gcnt++;
		}
		bCheck.set( k, true );
		for(int i=0;i<lists.size();i++) {
			
			if( lists.get(i) == k && bCheck.get(i)==false) {
				if(gdel != i ) {
					dfs(i);
				}
			}
		}
		
		bFind=false;
		return;
	}
	
	public static void main(String[] args) throws Exception {
	
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int start=0;
		for(int i=0;i<n;i++) {
			int tmp=scan.nextInt();
			lists.add(tmp);
			if(tmp==-1) {
				start=i;
			}
			bCheck.add(false);
		}
		int del=scan.nextInt();
		gdel=del;
		
		if(del==start) {
			System.out.println(0);
			//return 0;
		}else {
			dfs(start);

		System.out.println(gcnt);
		}
		
	}
}