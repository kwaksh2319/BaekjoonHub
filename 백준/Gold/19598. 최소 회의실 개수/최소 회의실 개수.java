import java.util.*;
import java.io.*;
public class Main {
	public static void Prints(PriorityQueue<Meetings>q){

	}
	public static class Meetings{
		public int start;
		public int end;
		public Meetings(int start, int end){
			this.start=start;
			this.end=end;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Comparator<Meetings> comparator =new Comparator<Meetings>(){
			@Override
			public int compare(Meetings m1, Meetings m2){
				if(m1.start<m2.start){
					return -1;
				}else if(m1.start>m2.start) {
					return 1;
				}
				return 0;
			}
		};
		Comparator<Meetings> comparator2 =new Comparator<Meetings>(){
			@Override
			public int compare(Meetings m1, Meetings m2){
				if(m1.end<m2.end){
					return -1;
				}else if(m1.end>m2.end) {
					return 1;
				}
				return 0;
			}
		};

		PriorityQueue<Meetings>q=new PriorityQueue<>(comparator);
		for(int i=0;i<n;i++){
			int start=scan.nextInt();
			int end=scan.nextInt();
			q.add(new Meetings(start,end));
		}

		PriorityQueue<Meetings>save=new PriorityQueue<>(comparator2);

		while (!q.isEmpty()){
			Meetings mstart=q.peek();
			q.poll();
			//System.out.println(mstart.start+","+mstart.end);
			//for(int i=0; i<save.size(); i++){
			if(save.size()>0){
				if( save.peek().end <= mstart.start ){
					save.poll();
					//	break;
				}
			}


			save.add(mstart);

		}
		System.out.println(save.size());
	}
}