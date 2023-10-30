import java.util.*;
import java.io.*;



public class Main {
	private int indexi;
	private int indexj;
	private int cnt;
	public Main() {
		
	}
	
	public Main(int indexi,int indexj,int cnt) {
		this.indexi=indexi;
		this.indexj=indexj;
		this.cnt=cnt;
	}
	public void Indexi(int indexi) {
		this.indexi=indexi;
		
	}
	public void Indexj(int indexj) {
		this.indexj=indexj;
	}
	public void cnt(int cnt) {
		this.cnt=cnt;
	}
	public int Indexi() {
		return this.indexi;
	}
	public int Indexj() {
		return this.indexj;
	}
	
	public int cnt() {
		return this.cnt;
	}
	
	public static void main(String[] args) throws Exception {
		//철수의 토마토 농장에서는 토마토를 보괂나다.
		//창고에 보관되는 토마토들중에서는 잘익은것도 잇지만 아직 익지 않는 토마토들도 있을수있다.
		//보관 후 하루가 자ㅣ나면 익은 토마토들의 인접한 곳에 있는 익지않는 토마토들이 영향을받아
		//좌우상하익는다/.
		//혼자 저절로 x 대각선 x
		//최소 일자를 알고싶다 알려다랄라
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();//6
		int m=scan.nextInt();//4
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
		ArrayList<ArrayList<Boolean>> bCheck=new ArrayList<>();
		Queue<Main> q=new LinkedList<>();
		for(int i=0;i<m;i++) {
			ArrayList<Integer>tmpLists=new ArrayList<>();
			ArrayList<Boolean>tmpBcheck=new ArrayList<>();
			for(int j=0;j<n;j++) {
				int tmp=scan.nextInt();
				tmpLists.add(tmp);
				if(tmp==1) {
					q.add(new Main(i,j,0));
				}
				
				if(tmp==0) {
					tmpBcheck.add(false);
				}else {
					tmpBcheck.add(true);
				}
				
			}
			lists.add(tmpLists);
			bCheck.add(tmpBcheck);
		}
		int diri[]= {0,0,1,-1};
		int dirj[]= {1,-1,0,0};
		int gcnt=0;
		int min=0;
		
		boolean bEnd=false;
		while(!q.isEmpty()) {
			Main start=q.peek();
			q.poll();
			
			int tmpi=start.Indexi();
			int tmpj=start.Indexj();
			int tmpcnt=start.cnt();
			bEnd=false;
			
			for(int i=0;i<4;i++) {
				
				int tmpDiri=tmpi+diri[i];
				int tmpDirj=tmpj+dirj[i];
				if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=m||tmpDirj>=n) {
					continue;	
				}
				
				if(bCheck.get(tmpDiri).get(tmpDirj)==true||lists.get(tmpDiri).get(tmpDirj)==-1) {
					continue;
				}
				bEnd=true;
				bCheck.get(tmpDiri).set(tmpDirj, true);
				q.add(new Main(tmpDiri,tmpDirj,tmpcnt+1));
				if(min<tmpcnt+1) {
					min=  tmpcnt+1;
				}
				
			}

		}
		
		boolean tEnd=false;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(bCheck.get(i).get(j)==false) {
					tEnd=true;
					i=m;
					j=n;
					continue;
				}
			}
		}
		
		if(tEnd==true) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}

}