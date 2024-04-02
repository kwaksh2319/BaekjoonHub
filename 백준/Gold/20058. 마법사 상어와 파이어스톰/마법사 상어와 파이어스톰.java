
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static int n;
	public static int q;
	public static int maps[][];
	public static int copyMaps[][];
	public static boolean bCheck[][];
	public static boolean initbCheck[][];
	public static boolean[][] visited; 
	public static int L;
	public static void prints(int tmpMap[][]){
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(tmpMap[i][j]+",");
			}
			System.out.println();
		}
	}
	public static class Ice {
		public int i;
		public int j;
		public Ice(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	public static void Rotation(int starti, int startj){
		int cnt=1;
		int rStarti=starti*L;
		int rEndi=starti*L+L;
		int rStartj=startj*L;
		int rEndj=startj*L+L;

		int rLengthI=(rStarti+rEndi)/2;
		int rLengthJ=(rStartj+rEndj)/2;

		int rCountI=(rEndi-rStarti)/2;
		int rCountJ=(rEndi-rStarti)/2;

		//1 ->2
		for(int i=rStarti;i<rLengthI;i++){
			for(int j=rStartj;j<rLengthJ;j++){
				copyMaps[i][j+ rCountJ]=maps[i][j];
			}
		}
		//2->3
		for(int i=rStarti;i<rLengthI;i++){
			for(int j=rLengthJ;j<rEndj;j++){
				copyMaps[i+rCountI][j]=maps[i][j];
			}
		}

		//3->4
		for(int i=rLengthI;i<rEndi;i++){
			for(int j=rLengthJ ;j<rEndj;j++){
				copyMaps[i][j-rCountJ]=maps[i][j];
			}
		}
		//4->1
		for(int i=rLengthI;i<rEndi;i++){
			for(int j=rStartj;j<rLengthJ;j++){

				copyMaps[i-rCountI][j]=maps[i][j];
			}
		}
		//prints(copyMaps);
		
		

	}
	
	public static void Rotations(int starti, int startj) {
	    int rStarti = starti * L;
	    int rStartj = startj * L;
	    int[][] temp = new int[L][L];

	    for (int i = 0; i < L; i++) {
	        for (int j = 0; j < L; j++) {
	            temp[j][L - 1 - i] = maps[rStarti + i][rStartj + j];
	        }
	    }

	    for (int i = 0; i < L; i++) {
	        for (int j = 0; j < L; j++) {
	        	maps[rStarti + i][rStartj + j] = temp[i][j];
	        }
	    }
	}
	public static int bfs(int x, int y) {
	    if(maps[x][y] <= 0) return 0; // 시작 칸에 얼음이 없으면 바로 종료
	    int count = 1; // 현재 칸 포함
	    Queue<Ice> queue = new LinkedList<>();
	    queue.add(new Ice(x, y));
	    visited[x][y] = true;

	    while (!queue.isEmpty()) {
	        Ice current = queue.poll();
	        int i = current.i;
	        int j = current.j;

	        // 상하좌우 탐색
	        int[] di = {-1, 1, 0, 0}; // 상하
	        int[] dj = {0, 0, -1, 1}; // 좌우

	        for (int k = 0; k < 4; k++) {
	            int ni = i + di[k];
	            int nj = j + dj[k];

	            // 범위 체크 및 방문하지 않았으며 얼음이 있는지 체크
	            if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && maps[ni][nj] > 0) {
	                queue.add(new Ice(ni, nj));
	                visited[ni][nj] = true;
	                count++; // 연결된 얼음 칸의 개수 증가
	            }
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		q=scan.nextInt();
		double tmpn=Math.pow(2,n);
		n=(int)tmpn;
		maps=new int[n][n];
		copyMaps=new int[n][n];
		bCheck=new boolean[n][n];
		initbCheck=new boolean[n][n];
		visited = new boolean[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				maps[i][j]=scan.nextInt();
				copyMaps[i][j]=maps[i][j];
			}
		}
		for(int t=0;t<q;t++){
			
			L=scan.nextInt();

			double tmpL=Math.pow(2,L);
			L=(int)tmpL;
			//2x2
			//4x4
			//8x8
			int divide=n/L;
			
			
			for(int i=0;i<divide;i++){
				for(int j=0;j<divide;j++){
					Rotations(i,j);
				}
			}
			
			int diri[]= {-1,1,0,0};
			int dirj[]= {0,0,-1,1};
			
			ArrayList<Ice> saveIce=new ArrayList<>();
			for (int i = 0; i < n; i++) {
			    for (int j = 0; j < n; j++) {
			        int iceCnt = 0; 
			        for (int k = 0; k < 4; k++) {
			            int ni = i + diri[k];
			            int nj = j + dirj[k];
			            if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;
			           
			            if (maps[ni][nj] > 0) iceCnt++;
			        }
			        if (iceCnt < 3) {
			            saveIce.add(new Ice(i, j));
			        }
			    }
			}

			// 저장된 모든 칸의 얼음을 1 줄입니다.
			for (Ice ice : saveIce) {
			    maps[ice.i][ice.j] = Math.max(0, maps[ice.i][ice.j] - 1); 
			}
			
		}
		
		int sum=0;
		int maxs=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(maps[i][j]>=0) {
					sum+=maps[i][j];
				}
				
			}
		}
		System.out.println(sum);
		int maxSizeOfIce = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (!visited[i][j] && maps[i][j] > 0) {
            maxSizeOfIce = Math.max(maxSizeOfIce, bfs(i, j));
        }
    }
}
		System.out.println(maxSizeOfIce);
		//Rotation(0,1);

	}
}
