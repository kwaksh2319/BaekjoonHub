
import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	private int i;
	private int j;
	public Main() {
		
	}
	
	public Main(int i, int j) {
		this.i=i;
		this.j=j;
	}
	public int I() {
		return this.i;
	}
	public int J() {
		return this.j;
	}
	public void I(int i) {
		this.i=i;
	}
	public void J(int j) {
		this.j=j;
	}
	public static void Prints(boolean [][]bCheck,int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int myindex=bCheck[i][j] ? 1 : 0;
				System.out.print(myindex);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int [][]maps=new int[n][m];
		int [][]copymaps=new int[n][m];
		boolean [][]bVisisted=new boolean[n][m];
		boolean [][]copybVisisted=new boolean[n][m];
		Queue<Main> q=new LinkedList<>();
		int initcnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int tmp=scan.nextInt();
				maps[i][j]=tmp;
				copymaps[i][j]=tmp;
				if(tmp==1) {
					bVisisted[i][j]=true;
					copybVisisted[i][j]=true;
					initcnt++;
				}else {
					bVisisted[i][j]=false;
					copybVisisted[i][j]=false;
					
					
				}
				
			}
		}
		
		
		int diri[]= {1,-1,0,0};
		int dirj[]= {0,0,1,-1};
		int mins=n*m;
		int tcnt=0;
		while(true) {
			q.add(new Main(0,0));
			boolean binit=false;
			while(!q.isEmpty()) {
				Main start=q.peek();
				q.poll();
				
				for(int i=0;i<4;i++) {
					int tmpDiri=start.I() +diri[i];
					int tmpDirj=start.J() +dirj[i];
					if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=m) {
						continue;
					}
					if(bVisisted[tmpDiri][tmpDirj]==true) {
						if(maps[tmpDiri][tmpDirj]==1) {
							copymaps[tmpDiri][tmpDirj]=0;
							copybVisisted[tmpDiri][tmpDirj]=false;
							binit=true;
						}
						continue;
					}
					bVisisted[tmpDiri][tmpDirj]=true;
					q.add(new Main(tmpDiri,tmpDirj));
				}
				
				//Prints(bVisisted,n,m);
				
			}
			
			//Prints(copybVisisted,n,m);
			int gcnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					bVisisted[i][j]=copybVisisted[i][j];
					maps[i][j]=copymaps[i][j];
					if(maps[i][j]==1) {
						gcnt++;
					}
				}
			}
			
			if(binit==true) {
				tcnt++;
			}
			
			
			if(gcnt!=0) {
				mins=Math.min(gcnt, mins);
			}else {
				if(tcnt==1) {
					mins=initcnt;
				}
				break;
			}
			
			//bVisisted=copybVisisted;
			//maps=copymaps;
			//System.out.println();
		}
		System.out.println(tcnt);
		System.out.println(mins);
		
		
		
	}
}
