
import java.util.*;

public class Main {
    private int x;
    private int y;
    private int data;
    public Main(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Main(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public int I() {
        return this.x;
    }

    public int J() {
        return this.y;
    }

    public int Data() {
        return this.data;
    }

    public static void Prints(int tmaps[][],int n, int m) {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			System.out.print(tmaps[i][j]+",");
    		}
    		System.out.println();
    	}
    	 System.out.println();
    }
    public static int Sums(int tmaps[][],int n, int m) {
    	int totalsum=0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(tmaps[i][j]!=-1) {
    				totalsum=totalsum+tmaps[i][j];
    			}
    			
    		}
    	}
    	return totalsum;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
       
        //미세먼지를 제거하기 위해 구사과 공기청정기를 설치하려한다
        //공기 청정기의 성능은 테스트하기 위해 구사과는 집을 크기가 RXC인 격자판으로 나타냈고 ,
        //구사과는 뛰어난 코딩 실력을 이용하여 RC 에 있는 미세먼지양을 실시간으로 모니터링하는 시스템을 개발햇다.
        
        //공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두행을 차지한다.
        // 공기청정기가 설치되어 있지않는 칸에는 미세먼지가 잇고, RC 미세먼지의 양은 Arc이다
        
        //1초 동안 아래 적힌 일이 순서대로 일어난다.
        
        //1.미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
        //r,c에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        //r,c 에 있는 공기청정기 잇거나, 칸이 없으면 그방향 확산되지않난다,
        //확산되는 양은 a/5이고 소수점은 버린다
        //rc에 남는 미세먼지양은 a-a/5*확산된 방향의 갯수이다
        // 2. 공기 청저기가 작동한다
        // 공기청정기에서는 바람이 나온다.
         //위쪽 공기 청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람
         int n=scan.nextInt();
         int m=scan.nextInt();
         int T= scan.nextInt();
         int maps[][]=new int[n][m];
         int blankmaps[][]=new int[n][m];
         int copymaps[][]=new int[n][m];
         
         int init[][]=new int[n][m];
         ArrayList<Main>air=new ArrayList<>();
         
         for(int i=0;i<n;i++) {
        	 for(int j=0;j<m;j++) {
        		 int tmp =scan.nextInt();
        		 maps[i][j]=tmp;
        		 
        		 if(tmp ==-1) {
        			 blankmaps[i][j]=-1;
        			 copymaps[i][j]=-1;
        			
        			 air.add(new Main(i,j));
        		 }
        	 }
         }
         
         int []diri= {1,-1,0,0};
         int []dirj= {0,0,1,-1};
         
         for(int z=0;z<T;z++) {
        	 //Prints(maps,n,m);
        	 for(int i=0;i<n;i++) {
            	 for(int j=0;j<m;j++) {
            		 //먼지 확산
            		
            		 if(maps[i][j]!=-1&&maps[i][j]!=0) {
            			 int cnt=0;
            			 ArrayList<Main>d=new ArrayList<>();
            			 for(int k=0;k<4;k++) {
            				 int tmpdiri=i+diri[k];
            				 int tmpdirj=j+dirj[k];
            				 
            				 if(tmpdiri==-1||tmpdirj==-1||tmpdiri>=n||tmpdirj>=m) {
                				 continue;
                			 }
            				 if(maps[tmpdiri][tmpdirj]==-1) {
            					 continue;
            				 }
            				 cnt++;
            				 d.add(new Main(tmpdiri,tmpdirj));
            				 //좌표값저장
            			 }
            			 
            			 //상하좌우
            			 for(int k=0;k<d.size(); k++ ) {
            				 Main pos=d.get(k);
            				 blankmaps[pos.I()][pos.J()]=blankmaps[pos.I()][pos.J()] +  maps[i][j]/5 ;
            				
            			 }
            			 blankmaps[i][j]= blankmaps[i][j] + maps[i][j] - maps[i][j]/5 * cnt; //9-2

            		 }
            		 
            	 }
             }
 
        	 for(int i=0;i<n;i++) {
            	 for(int j=0;j<m;j++) {
            		 maps[i][j]=blankmaps[i][j];
            	 }
            	 
        	 }
        	//공기청정기 작동
        	// 위쪽 공기청정기 작동
        	 int x=0;
        	 int y=0;
        	 Main up = air.get(0);
        	 x = up.I();
        	 y = up.J();

        	 // 반시계 방향으로 이동
        	 // 아래로 이동
        	 for (int i = x-1; i > 0; i--) maps[i][0] = maps[i-1][0];
        	 
        	// 왼쪽으로 이동
        	 for (int i = 0; i < m - 1; i++) maps[0][i] = maps[0][i + 1];
        	 
        	// 위쪽으로 이동
        	 for (int i = 0; i <= x-1; i++) maps[i][m - 1] = maps[i+1][m - 1];
        	 
        	 // 오른쪽으로 이동
        	 for (int i =  m-1; i >0; i--) maps[x][i] = maps[x][i-1];
        
        	 // 공기청정기 위치의 먼지 제거
        	 maps[x][y] = -1;
        	 maps[x][y+1] = 0;
        	 
        	 
        	 // 공기청정기 작동 (하단)
        	 Main down = air.get(1);
        	 x = down.I();
        	 y = down.J();

        	 // 시계 방향으로 이동
        	 // 위쪽으로 이동
        	 for (int i = x; i < n-1; i++) maps[i][y] = maps[i+1][y];
        	// Prints(maps, n, m);
        	 // 왼쪽이동
        	 for (int i = 0; i < m-1; i++) maps[n-1][i] = maps[n-1][i+1];
        	// Prints(maps, n, m);
        	 // 아래쪽이동
        	 for (int i = n-1; i > x; i--) maps[i][m-1] = maps[i-1][m-1];
        	 //Prints(maps, n, m);
        	 // 오른쪽이동
        	 for (int i = m-1; i > 0; i--) maps[x][i] = maps[x][i-1];
        	// Prints(maps, n, m);

        	 // 공기청정기 위치의 먼지 제거
        	 maps[x][y] = -1;
        	 maps[x][y+1] = 0;

        	 for(int i=0;i<n;i++) {
            	 for(int j=0;j<m;j++) {
            		 blankmaps[i][j]=copymaps[i][j];
            	 }
            	 
        	 }
         }
         int tsum=Sums(maps, n, m);
         System.out.print(tsum);
         
    }
}

