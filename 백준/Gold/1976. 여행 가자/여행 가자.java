import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {

	private int  parent[];
	public Main(int size) {
		parent =new int[size];
		
		for(int i=0;i<size;i++) {
			parent[i]=i;
		}
	}
	
    public int find(int x) {
    	if(x!=parent[x]) {
    		parent[x]=find(parent[x]);
    	}
    	return parent[x];
    }
    
    public int track(int x) {
    	if(x!=parent[x]) {
    		parent[x]=find(parent[x]);
    	}
    	return parent[x];
    }
    
	public void union(int x,int y) {
		int rootX=find(x);
		int rootY=find(y);
		
		if(rootX!=rootY) {
			parent[rootX]=rootY;
		}
	}
	public void Prints(int size ) {
		for(int i=0;i<size;i++) {
		   System.out.print(parent[i]+",");
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan =new Scanner(System.in);
        //동혁이는 친구들과 함꼐 여향을 가려한다.
		// 한국에는  도시가 n개 잇고
		//임의의 두 도시 사이에 길이 잇을수도 잇고 없을수도 잇다 
		//동혁이는 여행 일정이 주어졋을때,
		//이 여행 경로가 가능한것인지 확인
		//물론 중간에 다른 도시를 경유해서 여행할수 잇다
		//예를들어  a-b, b-c, a-d, b-d, e-a
		// e  c  b c d 
		// E-A-B-C-B-C-B-D
		//길의 가능여부를 판별 하는것을 작성하자 
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		Main uf=new Main(n+1);
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
			int a=scan.nextInt();
			
				//if(i!=j) {
					if(a==1) {
						uf.union(i, j);
					}
					
				//}
			
			}			
		}
		
		boolean bCheck=false;
		int start=uf.find(scan.nextInt());
		for(int i=1;i<m;i++) {
			if(start!=uf.find(scan.nextInt()))
			{
				bCheck=true;
				break;
			}
		}
		
		if(bCheck==false) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}
