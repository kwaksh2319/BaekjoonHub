import java.util.*;
import java.io.*;

public class Main {
	public static ArrayList<Integer> lists=new ArrayList<>();
	public static ArrayList<Integer> anw=new ArrayList<>();
	public static ArrayList<Boolean> bCheck=new ArrayList<>();
	public static int n=0;
	public static int gcnt=0;
	public static HashMap<Integer,Integer> maps=new HashMap<>();
	public static ArrayList<Integer> save=new ArrayList<>();
	public static void dfs(int target,int k) {
		//System.out.print(k);
		
		
		//System.out.print(k+",");
		if(bCheck.get( lists.get(k) )==false) {
			
			bCheck.set(lists.get(k), true);
		   
			dfs(target,lists.get(k));
			bCheck.set(lists.get(k), false);
			//System.out.println(save);
			
			
		}
		
		if(bCheck.get(k)==true) {
			if(target==k) {
				gcnt++;
				anw.add(target);
				
				//System.out.println(k);
			//	System.out.println();
				return ;
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		//세로 두줄 카로로 n개으로 이루어진 표가 있다.
		//첫째줄의 각칸에는 1,2,...n 이 차례 대로 들어 있고 
		//둘째 칸에는 1아ㅣ상 n이하 정수가 들어 있다.
		//첫쨰줄에서 숫자를 적절히 뽑으면 , 그 뽑힌 정수들이 이루는 집하과 뽑힌 정수들의 바로 밑의 둘쨰 줄에 들어 있는 정수들이 이루는 
		//집합이 일치한다.
		//이러한 조건을 만족시키도록 정수들을 뽑되 최대로 많이 뽑는 방법을 찾아라
		Scanner scan=new Scanner(System.in);
		 n=scan.nextInt();
		lists.add(-1);
		bCheck.add(true);
		for(int i=0;i<n;i++) {
			int tmp=scan.nextInt();
			lists.add(tmp);
			bCheck.add(false);
		}
		
		for(int i=1;i<=n;i++) {
			
				dfs(i,i);
			
		}
		Collections.sort(anw);
		System.out.println(anw.size());
		if(anw.size()!=0) {
			
			 for(int i = 0; i < anw.size(); i++) {
		            System.out.println(anw.get(i));
		     }
		}
		
		
	}
}