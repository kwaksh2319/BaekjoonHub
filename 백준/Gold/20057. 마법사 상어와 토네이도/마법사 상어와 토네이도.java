
import java.util.*;
import java.io.*;
public class Main {
	public static int n;
	public static int maps[][];
	public static int copyMaps[][];
	public static int ci;
	public static int cj;
	public static int outsand=0;
	public static void Prints(int tmpmaps[][]){
		System.out.println();

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(tmpmaps[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void checking(int checki,int checkj,int input ){
		if(checki> n-1 ||checkj >n-1||checki<0||checkj<0){
			//System.out.println("sendout:"+input);
			outsand=outsand+input;

		}else{
			maps[checki][checkj] = maps[checki][checkj]+input;
		}
	}
	public static void spread(int mci,int mcj,int diri,int dirj,int index ,int pi,int pj){
		//Prints(maps);
		int tmp=maps[mci][mcj];
		maps[mci][mcj]=0;

		int two=  (int)(tmp*0.02);
		int one=  (int)(tmp*0.01);
		int seven=  (int)(tmp*0.07);
		int ten=  (int)(tmp*0.1);
		int five=  (int)(tmp*0.05);
		int alpa=tmp-(two*2+one*2+seven*2+ten*2+five);
		int alpai=mci+diri;
		int alpaj=mcj+dirj;
		/*
		System.out.println("alpa:"+alpa);
		System.out.println("two:"+two);
		System.out.println("seven:"+seven);
		System.out.println("ten:"+ten);
		System.out.println("five:"+five);
		System.out.println("five:"+one);*/
		checking(mci + diri * 2,mcj + dirj * 2, five );
		if(index==0){
			checking(mci+2,mcj, two );
			checking(mci-2,mcj, two );

			checking(alpai-1,alpaj, ten );
			checking(alpai+1,alpaj, ten );

			checking(mci-1,mcj, seven );
			checking(mci+1,mcj, seven );

			checking(pi-1,pj, one );
			checking(pi+1,pj, one );
		}else{
			checking(mci,mcj-2, two );
			checking(mci,mcj+2, two );

			checking(alpai,alpaj-1, ten );
			checking(alpai,alpaj+1, ten );

			checking(mci,mcj-1, seven );
			checking(mci,mcj+1, seven );

			checking(pi,pj-1, one );
			checking(pi,pj+1, one );
		}
		checking(alpai,alpaj, alpa );
		//Prints(maps);
	}
	public static void Rotation(int index){
			if(index%2==1){
				//left 0
				for(int i=0;i<index;i++){
					int tmpi=ci;
					int tmpj=cj;
					ci=ci;
					cj=cj-1;
					if(maps[ci][cj]>0){
						spread(ci,cj,0,-1,0,tmpi,tmpj);
					}
				}
				//copyMaps[][]=maps[ci][cj];
				// down 1
				for(int i=0;i<index;i++){
					int tmpi=ci;
					int tmpj=cj;
					ci=ci+1;
					cj=cj;
					if(maps[ci][cj]>0){
						spread(ci,cj,1,0,1,tmpi,tmpj);
					}
				}
			}else{
				//right 2
				for(int i=0;i<index;i++) {
					int tmpi=ci;
					int tmpj=cj;
					ci = ci;
					cj = cj + 1;
					if(maps[ci][cj]>0){
						spread(ci,cj,0,1,0,tmpi,tmpj);
					}
				}
				// up 3
				for(int i=0;i<index;i++) {
					int tmpi=ci;
					int tmpj=cj;
					ci = ci - 1;
					cj = cj;
					if(maps[ci][cj]>0){
						spread(ci,cj,-1,0,1,tmpi,tmpj);
					}
				}
			}

		//left 1 0
		//down 1 0
		//right 2 1
		//up 2 1
		//..
		//right 6
		//up 6

		//left 6
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		maps=new int[n][n];
		copyMaps=new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int tmp=scan.nextInt();
				maps[i][j]=tmp;
				copyMaps[i][j]=tmp;
			}
		}

		 ci=n/2;
		 cj=n/2;
		//System.out.println("center:"+ci+","+cj);
		for(int i=0;i<n-1;i++) {
			Rotation( i +1 );
		}
		//System.out.println("center:"+ci+","+cj);

		//last left
		for(int i=0;i<n-1;i++){
			int tmpi=ci;
			int tmpj=cj;
			ci=ci;
			cj=cj-1;
			if(maps[ci][cj]>0){
				spread(ci,cj,0,-1,0,tmpi,tmpj);
			}
		}
		//System.out.println("center:"+ci+","+cj);
		System.out.println(outsand);
	}
}