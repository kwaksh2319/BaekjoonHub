import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
		public static int initmaps[][];
	public static int maps[][];
	public static int copymaps[][];
	public static boolean bCheck[];
	public static int n;
	public static int m;
	public static int k;
	public static int mins =0;
	public static  ArrayList<TestCommand>testCommands=new ArrayList<>();
	public static  ArrayList<TestCommand>testSaveCommands=new ArrayList<>();
	public static  class TestCommand{
		public int r;
		public int c;
		public int s;

		public TestCommand(int r, int c, int s){
			this.r=r;
			this.c=c;
			this.s=s;
		}
	}
	public static void prtints(int maps[][],int n, int m){
		System.out.println("");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(maps[i][j]+",");
			}
			System.out.println("");
		}
	}

	public static void rotation(int startr,int endr,int startc ,int endc){
		//top
		for(int i=startc; i < endc ;i++){
			copymaps[startr][i+1] =maps[startr][i];
		}

		//left
		for(int i=startr+1; i<=endr ;i++){
			copymaps[i-1][startc] =maps[i][startc];
		}

		//right
		for(int i=startr; i<endr ;i++){
			copymaps[i+1][endc] =maps[i][endc];
		}

		//bottom
		for(int i=startc+1 ; i<=endc ; i++){
			copymaps[endr][i-1] =maps[endr][i];
		}
	}

	public static void gRotation(int mr,int mc, int ms){
		//make range

		int startR = mr - ms - 1;
		int endR   = mr + ms - 1;
		int startC = mc - ms - 1;
		int endC   = mc + ms - 1;

		//rotation
		for(int i=0;i<ms;i++){
			rotation(startR+i,endR-i,startC+i,endC-i);
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				int tmp=copymaps[i][j];
				maps[i][j]=tmp;
			}
		}
	}

	public static void backtracking(int cnt){
		if(cnt>=k){
			//prtints(maps,n,m);
			for(int i=0;i<testSaveCommands.size();i++){
				//System.out.println("r"+testSaveCommands.get(i).r);
				gRotation(testSaveCommands.get(i).r,testSaveCommands.get(i).c, testSaveCommands.get(i).s);
			}

			//prtints(maps,n,m);
			//System.out.println("");

			for(int i=0;i<n;i++){
				int sum=0;
				for(int j=0;j<m;j++){
					sum+=maps[i][j];
				}
				if(sum<=mins||mins==0){
					mins=sum;
				}
			}

			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					int tmp =initmaps[i][j];
					maps[i][j]=tmp;
					copymaps[i][j]=tmp;
				}
			}
		}

		for(int i=0;i<k;i++){
			if(bCheck[ i ]==false){
				bCheck[ i ]=true;
				testSaveCommands.add( testCommands.get( i ) );
				backtracking(cnt+1 );
				testSaveCommands.remove( testSaveCommands.size()-1);
				bCheck[ i ]=false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		k=scan.nextInt();
		maps=new int[n][m];
		initmaps=new int[n][m];
		copymaps=new int[n][m];
		bCheck=new boolean[k];
		//make map
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				int tmp =scan.nextInt();
				maps[i][j]=tmp;
				copymaps[i][j]=tmp;
				initmaps[i][j]=tmp;
			}
		}

		for(int z=0;z<k;z++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			int s = scan.nextInt();
			testCommands.add(new TestCommand(r,c,s));
		}

		//backtracking
		for(int i=0;i<testCommands.size();i++){
			if(bCheck[i]==false) {
				bCheck[i] = true;
				testSaveCommands.add(testCommands.get(i));//341
				backtracking(1 );
				testSaveCommands.remove(testSaveCommands.size()-1);
				//testSaveCommands.remove(testCommands.size()-i);
				bCheck[i] = false;
			}
		}
		System.out.print(mins);
	}
}