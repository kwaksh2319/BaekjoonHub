import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	
		private int i;
		private int cnt;
		public Main(int i,int cnt) {
			this.i=i;
			this.cnt=cnt;
		}
		
		public void i(int i) {
			this.i=i;
		}
		
		
		public void cnt(int cnt) {
			this.cnt=cnt;
		}
		
		public int i() {
			return i;
		}
		
		
		public int cnt() {
			return cnt;
		}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		//뱀과 사다리 게이믈 즐겨하는 큐브러버
		//주사위를 조작해 내가 원하는 수가 나오게 만들수 있다면
		//최소 몇번만에 도착점에 도착할수 있을까?
		
		//게임은 정육면체 주사위를 사용하며, 주사위의 각면에는 1부터 6까지 수가 하나씩 적혀있다.
		//게임은 크기 10x10이고, 총 100개의 칸으로 나누어져 잇는 보드판에서 진행된다.
		//보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져있다.
		
		//플레이어는 주사위를 굴려나온 수만큼 이동해야한다.
		//예를들어, 플레이어가 i번칸에 잇고, 주사위를 굴려 나온수가 4라면 
		//i+4번 칸으로 이동해야한다.
		//주사위를 굴린 결과가 100번칸을 넘어간다면 이동할수 없다.
		//도착한 칸이 사다리면 사다리를 타고 위로 올라간다 
		//뱀이 있는 칸에 도착하면 뱀에 따라 내려간다 
		//즉 사다릴 이용해 이동한 칸의 번호는 원래 잇던 칸의 번호보다 크고,
		//뱀을 이용한 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다
		int []map=new int[101];
		boolean []bcheck=new boolean[101];
		int []snakemap=new int[101];
		int []sadarimap=new int[101];
		int cnt=1;
		
		
		int n=scan.nextInt(); //사디리수
		int m=scan.nextInt(); //뱀의수
		
		for(int i=1;i<=100;i++) {
			map[i]=cnt;
			cnt++;
			bcheck[i]=false;
	     }
		
		//사다리 x->y
		for(int i=0;i<n;i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			sadarimap[x]=y;
		}
		
		//뱀 u->v
		for(int i=0;i<m;i++) {
			int u=scan.nextInt();
			int v=scan.nextInt();
			snakemap[u]=v;
		}
		
		
		//목표 1->100 도착
		//주사위 1~6
		/*만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. */
		
		Queue<Main> q= new LinkedList<>();
		q.add(new Main(1,0));
		boolean bCheck=false;
		while(!q.isEmpty()) {
			Main start = q.peek();
			q.poll();
			if(bCheck==true) {
				break;
			}
			
			for(int i=1;i<=6;i++) {
			    int tmp=start.i()+i;
			    int cnts=start.cnt()+1;
			    if(tmp > 100) {
			    	
			    	continue;
			    	
			    }
			    if(tmp==100) {
			    	i=7;
			    	bCheck=true;
			    	System.out.println(cnts);
			    	continue;
			    }
			    
			    if(sadarimap[tmp]!=0) {
			    	int tmpsa=sadarimap[tmp];
			    	if(bcheck[tmpsa]==false) {
			    		bcheck[tmpsa]=true;
				    	q.add(new Main(tmpsa, cnts));
			    	}
			    	
			    	continue;
			    }
			    
			    if(snakemap[tmp]!=0) {
			    	int tmpsn=snakemap[tmp];
			    	if(bcheck[tmpsn]==false) {
			    	bcheck[tmpsn]=true;
			    	q.add(new Main(tmpsn,cnts));
			    	}
			    	continue;
			    }
			    
			    if(bcheck[tmp]==false) {
			    	bcheck[tmp]=true;
			    	q.add(new Main(tmp,cnts));
			    }
			}
		}
		
		
	}
}