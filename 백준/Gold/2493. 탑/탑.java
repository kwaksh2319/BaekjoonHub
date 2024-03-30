import java.util.*;
import java.io.*;

public class Main {
	public static class Tower{
		public long tower;
		public long index;
		public Tower(long tower,long index) {
			this.tower=tower;
			this.index=index;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		long tower[]=new long[n];
		long send[]=new long[n];
		
		StringTokenizer stmp=new StringTokenizer(bf.readLine()," ");
		Stack<Tower> stacks=new Stack<>();
		for(int i=0 ;i<n;i++) {
			tower[i] = Long.parseLong(stmp.nextToken());
			while(!stacks.isEmpty()) {
				if(tower[i]>stacks.peek().tower) {
					stacks.pop();
				}else {
					System.out.print(stacks.peek().index+" ");
					break;
				}
			}
			//9 5 7
			if(stacks.empty()){
	            System.out.print(0 + " ");
	        }
			stacks.push( new Tower (tower[i], i+1 ));
		}
		
		
	}
}