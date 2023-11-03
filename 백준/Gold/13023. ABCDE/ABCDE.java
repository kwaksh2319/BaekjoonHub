import java.util.*;
import java.lang.*;

public class Main {
	public static int n;
	public static int m;
	public static ArrayList<ArrayList<Integer>>lists=new ArrayList<>();
	public static ArrayList<Boolean>bCheck=new ArrayList<>();
	public static ArrayList<Boolean>savebCheck=new ArrayList<>();
	public static boolean bEnd=false;
	public static void dfs(int k,int cnt) {
		//System.out.print(k);
		if(cnt==4) {
			bEnd=true;
			//System.out.println();
			return ;
		}
		
		
		for(int i=0;i<lists.get(k).size();i++) {
			int anw=lists.get(k).get(i);
			if(bCheck.get(anw)==false) {
				bCheck.set(anw,true);
				dfs(anw,cnt+1);
				bCheck.set(anw,false);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		 n=scan.nextInt();
		 m=scan.nextInt();
		//ArrayList<Integer>bcheck=ArrayLists<>();
		//ArrayList<ArrayList<Integer>>lists=new ArrayLists<>();
		 for(int i=0;i<n+1;i++) {
			 lists.add(new ArrayList<>());
			 bCheck.add(false);
			 savebCheck.add(false);
		 }
		 
		for(int i=0;i<m;i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			lists.get(x).add(y);
			lists.get(y).add(x);
		}
		
		for(int i=0;i<n;i++) {
			bCheck.set(i,true);
			dfs(i,0);
			bCheck.set(i,false);
			//Collections.copy(bCheck,savebCheck);
			if(bEnd==true) {
				i=n+1;
			}
			
		}
		
		if(bEnd==true) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}