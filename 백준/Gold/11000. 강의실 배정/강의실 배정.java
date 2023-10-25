import java.io.*;
import java.util.*;
public class Main {
	private int start;
	private int end;
	public Main() {
		
	}
	public Main(int start,int end) {
		this.start=start;
		this.end=end;
	}
	public void start(int start) {
		this.start=start;
	}
	public void end(int end) {
		this.end=end;
	}
	public int start() {
		return this.start;
	}
	public int end() {
		return this.end;
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		ArrayList<Main>lists=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int s=scan.nextInt();
			int e=scan.nextInt();
			lists.add(new Main(s,e));
		}
		Comparator<Main> cmp=(a,b)->{
			if(a.start()==b.start()) {
				return Integer.compare(a.end,b.end);
			}
			return Integer.compare(a.start,b.start);
		};
		
		
		Comparator<Integer>gr=(a,b)->Integer.compare(a, b);
		
		Collections.sort(lists,cmp);
		PriorityQueue<Integer>q=new PriorityQueue<>(gr);
		for(int i=0;i<n;i++) {
			if(q.isEmpty()) {
				q.add(lists.get(i).end());
			}else {
				if(q.peek()<=lists.get(i).start) {
					q.poll();
					q.add(lists.get(i).end());
				}else {
					q.add(lists.get(i).end());
				}
			}
			
		}
		System.out.print(q.size());
	}
	
}