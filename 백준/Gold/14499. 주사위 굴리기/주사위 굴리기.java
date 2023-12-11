
import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
	    ///크기 nxm 지도가 존재한다
		//지도의 오른쪽은 동쪽, 위쪼ㄱ은북쪽
		//주사위가 하나 놓여졋이다
		//지도의 좌표는  r,c로 나타나면 
		// r은 북쪽 c는 서쪽으로부터 떨어진갯수다
		//주사위는 지도 윗면이 1이고 동쪽을 바라보는 방향인 3인 상태로 놓여져잇으면
		//놓여져싱슨ㄴ 좌표는 x,y
		//가장 처음에 주사위에 모든 면에 0아더
		//지도의 각 칸에는 정수가 하나씩 쓰여져잇다.
		//주사위를 굴렷을떄, 이동한 칸에 쓰여 잇는 수가 0이면,
		//주사위의 바닥면에 쓰여잇는 수가 칸에 복사된다
		//0이 아닌 경우에는 칸에 쓰여잇는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여잇는 수
	    //0인된다
		//주사위는 지도 바깥으로 이동시킬수 없다
		//만약 바깥으로 이ㅏ동시키려고 하는 경우 명령을 무시해야하며 출력  x
		int []dice=new int[6];
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();
		int k=scan.nextInt();
		
		int [][]maps=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int r=scan.nextInt();
				maps[i][j]=r;
			}
			
		}
		
		for(int i=0;i<k;i++) {
			int command=scan.nextInt();
			int tmpx=0;
			int tmpy=0;
			if(command==1) {
				tmpx=x;
				tmpy=y+1;
			}else if(command==2) {
				tmpx=x;
				tmpy=y-1;
			}else if(command==3) {
				tmpx=x-1;
				tmpy=y;
			}else if(command==4) {
				tmpx=x+1;
				tmpy=y;
				
			}
			
			if(tmpx==-1||tmpy==-1||tmpx>=n||tmpy>=m) {
				continue;
			}
			
			
			
			
			if(command==1) {
				
				//동 3 ,5 0 0 0 7
				int tmp=dice[5];
				dice[5]=dice[2];
				dice[2]=dice[0];
				dice[0]=dice[3];
				dice[3]=tmp;
				
			}else if(command==2) {
				
				//서
				int tmp=dice[5];
				dice[5]=dice[3];
				dice[3]=dice[0];
				dice[0]=dice[2];
				dice[2]=tmp;
				
			}else if(command==3) {
				int tmp=dice[5];
				dice[5]=dice[1];
				dice[1]=dice[0];
				dice[0]=dice[4];
				dice[4]=tmp;
				
			}else if(command==4) {
	
				int tmp=dice[5];
				dice[5]=dice[4];
				dice[4]=dice[0];
				dice[0]=dice[1];
				dice[1]=tmp;
				
			}
			
			if(maps[tmpx][tmpy]!=0) {
				dice[5]=maps[tmpx][tmpy];
				maps[tmpx][tmpy]=0;
			}else {
				maps[tmpx][tmpy]=dice[5];
			}
			
			//System.out.println(tmpx+","+tmpy);
			//for(int j=0;j<6;j++) {
				System.out.println(dice[0]); //0,0,0,0,0,3,
			//}
			//System.out.println();
			
			
			x=tmpx;
			y=tmpy;
			
			
		}
		
		
		//지도의 각칸에는 정수
		//주사위를 굴렷을떄
		//이동한 칸에 있는수가 0이면 ->주사위 '바닥면'에 쓰여잇는칸 복사
		//0이 아닌 경우 -> 칸에 쓰여잇는수가->주사위 '바닥면'에 복사
		//명령이 주어ㅕㅈㅅ을떄
		//이동할때마다 상단에 쓰여잇는값을 구하라
		//(0,0)->4(남)-> 바닥면 6->0 
		/* 6 2
		 * 3 4
		 * 5 6 
		 * 7 8
		 * */
		//(1,0)->4(남)-> 바닥면
	}
}
