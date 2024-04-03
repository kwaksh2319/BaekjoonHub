
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static int maps[][];
	
	public static boolean bCheck[][];
	public static boolean bdir[];
	public static int n;
	public static int m;
	public static ArrayList<Camera>cameras=new ArrayList<>();
	public static class Camera{
		public int i;
		public int j;
		public int kind;
		public int dir=0;
		public Camera(int i,int j, int kind,int dir) {
			this.i=i;
			this.j=j;
			this.kind=kind;
			this.dir=dir;
		}
	}
	public static ArrayList<Integer>save=new ArrayList<>();
	
	
	
	
	public static void cameraSee(int ci,int cj,int dir) {
		dir=dir%4;
		switch(dir) {
			case 0:
				//n
				for(int i=0;i<n;i++) {
					ci=ci-1;
					if(ci < 0) {
						break;
					}
					
					if(bCheck[ci][cj]==true) {
						break;
					}
					if(maps[ci][cj]!=0) {
						continue;
					}
					maps[ci][cj]=9;
				}
				break;
			case 1:
				//e
				
				for(int i=0;i<m;i++) {
					cj=cj+1;
					
					if(cj > m -1) {
						break;
					}
					
					if(bCheck[ci][cj]==true) {
						break;
					}
					if(maps[ci][cj]!=0) {
						continue;
					}
					maps[ci][cj]=9;
				}
				break;
			case 2:
				//s
				for(int i=0;i<n;i++) {
					ci=ci+1;
					
					if(ci > n-1) {
						break;
					}
					
					if(bCheck[ci][cj]==true) {
						break;
					}
					if(maps[ci][cj]!=0) {
						continue;
					}
					maps[ci][cj]=9;
				}
				break;
			case 3:
				//w
				for(int i=0;i<m;i++) {
					cj=cj-1;
					if(cj < 0 ) {
						break;
					}
					
					if(bCheck[ci][cj]==true) {
						break;
					}
					if(maps[ci][cj]!=0) {
						continue;
					}
					maps[ci][cj]=9;
				}
				
				break;
				default:
					break;
		}
		
		
		
	}
	public static void Prints() {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				System.out.print(maps[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int mins=-1;
	public static void backtracking(int cnt) {
		
		if(cnt>=cameras.size()) {
			//Prints();
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(maps[i][j]==0) {
						sum++;
					}
				}	
			}
			
			if(mins==-1) {
				mins=sum;
			}else {
				mins=Math.min(sum,mins);
			}
			
			//System.out.println("find");
			return;
		}
		
		int initmaps[][] =new int[n][m];
		//System.out.println(cnt);
		//System.out.println(cameras.size());
		
		int ci=cameras.get(cnt).i;
		int cj=cameras.get(cnt).j;
		
		for(int d=0;d<4;d++) {
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					initmaps[i][j]=maps[i][j];
				}
			}
			
			int kind=cameras.get(cnt).kind;
			
			switch(kind) {
			//camera kinds
				case 1:
				//	System.out.println(ci+","+cj+","+d);
					cameraSee(ci,cj,d);
					break;
				case 2:
					cameraSee(ci,cj,d);
					cameraSee(ci,cj,d+2);
					break;
				case 3:
					cameraSee(ci,cj,d);
					cameraSee(ci,cj,d+1);
					break;
				case 4:
					cameraSee(ci,cj,d);
					
					cameraSee(ci,cj,d+1);
					cameraSee(ci,cj,d+3);
					break;
				case 5:
					cameraSee(ci,cj,d);
					cameraSee(ci,cj,d+1);
					cameraSee(ci,cj,d+2);
					cameraSee(ci,cj,d+3);
					break;
				default:
					break;
			}
			
			backtracking(cnt+1);
			
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					maps[i][j]=initmaps[i][j];
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n =scan.nextInt();
		m =scan.nextInt();
		
		maps=new int[n][m];
		bCheck=new boolean[n][m];
		bdir=new boolean[4];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int tmp=scan.nextInt();
				
				maps[i][j]=tmp;
				
				if(tmp==6) {
					bCheck[i][j]=true;
				}
				if(tmp!=0) {
					
					if(tmp!=6) {
						cameras.add(new Camera(i,j,tmp,-1));
					}
				}
			}
		}
		backtracking(0);
		
		System.out.println(mins);
		
		
		

	}
}
