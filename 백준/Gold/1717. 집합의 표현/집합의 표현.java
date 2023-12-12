import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	private int[]parent;
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
	
	public void union(int x,int y) {
		int rootX=find(x);
		int rootY=find(y);
		if(rootX!=rootY) {
			parent[rootX]=rootY;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan =new Scanner(System.in);
        //초기에 n+1개의 집합 {0},1...n
		//여기에 합집합연산과, 두 원소가 같은 집합에 포함되어 잇는지를 확인하는 연산수행 
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		Main uf=new Main(n+1);
		ArrayList<String>anw=new ArrayList<>();
		for(int i=0;i<m;i++) {
			int c=scan.nextInt();
			int a=scan.nextInt();
			int b=scan.nextInt();
			if(c==0) {
				//합집합
				uf.union(a, b);
			}else if(c==1) {
				//체크
				if(uf.find(a)==uf.find(b)) {
					anw.add("YES");
					
				}else {
					anw.add("NO");
				
				}
			
			}
		}
		for(int i=0;i<anw.size();i++) {
			System.out.println(anw.get(i));
		}
        
	}
}
