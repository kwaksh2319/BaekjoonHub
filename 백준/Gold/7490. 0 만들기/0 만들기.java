

import java.util.*;
import java.io.*;
public class Main {
	public static int n;
	public static int lists[];
	public static boolean bCheck[];
	public static ArrayList<String>ganws=new ArrayList<>();
	public static void backtracking(int start, int cnt, String anw){
		if(cnt>=n){
			ArrayList<Character>c=new ArrayList<>();
			ArrayList<Integer>num=new ArrayList<>();
			for(int i=0;i<anw.length();i++){
				if(anw.charAt(i)=='+'||anw.charAt(i)=='-'){
					c.add(anw.charAt(i));
				}else if(anw.charAt(i)==' '){
					int tmp=num.get(num.size()-1);
					num.remove(num.size()-1);
					String stmp=Integer.toString(tmp);
					i++;
					stmp+=anw.charAt(i);
					num.add( Integer.parseInt(stmp) );
				}else{
					num.add(anw.charAt(i)-'0');
				}
			}
			int merge=0;
			merge=num.get(0);
			for(int i=0;i<c.size();i++){
				if(c.get(i)=='+'){
					merge+=num.get(i+1);
				}else if(c.get(i)=='-'){
					merge-=num.get(i+1);
				}

			}
			if(merge==0){
				ganws.add(anw);
			}
			return;
		}

		for(int i=start;i<n;i++) {
			if (bCheck[i] == false) {
				bCheck[i]=true;
				String tmp=Integer.toString(lists[i]);
				backtracking(i,cnt + 1, anw+'+'+tmp);
				backtracking(i,cnt + 1, anw+'-'+tmp);
				backtracking(i, cnt + 1,anw+' '+tmp);
				bCheck[i]=false;
			}
		}
		return ;
	}

	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		int T =scan.nextInt();
		for(int t=0;t<T;t++){
			n=scan.nextInt();
			lists=new int[n];
			bCheck=new boolean[n];

			for(int i=0;i<n;i++){
				lists[i]=i+1;
			}

			bCheck[0]=true;
			String tmp=Integer.toString(lists[0]);
			backtracking(0,1,tmp);
			bCheck[0]=false;

			//sorting
			Collections.sort(ganws);
			for(int i=0;i<ganws.size();i++){
				System.out.println(ganws.get(i));
			}

			ganws.clear();
			System.out.println();
		}
	}
}