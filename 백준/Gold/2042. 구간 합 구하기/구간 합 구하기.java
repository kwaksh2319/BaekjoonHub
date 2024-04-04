import java.util.*;
import java.io.*;
public class Main {
	public static int n;
	public static int m;
	public static int k;
	public static long tree[];
	public static void initTree(long arr[]){
		builingTree(0,n-1,1,arr);
	}

	public static long builingTree(int start ,int end, int node, long arr[]){
		//System.out.println("node:"+node+",start:"+start+",end:"+end);
		if(start==end){
			return tree[node]=arr[start];
		}

		int mid=(start+end)/2; // 0+5 =2

		return tree[node]=builingTree(start, mid,node*2,arr)+builingTree(mid+1,end,node*2+1,arr);
	}

	public static void updateTree(int start,int end,int node,long newValue, long findIndex){
		//System.out.println("node:"+node+",start:"+start+",end:"+end);
		if(findIndex<start||findIndex>end){
			return;
		}

		if(start==end){
			tree[node]=newValue;
			return;
		}

		int mid=(start+end)/2;

		updateTree(start,mid,node*2,newValue,findIndex);
		updateTree(mid+1,end,node*2+1,newValue,findIndex);
		tree[node]=tree[node*2]+tree[node*2+1];
	}

	public static long select (int start,int end,int node,long left,long right){
		//System.out.println("node:"+node+",start:"+start+",end:"+end);
		//System.out.println("left:"+left+",right:"+right);
		if(left>end||right<start){
			//System.out.println("zero");
			return 0;
		}

		if(left<=start&&end<=right){
			//System.out.println("sum:");
			return tree[node];
		}

		int mid=(start+end)/2;

		return select(start,mid,node*2,left,right)+select(mid+1,end,node*2+1,left,right);
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		 n =scan.nextInt();
		 m=scan.nextInt();//change
		 k=scan.nextInt();//sum ?
		int ending=n+m+k+1;
		long arr[]=new long[n];
		for(int t=0;t<n;t++){
			long tmp=scan.nextLong();
			arr[t]=tmp;
		}
		tree=new long[n*4];
		builingTree(0,n-1,1,arr);
		//System.out.println();
		//for(int i=0;i<tree.length;i++){
		//	System.out.print(tree[i]+",");
		//}
		//System.out.println();
		//int query=select(0,n-1,1,0,1);
		//System.out.println("query:"+query);


		for(int t=0;t<(k+m);t++){
			int a=scan.nextInt();
			long b=scan.nextLong();
			long c=scan.nextLong();
			if(a==1){
				//update
				updateTree(0,n-1,1,c, b-1);
				//System.out.println();
				//for(int i=0;i<tree.length;i++){
					//System.out.print(tree[i]+",");
				//}
				//System.out.println();
			}else if(a==2){
				//select
				//b ~ c
				long query=select(0,n-1,1,b-1,c-1);
				System.out.println(query);
			}
		}

		// N+M+K+1 5 +2 +2 +1
		//a, b, c
		//a 1 -> (b->c)
		//a 2->(b~c sum)


	}
}