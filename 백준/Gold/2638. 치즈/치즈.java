import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	private int x;
	private int y;
	public Main() {
		
	}
	
	public Main(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int I() {
		return this.x;
	}
	public int J() {
		return this.y;
	}
	public void I(int x) {
		this.x=x;
	}
	public void J(int y) {
		this.y=y;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int diri[]= {1,-1,0,0};
		int dirj[]= {0,0,1,-1};
		int [][]maps=new int[n][m];
		int [][]copymaps=new int[n][m];
		boolean [][]bVisisted=new boolean[n][m];
		boolean [][]copybVisisted=new boolean[n][m];
		boolean [][]outer=new boolean[n][m];
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
				outer[i][j]=false;
				
			}
		}
		
		
		// 내부 외부 공기 분리
		
		int tcnt=0;
		while(true) {
			q.add(new Main(0,0));
			boolean binit=false;
			Queue<Main> block=new LinkedList<>();
			while(!q.isEmpty()) {
				Main start=q.peek();
				q.poll();
				
				for(int i=0;i<4;i++) {
					
					int tmpDiri=start.I() +diri[i];
					int tmpDirj=start.J() +dirj[i];
					if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=m) {
						continue;
					}

					if(maps[tmpDiri][tmpDirj]==0) {
						
						
					}
					
					if(maps[tmpDiri][tmpDirj]==1) {
						block.add(new Main(tmpDiri,tmpDirj));
	
					}
					
					if(bVisisted[tmpDiri][tmpDirj]==true) {
						
						continue;
					}
					
					if(maps[start.I()][start.J()]==0) {
						bVisisted[tmpDiri][tmpDirj]=true;
						outer[tmpDiri][tmpDirj]=true;
						q.add(new Main(tmpDiri,tmpDirj));
					}
					
					
					
				}
				
				
			}
			
			while(!block.isEmpty()) {
				Main start=block.peek();
				block.poll();
				int blackcnt=0;
				for(int i=0;i<4;i++) {
					int tmpDiri=start.I() +diri[i];
					int tmpDirj=start.J() +dirj[i];
					if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=m) {
						continue;
					}
					
					if(outer[tmpDiri][tmpDirj]==true) {
						
						blackcnt++;
					}
					
				}
				
				if(blackcnt>=2) {
					binit=true;
					copymaps[start.I()][start.J()]=0;
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					maps[i][j]=copymaps[i][j];
					outer[i][j]=false;
					if(maps[i][j]==0) {
						bVisisted[i][j] = false;
					}else {
						bVisisted[i][j] = true;
					}
					
				}
			}
			
			
			if(binit==true) {
				tcnt++;
			}else {
				break;
			}
		
		}
		System.out.println(tcnt);
		
	}
}