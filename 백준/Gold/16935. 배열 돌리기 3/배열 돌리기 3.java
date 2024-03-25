
import java.util.*;
import java.util.*;
import java.io.*;

public class Main {
	public static int[][]map;
	public static int[][]copymap;
	public static int n;
	public static int m;
	
    
	public static void updown() {
		
    	copymap=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copymap[n-1-i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=copymap[i][j];
			}
		}
	}
	
	public static void rightleft() {
		
    	copymap=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copymap[i][m-1-j]=map[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=copymap[i][j];
			}
		}
	}
	
	public static void angleRight() {
	
    	copymap=new int[m][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			copymap[ j ][ n-1-i ]=map[ i ][ j ];
    		}
    	}
    	
    	
    	
    	int tmp =m;
		m=n;
		n=tmp;
		
		//n,m
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[ i ][ j ]=copymap[ i ][ j ];
			}
		}
	}
	
	public static void angleLeft() {
	
    	copymap=new int[m][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			copymap[ m-1-j ][ i ]=map[ i ][ j ];
    		}
    	}
    	
    	
    	
    	int tmp =m;
		m=n;
		n=tmp;
		
		//n,m
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[ i ][ j ]=copymap[ i ][ j ];
			}
		}
		
	}
	
	public static void clockRight() {
		int tmpn=n/2;
		int tmpm=m/2; // 6 3
				
    	copymap=new int[n][m];
    	//1->2
    	for(int i=0;i<tmpn;i++) {
    		for(int j=0;j<tmpm;j++) {
    			copymap[ i ][ j+tmpm ]=map[i][j];
    		}
    	}
    	
    	//2->3
    	for(int i=0;i<tmpn;i++) {
    		for(int j=tmpm;j<m;j++) {
    			copymap[ i+tmpn ][ j ]=map[i][j];
    		}
    	}
    	
    	//3->4
    	for(int i=tmpn;i<n;i++) {
    		for(int j=tmpm;j<m;j++) {
    			copymap[ i ][ j-tmpm ]=map[i][j];
    		}
    	}
    	
    	//4->1
    	for(int i=tmpn;i<n;i++) {
    		for(int j=0;j<tmpm;j++) {
    		 copymap[ i-tmpn ][ j ]=map[i][j];
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			map[i][j]=copymap[i][j];
    		}
    	}
	
	}
	public static void clockLeft() {
		int tmpn=n/2;
		int tmpm=m/2;
				
    	copymap=new int[n][m];
    	//1->4
    	for(int i=0;i<tmpn;i++) {
    		for(int j=0;j<tmpm;j++) {
    			copymap[ i+tmpn ][ j ]=map[ i ][ j ];
    		}
    	}
    	
    	//4->3
    	for(int i=tmpn;i<n;i++) {
    		for(int j=0;j<tmpm;j++) {
    			copymap[ i ][ j + tmpm ]=map[ i ][ j ];
    		}
    	}
    	
    	//3->2
    	for(int i=tmpn;i<n;i++) {
    		for(int j=tmpm;j<m;j++) {
    			copymap[ i-tmpn ][ j ]=map[i][j];
    		}
    	}
    	
    	//2->1
    	for(int i=0;i<tmpn;i++) {
    		for(int j=tmpm;j<m;j++) {
    			copymap[ i ][ j - tmpm ]=map[i][j];
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			map[i][j]=copymap[i][j];
    		}
    	}
	}
	
	public static void prints() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner scan=new Scanner(System.in);
    	 n=scan.nextInt();
    	 m=scan.nextInt();
    	int k=scan.nextInt();
    	
    	map=new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			int tmp=scan.nextInt();
    			map[i][j]=tmp;
    		}
    	}
    	
    	for(int z=0;z<k;z++) {
    		int command=scan.nextInt();
    		switch (command) {
			case 1:
				
				updown();
				break;
			case 2:
				rightleft();
				break;
			case 3:
				angleRight() ;
				break;
			case 4:
				angleLeft();
				break;
			case 5:
				clockRight();
				break;
			case 6:
				clockLeft();
				break;

			default:
				break;
			}
    		
    	}
    	prints();
    }
}

