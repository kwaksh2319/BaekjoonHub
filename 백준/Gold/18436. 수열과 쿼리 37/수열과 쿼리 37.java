
import java.util.*;
import java.io.*;
public class Main {
	public static int n;
	public static int m;
	public static long tree[];
	public static void initTree(long arr[]){
		buildingTree(0, n - 1, 1, arr);
	}

	public static long buildingTree(int start, int end, int node, long arr[]){
		if(start == end){
			if(arr[start] % 2 == 0) {
				return tree[node] = 1;
			} else {
				return tree[node] = 0;
			}
		}

		int mid = (start + end) / 2;
		return tree[node] = buildingTree(start, mid, node * 2, arr) + buildingTree(mid + 1, end, node * 2 + 1, arr);
	}

	public static long updateTree(int start, int end, int node, long newValue, int findIndex){
		if(findIndex < start || findIndex > end){
			return tree[node];
		}

		if(start == end){
			if(newValue % 2 == 0) {
				return tree[node] = 1;
			} else {
				return tree[node] = 0;
			}
		}

		int mid = (start + end) / 2;
		return tree[node] = updateTree(start, mid, node * 2, newValue, findIndex) + updateTree(mid + 1, end, node * 2 + 1, newValue, findIndex);
	}

	public static long select(int start, int end, int node, int left, int right){
		if(left > end || right < start){
			return 0;
		}

		if(left <= start && end <= right){
			return tree[node];
		}

		int mid = (start + end) / 2;
		return select(start, mid, node * 2, left, right) + select(mid + 1, end, node * 2 + 1, left, right);
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		long arr[] = new long[n];
		for(int t = 0; t < n; t++){
			arr[t] = scan.nextLong();
		}
		 
		m = scan.nextInt();
		tree = new long[n * 4];
		initTree(arr);

		for(int t = 0; t < m; t++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if(a == 1){
				// update
				if(arr[b - 1] % 2 == 1 && c % 2 == 0) {
					updateTree(0, n - 1, 1, c, b - 1);
				} else if(arr[b - 1] % 2 == 0 && c % 2 == 1){
					updateTree(0, n - 1, 1, c, b - 1);
				}
				arr[b - 1] = c;
			} else if(a == 2){
				// select
				long query = select(0, n - 1, 1, b - 1, c - 1);
				System.out.println(query);
			} else if(a == 3){
				// select
				long query = select(0, n - 1, 1, b - 1, c - 1);
				System.out.println((c - b + 1) - query);
			}
		}
	}
}
