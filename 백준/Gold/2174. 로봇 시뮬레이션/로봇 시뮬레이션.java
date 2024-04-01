
import java.util.*;
import java.io.*;
public class Main {
	public static int A;
	public static int B;
	public static boolean bOkay=true;
	public static ArrayList<String> anws=new ArrayList<>();
	public static void Prints(){
		System.out.println();
		for(int i=0;i<B;i++){
			for(int j=0;j<A;j++){
				if(maps[i][j].bCheck==true){
					System.out.print(1+",");
				}else{
					System.out.print(0+",");
				}
			}
			System.out.println();
		}
		System.out.println();

	}
	public static class Robot{
		public int x;
		public int y;
		public int dir;
		public Robot(int x,int y, int dir){
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
	public static class RMaps{
		public int rnum;
		public boolean bCheck=false;
		public RMaps(int rnum, boolean bCheck){
			this.rnum=rnum;
			this.bCheck=bCheck;
		}
	}

	public static class TestCommand{
		public int r;
		public char command;
		public int loop;
		public TestCommand(int r,char command, int loop){
			this.r=r;
			this.command=command;
			this.loop=loop;
		}
	}

	public static void forword(int x, int y,int dir,int rnum){
		switch (dir){
			case 0:
				//n
				int checkY=y-1;
				if(checkY<0){
					//wall
					int tmp=rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into the wall";
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}

				if(maps[checkY][x].bCheck==true){
					//robot collision
					int tmp=rnum+1;
					int tmp2=maps[checkY][x].rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into robot "+tmp2;
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}

				robots.get(rnum).y=checkY;
				break;
			case 1:
				//w
				int checkX=x-1;
				if(checkX<0){
					int tmp=rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into the wall";
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}

				if(maps[y][checkX].bCheck==true){
					//robot collision
					int tmp=rnum+1;
					int tmp2=maps[y][checkX].rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into robot "+tmp2;
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}
				robots.get(rnum).x=checkX;
				break;
			case 2:
				//s
				int checkY2=y+1;
				if(checkY2>=B){
					//wall
					int tmp=rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into the wall";
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}

				if(maps[checkY2][x].bCheck==true){
					//robot collision
					int tmp=rnum+1;
					int tmp2=maps[checkY2][x].rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into robot "+tmp2;
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}
				robots.get(rnum).y=checkY2;
				break;
			case 3:
				int checkX2=x+1;
				if(checkX2>=A){
					//wall
					int tmp=rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into the wall";
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}

				if(maps[y][checkX2].bCheck==true){
					//robot collision
					int tmp=rnum+1;
					int tmp2=maps[y][checkX2].rnum+1;
					String tmpAnw="Robot "+tmp+" crashes into robot "+tmp2;
					anws.add(tmpAnw);
					bOkay=false;
					break;
				}
				robots.get(rnum).x=checkX2;
				break;
			default:
				break;
		}
	}

	public static RMaps maps[][];
	public static ArrayList<Robot> robots=new ArrayList<>();
	public static ArrayList<TestCommand> testCommands=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		 A=scan.nextInt(); //5
		 B=scan.nextInt(); //4
		maps=new RMaps[B][A];//4 x 5
		int n=scan.nextInt();
		int m=scan.nextInt();

		for(int i=0;i<B;i++){//y 4
			for(int j=0;j<A;j++){//x 5
				maps[i][j]=new RMaps(-1,false);
			}
		}

		for(int i=0;i<n;i++){
			int x=scan.nextInt()-1; // 5
			int y=B-scan.nextInt();  // 4
			String dir=scan.next();
			int d=0;
			if(dir.charAt(0)=='N'){
				d=0;
			}else if(dir.charAt(0)=='W'){
				d=1;
			}
			else if(dir.charAt(0)=='S'){
				d=2;
			}
			else if(dir.charAt(0)=='E'){
				d=3;
			}
			robots.add(new Robot(x,y,d));
			maps[y][x].bCheck=true;
			maps[y][x].rnum=i;
		}
		//Prints();
		for(int i=0;i<m;i++){
			int r=scan.nextInt();
			String command=scan.next();
			int loop=scan.nextInt();
			testCommands.add(new TestCommand(r,command.charAt(0),loop));
		}


		for(int t=0;t<testCommands.size();t++){
				int rnum=testCommands.get(t).r-1;
				char commad=testCommands.get(t).command;
				int loop =testCommands.get(t).loop;


				int initx=robots.get(rnum).x;
				int inity=robots.get(rnum).y;

				bOkay=true;

				for(int i=0;i<loop;i++){
					int x=robots.get(rnum).x;
					int y=robots.get(rnum).y;
					int dir=robots.get(rnum).dir;
					switch(commad){
						case 'L':
							dir=dir+1;
							robots.get(rnum).dir=dir%4;
							break;
						case 'R':
							dir=dir-1;
							if(dir<0){
								dir=3;
							}
							robots.get(rnum).dir=dir%4;
							break;
						case 'F':
							forword(x,y,dir,rnum);
							if(bOkay==false){
								i=loop+1;
								continue;
							}
							break;
						default:
							break;
					}
				}

				if(bOkay==true){

					maps[inity][initx].bCheck=false;
					maps[inity][initx].rnum=-1;
					maps[robots.get(rnum).y][robots.get(rnum).x].rnum=rnum;
					maps[robots.get(rnum).y][robots.get(rnum).x].bCheck=true;
					//Prints();

					//System.out.println(robots.get(rnum).x+","+robots.get(rnum).y+","+robots.get(rnum).dir);
				}

			if(anws.size()>0){
				break;
			}
		}

		if(anws.size()>0){
			System.out.print(anws.get(0));
		}else{
			System.out.print("OK");
		}
	}
}