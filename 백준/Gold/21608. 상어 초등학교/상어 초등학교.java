
import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	private int likeCount=0;
	private int blankCount=0;
	public Main() {
		
	}
	
	public Main(int likeCount,int blankCount) {
		this.likeCount=likeCount;
		this.blankCount=blankCount;
	}
	
	public void likeCount(int likeCount) {
		this.likeCount=likeCount;
	}
	public int likeCount() {
		return this.likeCount;
	}
	
	public void blankCount(int blankCount) {
		this.blankCount=blankCount;
	}
	public int blankCount() {
		return this.blankCount;
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
		//상어 초등학교에는 교실이 하나 있고 교실은 nxn 크기의 격자로 나타낼수 잇다
		//학교에는 n^2명 이다
		//모든 학생의 자리를 정하는 날이다
		//11, -> nn
		//선생이 학생의 순서를 정하고 => 학생이 좋아하는 학생 4명도 모두 조사햇다
		//이제 다음과 같은 규칙을 이용해 정해진 순서대로 학생의 자를 정하려한다.
		//한칸에는 학생 한명의 자리만 잇을수 잇고 r1-r2 + c1-c2 =1 을 만족하는 두칸이 r1,c1 r2,c2 를 인접한다
		
		//1 비어있는 칸중에서 좋아한느 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다
		//2.1을 만족하는 칸이 여러개이면, 인접한 카중에서 비어있는 칸이 가장많은 칸으로 자리를 정한다
		//3. 2를 만적하는 칸도 여러개이면, 행의 번호가 가장 작은 칸으로,. 그러한 칸도 여러개이면 열의 번호가 가장 작은 칸으로 자리르 정한다.
		//예를들어 n=3이고 3x3 
		//9명 학생 
		int n=scan.nextInt();
		int studentCount=n*n;
		int [][]students=new int[studentCount][5];
		int [][]studentsCheck=new int[studentCount+1][4];
		int [][]room=new int[n][n];
		int [][]happyCount=new int[n][n];
		boolean [][]bvisied=new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bvisied[i][j]=false;
			}
		}
		
		for(int i=0;i<studentCount;i++) {
			for(int j=0;j<5;j++) {
				int tmp=scan.nextInt();
				students[i][j]=tmp;
				
			}
			
		}
		
		for(int i=0;i<studentCount;i++) {
			for(int j=1;j<5;j++) {
			studentsCheck[ students[i][0] ] [ j-1 ]=  students[i][j] ;
			}
		}
		
		int diri[]= {1,-1,0,0};
		int dirj[]= {0,0,1,-1};
		
		for(int k=0;k<studentCount;k++) {
			int maxLike=0;
			int maxBlank=0;
			int savei=-1;
			int savej=-1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// i,j 위치에 존재시 students[k][0]; 본인 
					
						//1.좋아하는 학생 인접한 칸에 가장 많은 칸으로 이동 
						int likeCount=0;
						
						

				    	
				    	
						int blankCount=0;
						if(bvisied[i][j]==true) {
							  //System.out.print("!"+0+","+0+"!");
							continue;
						}
					 
							for(int z=0;z<4;z++) {
								int tmpDiri=i+ diri[z];
								int tmpDirj=j+ dirj[z];
								
								//좋아하는 학생students[k][t];
								if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=n) {
									continue;
								}
								
								 for(int t=1; t < 5;t++) { 
									 if(room[tmpDiri][tmpDirj]==students[k][t]) {
										 //인접한 좋아하는 학생
										 likeCount++;
										 //continue;
									 }
								 }
								if(room[tmpDiri][tmpDirj]==0){
									//비어잇는칸
									blankCount++;
								}
								
							}
							
					    
					    
					    
					 
						//savei=i;
						//savej=j;
					  //likeCount=0 //blankCount=0
					    if(maxLike<likeCount) {
					    	 //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
					    	savei=i;
							savej=j;
							maxLike=likeCount; //1 
							maxBlank=blankCount;
					    	 
					    }else if(maxLike==likeCount) {
					    	if(maxBlank<blankCount) {
					    		//1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
					    		maxBlank=blankCount;
					    		savei=i;
					    		savej=j;
					    	}else if(maxBlank==blankCount) {
					    		//2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
					    		
					    		if(savei>i) {
					    			savei=i;
					    		}else if(savei==i) {
					    			if(savej>j) {
					    				savej=j;
					    			}
					    		}
					    		
					    		if(savei==-1||savej==-1) {
					    			savei=i;
					    			savej=j;
					    		}
					    		
					    	}
					    	
					    }
					    
					   
					    
					    //blankCount => 2
					   //System.out.print("("+likeCount+","+blankCount+")");
					
					    //maxLike=Math.max(likeCount, maxLike);
					    //maxBlank=Math.max(a, b);
				}
				//System.out.println();
			}
			//위치
			bvisied[savei][savej]=true;
			room[savei][savej]=students[k][0];
			//System.out.println();
			/*
			System.out.println();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) 
				{
					System.out.print(room[i][j]+",");
				}
				System.out.println();
				}
			System.out.println();*/

		}
		/*
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(room[i][j]);
			}
			System.out.println();
			}
		System.out.println();*/
		//만족도가 0 ->0
		//만족도가 1->1
		//만족도가 2>10
		//만족도가 3>100
		//만족도가 4>1000
		int happy=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//System.out.print(room[i][j]+"->");
				int tmphappy=0;
				for(int z=0;z<4;z++) {
					int tmpdiri= i+diri[z];
					int tmpdirj= j+dirj[z];
					if(tmpdiri==-1||tmpdirj==-1||tmpdiri>=n||tmpdirj>=n) {
						continue;
					}
					
				//	System.out.print(room[tmpdiri][tmpdirj]+":");
					for(int p=0;p<4;p++) {
					//	System.out.print(","+studentsCheck[ room[i][j] ][p]+",");
						if(studentsCheck[ room[i][j] ][p]==room[tmpdiri][tmpdirj] ) {
							tmphappy++;
						}
					}
					//System.out.println();
					
					
				}
				
				if(tmphappy==0) {
					happy+=0;
				}else if(tmphappy==1) {
					happy+=1;
				}
				else if(tmphappy==2) {
					happy+=10;
				}
				else if(tmphappy==3) {
					happy+=100;
				}
				else if(tmphappy==4) {
					happy+=1000;
				}
				//System.out.println();
				//studentsCheck[ room[i][j] ][ ]
			}
			
			
		}
		System.out.println(happy);
		
		
	}
	
	
}
