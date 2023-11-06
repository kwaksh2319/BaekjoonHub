import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	private int l;//층
	private int r;//세로
	private int c;//가로
	private int cnt;
	
	public Main() {
		
	}
	
	public Main(int l,int r,int c,int cnt) {
		this.l=l;
		this.r=r;
		this.c=c;
		this.cnt=cnt;
	}
	
	public void L(int l) {
		this.l=l;
	}
	
	public void R(int r) {
		this.r=r;
	}
	
	public void C(int c) {
		this.c=c;
	}
	
	public int L() {
		return this.l;
	}
	
	public int R() {
		return this.r;
	}
	
	public int C() {
		return this.c;
	}
	public int Cnt() {
		return this.cnt;
	}
	
	public static void main(String[] args) throws Exception {
		ArrayList<String>lists=new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
		//scan.nextLine(); // 개행 문자(엔터)를 소비하기 위해 필요함.
			
			if(L==0&&R==0&&C==0) { 
				break; 
				}
			char[][][] build = new char[L][R][C];
			boolean[][][] bCheck = new boolean[L][R][C];
			Queue<Main> q = new LinkedList<>();

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String tmp = br.readLine();
					// System.out.print( tmp);
					for (int z = 0; z <C; z++) { // C 대신 tmp.length()를 사용
						build[i][j][z] = tmp.charAt(z);
						// System.out.print(  build[i][j][z]);
						if (tmp.charAt(z) == 'S') {
							q.add(new Main(i, j, z, 0)); // 시작 위치
						}
		            
						if(tmp.charAt(z)=='#') {
							bCheck[i][j][z] = true;
						}
					}
				}
				br.readLine();
			}
	
			int dirl[]= {1,-1,0,0,0,0};
			int dirr[]= {0,0,1,-1,0,0};
			int dirc[]= {0,0,0,0,1,-1};
			boolean bend=false;
			int gcnt=0;
			while(!q.isEmpty()) {
				if(bend==true) {
					q.clear();
					break;
				}
			
				Main start=q.peek();
				q.poll();
			
				for(int i=0;i<6;i++) {
					int tmpDirl=start.L()+dirl[i];
					int tmpDirr=start.R()+dirr[i];
					int tmpDirc=start.C()+dirc[i];
					if(tmpDirl==-1||tmpDirr==-1||tmpDirc==-1||tmpDirl>=L||tmpDirr>=R||tmpDirc>=C) {
						continue;
					}
					if(bCheck[tmpDirl][tmpDirr][tmpDirc]==true) {
						continue;
					}
				
					if(build[tmpDirl][tmpDirr][tmpDirc]=='E') {
						bend=true;
						int d=start.Cnt()+1;
						String anw=Integer.toString(d);
						lists.add("Escaped in "+anw+" minute(s)." );
						//System.out.println(start.Cnt()+1);
						
						break;
					//break;
					}
				
				//System.out.println(start.Cnt()+1);
				
					q.add(new Main(tmpDirl,tmpDirr,tmpDirc, start.Cnt()+1 ));
					bCheck[tmpDirl][tmpDirr][tmpDirc] =true;
				}
			
				}
				if(bend==false) {
					lists.add("Trapped!");
				}
					//System.out.println("Trapped!");
				
				
		}
		
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i));
		}
	//	}
		
	}
}