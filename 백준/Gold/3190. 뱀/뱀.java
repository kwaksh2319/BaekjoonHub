import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	static class Snake{
		private int i;
		private int j;
		private int d;
		public Snake(int i,int j,int d) {
			this.i=i;
			this.j=j;
			this.d=d;
		}
		public void i(int i) {
			this.i=i;
		}
		public void j(int j) {
			this.j=j;
		}
		public void d(int d) {
			this.d=d;
		}
		public int i() {
			return i;
		}
		public int j() {
			return j;
		}
		public int d() {
			return d;
		}
	
	}
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int [][]maps=new int [n+1][n+1];
		boolean [][]bcheck=new boolean [n+1][n+1];
		//먼저 뱀이 몸길이를 늘려 머리를 다음칸에 위치시킨다
		//만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다
		//만약 이동한 칸에 사과가 잇다면 그칸에 잇던 사과가 없어지고 꼬리는 움직이지 않는다
		//만약에 이동칸에 사과가 없다면 몸길이를 줄여서 꼬리가 위치칸을 비워준다 즉 몸길이는 변하지 않는다
		//사과의 위치와 뱀의 이동 경로가 주어질 때 이게임이 몇초에 끝나는지  계산하여라 
		int k=scan.nextInt();
		
		
		
		for(int i=0;i<k;i++) {
			int x,y;
			x=scan.nextInt();
			y=scan.nextInt();
			maps[x][y]=1;
			
		}
		//0 오른쪽 1 아래 2 왼쪽 3 위 
		Snake snake=new Snake(1,1,0);
		Snake tail=new Snake(1,1,0);
		Deque<Snake>dq=new LinkedList<>();
		
		 dq.add(new Snake(1,1,0));
		
		bcheck[1][1]=true;
		//l 왼쪽 90도
		//d 오른쪽 90도
		int diri[]= {0,1,0,-1};
		int dirj[]= {1,0,-1,0};
		int l=scan.nextInt();
		int sec=0;
		int prev=0;
		int x=0;
		boolean bEnd=false;
		for(int i=0;i<l;i++) {
			int tmpx=scan.nextInt();
			char c=scan.next().charAt(0);
			
			 x=tmpx-prev;
			 prev=tmpx;
			 int dir=snake.d();
			// System.out.println();
		     for(int j=0;j<x;j++) {
		    	 
				 int tmpDiri=diri[dir]+snake.i();
				 int tmpDirj=dirj[dir]+snake.j();
				// System.out.println(snake.i()+","+snake.j()+","+snake.d());
				
				 if(tmpDiri==0||tmpDirj==0||tmpDiri>=n+1||tmpDirj>=n+1) {
					 //벽
					 i=l+1;
					 sec++;
					 bEnd=true;
					 break;
				 }
				 
				 if( bcheck[tmpDiri][tmpDirj]==true) {
					 //뱀 몸
					 bEnd=true;
					 sec++;
					 i=l+1;
					 break;
				 }
				 
				 //apple?
				
				 if(maps[ tmpDiri ][ tmpDirj ]==1) {
					 
					 maps[tmpDiri][tmpDirj]=0;//eating apple
					 bcheck[tmpDiri][tmpDirj]=true;
					
					 snake.i(tmpDiri);
					 snake.j(tmpDirj);
					 dq.add(new Snake(tmpDiri,tmpDirj,0));
				 }else {
					//not apple
					 
					 Snake tmpTail=dq.getFirst();
					 dq.poll();
					 int taili=tmpTail.i();
					 int tailj=tmpTail.j();
					
					
					 //System.out.println();
					 bcheck[ taili ][ tailj ]=false;
					 bcheck[tmpDiri][tmpDirj]=true;
					
					 snake.i(tmpDiri);
					 snake.j(tmpDirj);
					 dq.add(new Snake(tmpDiri,tmpDirj,0));
				 }
				//moving
				
				 
				 
				 sec++;
				 
				
		     }
		     
		     if(c=='L') {
		    	 dir=dir-1;
		    	 if(dir<0) {
		    		 dir=3;
		    	 }
		    	 
		     }else if(c=='D') {
		    	 dir=dir+1;
		    	 dir=dir%4;
		     }
		     snake.d(dir);
		   
			
		}
		// System.out.println(snake.i()+","+snake.j()+","+snake.d());
		 if(bEnd==false) {
			 while(true) {
					int dir=snake.d();
				    int tmpDiri=diri[dir]+snake.i();
				    int tmpDirj=dirj[dir]+snake.j();
				    if(tmpDiri==0||tmpDirj==0||tmpDiri>=n+1||tmpDirj>=n+1) {
						 //벽
						 sec++;
						 break;
					 }
				    if( bcheck[tmpDiri][tmpDirj]==true) {
						 //뱀 몸
						 sec++;
						 break;
					 }
				     Snake tmpTail=dq.peekFirst();
					 dq.pollFirst();
					 int taili=tmpTail.i();
					 int tailj=tmpTail.j();
					 bcheck[ taili ][ tailj ]=false;
				     bcheck[tmpDiri][tmpDirj]=true;
				     snake.i(tmpDiri);
					 snake.j(tmpDirj);
					  dq.add(snake);
					 sec++;
				}
		 }
		
		System.out.print(sec);
	}
}
