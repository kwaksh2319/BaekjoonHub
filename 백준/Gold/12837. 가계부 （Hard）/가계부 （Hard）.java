
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.*;
public class Main {
	
	public static long tree[];
	
	public static long buildTree(int start, int end , int node , long arr[]) {
		
		if(start==end) {
			return tree[node]=arr[start];
		}
		
		int mid=(start+end)/2;
		
		return tree[node]=buildTree(start,mid,node*2 ,arr)+ buildTree(mid+1,end,node*2+1,arr) ;
		
	}
	public static long select(int start, int end , int node, long left, long right) {
		 if (start > right || end < left) {
	            return 0;
	        }
	        if (start >= left && end <= right) {
	            return tree[node];
	        }
		
		int mid=(start+end)/2;
		
		return   select(start,mid,node*2 ,left, right)+ select(mid+1,end,node*2+1 ,left, right) ;
	}
	
	public static void update(int start, int end , int node, long newValue,long findIndex) {
		   if (start > findIndex || end < findIndex) {
	            return;
	        }
	        if (start == end) {
	            tree[node] += newValue;
	            return;
	        }
			int mid=(start+end)/2;
			
		
			update(start,mid,node*2 ,newValue, findIndex);
			update(mid+1,end,node*2+1 ,newValue, findIndex);
			tree[node]= tree[node*2] + tree[node*2+1];
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bz= new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        tree = new long[n * 4];

        int m = Integer.parseInt(st.nextToken());
        // buildTree(0, n - 1, 1, arr); // If not using initial array values, this can be omitted.

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                update(0, n - 1, 1, c, b - 1);
            } else {
                long mins = select(0, n - 1, 1, Math.min(b, c) - 1, Math.max(b, c) - 1);
               
                System.out.println(mins);
            }
        }
	}
}

