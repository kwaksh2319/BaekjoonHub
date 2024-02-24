
import java.util.*;

public class Main {
	public static int maps[][];
	public static boolean bCheck[][];
	public static int n;
	public static ArrayList<Cloud>clouds=new ArrayList<>();
	public static class Cloud{
		private int x;
		private int y;
		public Cloud(int x,int y) {
			this.x=x;
			this.y=y;
		}
		
		public void update(int x,int y) {
			this.x=x;
			this.y=y;
		}
		
		public int x() {
			return this.x;
		}
		
		public int y() {
			return this.y;
		}
	}
	public static void Prints() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(maps[i][j]+",");
			}
			System.out.println();
		}
	}
	public static void moving(int movX,int movY, int S ) {
		
		for(int i=0;i<S;i++) {
			for(int j=0;j<clouds.size();j++) {
				int tmpX=clouds.get(j).x();
				int tmpY=clouds.get(j).y();
				
				//이동
				tmpX=tmpX+movX;
				tmpY=tmpY+movY;
				
				if(tmpX < 0 ) {
					tmpX=n-1;
				}
				
				if(tmpX>n-1) {
					tmpX=0;
				}
				
				if(tmpY < 0 ) {
					tmpY=n-1;
				}
				
				if(tmpY>n-1) {
					tmpY=0;
				}
				
				clouds.get(j).update(tmpX,tmpY);
			}
		
		}
		//rain
		for(int i=0;i<clouds.size();i++) {
			int tmpX=clouds.get(i).x();
			int tmpY=clouds.get(i).y();
			
			maps[tmpX][tmpY]=maps[tmpX][tmpY]+1;
			
		}
	
		//대각선 4개 방향에 따라 물잇을시
		int dirx[]= {-1,1,-1,1};
		int diry[]= {-1,-1,1,1};
		for(int i=0;i<clouds.size();i++) {
			int tmpX=clouds.get(i).x();
			int tmpY=clouds.get(i).y();
			bCheck[tmpX][tmpY]=true;
			
	
			//대각선 4개
			int tmpcnt=0;
			for(int j=0;j<4;j++) {
				int tmpDirX=tmpX+dirx[j];
				int tmpDirY=tmpY+diry[j];
				if(tmpDirX  == -1 ||tmpDirY == -1 || tmpDirX>n-1 ||tmpDirY>n-1) {
					continue;
				}
				if(maps[tmpDirX][tmpDirY]<=0) {
					continue;
				}
				tmpcnt++;
			}
			
			maps[tmpX][tmpY]=maps[tmpX][tmpY]+tmpcnt;
			
		}
		
		
		
		ArrayList<Cloud>tmpClouds=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(maps[i][j]>=2 && bCheck[i][j] == false) {
					
					tmpClouds.add(new Cloud(i,j));
					//bCheck[i][j]=true;
					maps[i][j]=maps[i][j]-2;
					
				}
			}
		}
		
		
	   //clouds.clear();
		for(int i=0;i<clouds.size();i++) {
			int tmpX=clouds.get(i).x();
			int tmpY=clouds.get(i).y();
			bCheck[tmpX][tmpY]=false;
		}
		
		clouds.clear();
		
		for(int i=0;i<tmpClouds.size();i++) {
			clouds.add(tmpClouds.get(i));
		}
	}
	
	
    public static void main(String[] args) throws Exception {
    	
    	Scanner scan=new Scanner(System.in);
        //1di 방향으로 si 칸이동한다.
    	//2 각 구름에서 비가 내려 구름이 있는 바구니에 저장된 물의 양이1증가한다.
    	//3 구름이 모두 사라진다
    	//4 2에서 물이 증가한 칸 (r,c)에 물복사버그 마법을 시전한다.
    	//  ㅁㄹ복사 버그를 마법을 사요하면, 대각선 방향으로 거리가 1인칸에 물잉 ㅣㅅ는 바구니의 수만큼(r,c)에 있는 바구니의 물이 양이 증가한다.
    	//  에를들어 (n,2) 에서 인접한 대각선 칸은 (n-1,1),(n-1,3)
    	//         (n,n)에서 인접한 대각선 칸은 (n-1,n-1)뿐이다.
    	//5 바구니에 저장된 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
    	// 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다. 
    	// m번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자 
    	n=scan.nextInt();
    	int m=scan.nextInt();
    	
    	//1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    	
    	maps=new int[n][n];
    	bCheck=new boolean[n][n];
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			int tmp = scan.nextInt();
    			maps[i][j]=tmp;
    		}
    	}
    	//비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름

    	clouds.add(new Cloud(n-1,0));// (N, 1)
    	clouds.add(new Cloud(n-1,1));//(N, 2)
    	clouds.add(new Cloud(n-2,0));//(N-1, 1)
    	clouds.add(new Cloud(n-2,1));// (N-1, 2)
    	
    	
    	for(int z=0;z<m;z++) {
    		int d=scan.nextInt();
    		int s=scan.nextInt();
    		
    		switch(d) {
    		case 1:  // ←
    			moving( 0, -1, s );
    			break;
    		case 2:   // ↖
    			moving( -1, -1, s );
    			break;
    		case 3:     //↑
    			moving( -1, 0, s );
    			break;
    		case 4:     //↗
    			moving( -1, 1, s );
    			break;
    		case 5:    // →
    			moving( 0, 1, s );
    			break;
    		case 6:    // ↘
    			moving( 1, 1, s );
    			break;
    		
    		case 7:  //↓
    			moving( 1, 0, s );
    			break;
    		
    		case 8:   //↙
    			moving( 1, -1, s );
    			break;
    			
    		default:
    			break;
    		}
    		
    	}
    	
    	int sum=0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			sum=sum+maps[i][j];
    		}
    	}
    	System.out.println(sum);
        
    }
    
}
