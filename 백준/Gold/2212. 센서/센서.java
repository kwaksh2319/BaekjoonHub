import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		//세로 두줄 카로로 n개으로 이루어진 표가 있다.
		//첫째줄의 각칸에는 1,2,...n 이 차례 대로 들어 있고 
		//둘째 칸에는 1아ㅣ상 n이하 정수가 들어 있다.
		//첫쨰줄에서 숫자를 적절히 뽑으면 , 그 뽑힌 정수들이 이루는 집하과 뽑힌 정수들의 바로 밑의 둘쨰 줄에 들어 있는 정수들이 이루는 
		//집합이 일치한다.
		//이러한 조건을 만족시키도록 정수들을 뽑되 최대로 많이 뽑는 방법을 찾아라
		Scanner scan=new Scanner(System.in);
		//N개 센서를 설치하였다.
		int n=scan.nextInt();
		int k=scan.nextInt();
		ArrayList<Integer> lists=new ArrayList<>();
		HashMap<Integer,Integer>maps=new HashMap<>();
		ArrayList<Integer>gap=new ArrayList<>();
		if(k>=n) {
			System.out.println(0);
		}else {
			for(int i=0;i<n;i++)
			{
				int tmp = scan.nextInt();
				lists.add(tmp);
			}
			
			Collections.sort(lists);
			//System.out.println(lists);
			for(int i=0;i<n-1;i++) {
				gap.add(lists.get(i+1)-lists.get(i));
			}
			Collections.sort(gap);
			Collections.reverse(gap);
			//System.out.println(gap);
			int gapsum=0;
			for(int i=0;i<k-1;i++) {
				gapsum+=gap.get(i);
			}
			//System.out.println(gapsum);
			
			int result=lists.get(lists.size()-1)-lists.get(0)-gapsum;
			System.out.println(result);
		}
		
		
	}
}