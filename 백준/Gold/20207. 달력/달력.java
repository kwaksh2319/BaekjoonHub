import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		//수현이는 일녀의 날짜가 1일 ~ 365일
		//
		//연소된 두일자에 각각 일정이 1개 이상있다면 이를 연속되었다고 표현하자
		//연속된 모든 일정은 하나의 직사각형에 포함되어야한다
		//연속된 모든 일정을 모두 감싸는 가장 작은 직사각형의 크기만큼 코팅지를 오린다.
		
		//달라ㅕㄱ은 다음과 같은 규칙을 따른다ㅣ.
		
		//일정은 시작날짜와 종료날짜를 포함한다
		//시작일이 가장 앞선 일정부터 차례대로 채워진다
		int n=scan.nextInt();
		HashMap<Integer ,Integer>maps=new HashMap<>();
		for(int i=1;i<=365;i++) {
			maps.put(i,0);
		}
		for(int i=0;i<n;i++) {
			int start=scan.nextInt();
			int end=scan.nextInt();
			for(int j=start;j<=end;j++) {
				
				maps.put(j,maps.get(j)+1);
				
				
				//
			}
		}
		int h=0;
		int w=0;
		int mx=0;
		for(Integer key:maps.keySet()) {
			if(maps.get(key)>0) {
				w++;
				if(h<maps.get(key)) {
					h=maps.get(key);
				}
			}else {
				
				mx+=w*h;
				w=0;
				h=0;
				
			}
			//System.out.println(w+","+maps.get(key));
		}
		mx+=w*h;
		System.out.println(mx);
	}
}
