import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {
	private int i;
	private int j;
	private int cnt=0;
	public Main() {
		
	}
	public Main(int i, int j,int cnt) {
		this.i=i;
		this.j=j;
		this.cnt=cnt;
	}
	public void I(int i) {
		this.i=i;
	}
	public int I() {
		return this.i;
	}
	public void J(int j) {
		this.j=j;
	}
	public int J() {
		return this.j;
	}
	public int CNT() {
		return this.cnt;
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		scan.nextLine();
		
		//ArrayList<ArrayList<Character>>maps=new ArrayList<>();
		char maps[][]=new char[n][m];
		boolean bCheck[][]=new boolean[n][m];
		boolean intbCheck[][]=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String tmp =scan.nextLine();
			//char tmpMaps[]=new char[m];
			//boolean tmpbCheck[]=new boolean[m];
		
			for(int j=0;j<tmp.length();j++) {
				char tmpc=tmp.charAt(j);
			//	tmpMaps[j]=tmpc;
				maps[i][j]=tmpc;
				if(tmpc=='W') {
					bCheck[i][j]=true;
					intbCheck[i][j]=true;
					
				}else {
					bCheck[i][j]=false;
					intbCheck[i][j]=false;
					
				}
			}
	
		}
		
		
		int diri[]= {1,-1,0,0};
		int dirj[]= {0,0,1,-1};
		Queue <Main> q=new LinkedList<>();
		
		int maxs=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int gcnt=0;
				if(maps[i][j]=='L'&&bCheck[i][j] == false) {
					q.add(new Main(i,j,0));
					bCheck[i][j]=true;
					while(!q.isEmpty()) {
						Main start=q.peek();
						q.poll();
						
						//System.out.println(gcnt);
						for(int z=0;z<4;z++) {
							int tmpDiri=start.I()+diri[z];
							int tmpDirj=start.J()+dirj[z];
							if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=m) {
								continue;
							}
							if(bCheck[tmpDiri][tmpDirj]==true) {
								
								continue;
							}
							gcnt=Math.max(gcnt, start.CNT()+1);
							q.add(new Main(tmpDiri,tmpDirj, start.CNT()+1 ));
							bCheck[tmpDiri][tmpDirj]=true;
							
							
						}
					}
				}
				//System.out.println(gcnt);
				maxs=Math.max(maxs, gcnt);
				for(int z=0;z<n;z++) {
					for(int t=0;t<m;t++) {
						if(intbCheck[z][t]==true) {
							bCheck[z][t]=true;
						}else {
							bCheck[z][t]=false;
						}
	
					}
				}
				
				//Collections.copy(bCheck,intbCheck );
				
				
			}
			
		}
		System.out.println(maxs);
		
		
	}
	
}