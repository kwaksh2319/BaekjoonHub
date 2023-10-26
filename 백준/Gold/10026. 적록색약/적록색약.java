
import java.io.*;
import java.util.*;
class Data{
	private int gi;
	private int gj;
	
	public Data() {
		
	}
	public Data(int gi,int gj) {
		this.gi=gi;
		this.gj=gj;
	}
	public void gi(int gi) {
		this.gi=gi;
	}
	public void gj(int gj) {
		this.gj=gj;
	}
	public int gi() {
		return gi;
	}
	public int gj() {
		return gj;
	}
}

public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan =new Scanner(System.in);
		int n=scan.nextInt();
		scan.nextLine();
	
		ArrayList<ArrayList<Character>> maps=new ArrayList<>();
		ArrayList<ArrayList<Boolean>> bVisited=new ArrayList<>();
		ArrayList<ArrayList<Boolean>> gbbVisited=new ArrayList<>();
		
	
		for(int i=0;i<n;i++) {
			ArrayList<Character>tmpMap=new ArrayList<>();
			ArrayList<Boolean>tmpBv=new ArrayList<>();
			ArrayList<Boolean>tmpBvd=new ArrayList<>();
			String tmpstr=scan.nextLine();
		//	System.out.println(tmpstr.length());
			for(int j=0;j<tmpstr.length();j++) {
				tmpBv.add(false);
				tmpBvd.add(false);
				tmpMap.add(tmpstr.charAt(j));
			}
			
			//System.out.println(i);z
			gbbVisited.add(tmpBvd);
			bVisited.add(tmpBv);
			maps.add(tmpMap);
		}
		
	
		int diri[]= {1,-1,0,0};
		int dirj[]= {0,0,1,-1};
		
		Queue<Data> q=new LinkedList<>();
		//적록인경우
		//정산인
		int red=0;
		int green=0;
		int redgreen=0;
		//int green=0;
		int blue=0;
		char c[]= {'R','G','B'};
		int cnt=0;
		for(int k=0;k<4;k++) {
			
			//System.out.println(k);
		for(int t=0;t<n;t++) {
			for(int z=0;z<n;z++) {
				boolean bfind=false;
				
				if(k==3) {
					
					if(gbbVisited.get(t).get(z)==false) {
						//System.out.println(t+":"+z);
						if(maps.get(t).get(z)=='R'||maps.get(t).get(z)=='G') {
							q.add(new Data(t,z));
						}
					}
					
					
					//정상인
					while(!q.isEmpty()) {
						Data start=q.peek();
						q.poll();
						if(bfind==false) {
							
							redgreen++;
							bfind=true;
						}
						
						for(int i=0;i<4;i++) {
							int tmpDiri=diri[i]+start.gi();
							int tmpDirj=dirj[i]+start.gj();
							//System.out.println(tmpDiri+","+tmpDirj);
							if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=n) {
								continue;
							}
							
							
							if(gbbVisited.get(tmpDiri).get(tmpDirj)==false) {
								if((maps.get(tmpDiri).get(tmpDirj)=='R'||maps.get(tmpDiri).get(tmpDirj)=='G')) {
									gbbVisited.get(tmpDiri).set(tmpDirj, true);
									
									//	System.out.println(bVisited.get(tmpDiri).get(tmpDirj));
										q.add(new Data(tmpDiri,tmpDirj));
								}
								
							}
							
						}
					}
					
				}
				
				if(k!=3) {
					if(maps.get(t).get(z)==c[k] && bVisited.get(t).get(z)==false ) {
						
						q.add(new Data(t,z));
						
					}
				
				
				
				
				//정상인
				while(!q.isEmpty()) {
					Data start=q.peek();
					q.poll();
					if(bfind==false) {
						if(c[k]=='R') {
							red++;
						}else if(c[k]=='G') {
							green++;
						}else if(c[k]=='B') {
							blue++;
						}
						
						bfind=true;
					}
					
					for(int i=0;i<4;i++) {
						int tmpDiri=diri[i]+start.gi();
						int tmpDirj=dirj[i]+start.gj();
						//System.out.println(tmpDiri+","+tmpDirj);
						if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=n) {
							continue;
						}
						
						
						if(maps.get(tmpDiri).get(tmpDirj)==c[k]&&bVisited.get(tmpDiri).get(tmpDirj)==false) {
							bVisited.get(tmpDiri).set(tmpDirj, true);
							
						//	System.out.println(bVisited.get(tmpDiri).get(tmpDirj));
							q.add(new Data(tmpDiri,tmpDirj));
						}
						
					}
				}
				
				}
				
				
				//System.out.println("out");
			}
			
		 }
		}
		
		//System.out.println(red);
		//System.out.println(blue);
		//System.out.println(green);
		//System.out.println(redgreen);
		int normal=red+blue+green;
		int rb=blue+redgreen;
		System.out.print(normal+" "+rb);
		
	}
	
}
