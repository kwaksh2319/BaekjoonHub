
import java.util.*;
import java.io.*;
public class Main {
	public static int matrix[][];
	public static int copyMatrix[][];
	public static int r;
	public static int c;
	public static int n;
	public static int m;
	public static int k;

	public static class Data{
		public int index;
		public int cnt;
		public Data(int index,int cnt){
			this.index=index;
			this.cnt=cnt;
		}
	}
	public static boolean Checking(int [][]matrix,int cnt){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(r==i&&c==j){
					if(matrix[r][c]==k){
						//System.out.println();
						System.out.println(cnt);
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void PrintMatrix(int [][]matrix){
		System.out.println();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void PrintData(ArrayList<Data>datas){
		for(int i=0;i<datas.size();i++){
			System.out.print("["+datas.get(i).index+","+datas.get(i).cnt+"]"+",");
		}
		System.out.println();

	}
	public static ArrayList<Data> Sorting(ArrayList<Data>datas){
		Collections.sort(datas,  new Comparator<Data>() {
			@Override
			public int compare(Data d1, Data d2) {
				if(d1.cnt>d2.cnt){
					return 1;
				}else if(d1.cnt==d2.cnt){
					if(d1.index>d2.index){
						return 1;
					}else{
						return -1;
					}

				}else if(d1.cnt < d2.cnt){
					return -1;
				}
				return 0;
			}
		});

		return datas;
	}

	public static boolean MakeMatrix(ArrayList<ArrayList<Integer>>gdatas , boolean bRow ,int cnts){
		int imaxs=0;
		int jmaxs=0;
		for(int i=0;i<gdatas.size();i++){
			imaxs=Math.max(gdatas.size(),imaxs);
			for(int j=0;j<gdatas.get(i).size();j++){
				jmaxs=Math.max(gdatas.get(i).size(),jmaxs);
			}

		}
	//	System.out.println("imaxs:"+imaxs+","+"jmaxs"+jmaxs); //3 6

		if(bRow==true){
			matrix=new int[imaxs][jmaxs];
			n=imaxs;
			m=jmaxs;
		}else{
			matrix=new int[jmaxs][imaxs];
			n=jmaxs;
			m=imaxs;
		}

		for(int i=0;i<gdatas.size();i++){
			for(int j=0;j<gdatas.get(i).size();j++){
				//0 0  0 0
				//1 0  0 1
				// 2 0  0 2
				if(bRow==true){
					matrix[i][j]=gdatas.get(i).get(j);
				}else{
					matrix[j][i]=gdatas.get(i).get(j);
				}

			}
		}
		// PrintMatrix(matrix);
		 return Checking(matrix,cnts);
	}

	public static boolean RowCalculate(boolean bRow,int cnts){
		//row sort
		//System.out.println();
		ArrayList<ArrayList<Integer>>gdatas=new ArrayList<>();
		//System.out.println(n+","+m);
		for(int i=0;i<n;i++){
			ArrayList<Data>datas=new ArrayList<>();

			for(int j=0;j<m;j++){
				int tmp=matrix[i][j];
				boolean bCheck=false;

				for(int s=0;s<datas.size();s++){
					if(datas.get(s).index==tmp&&tmp!=0){
						bCheck=true;
						int tmpcnt=datas.get(s).cnt;
						datas.get(s).cnt=tmpcnt+1;
						break;
					}

				}
				if(bCheck==false&&tmp!=0){
					datas.add(new Data(tmp,1));
				}

			}


			//sorting
			//ArrayList<Data> tmpdatas=new ArrayList<>();
			Sorting(datas);
			//makematrix
			//PrintData(datas);

			ArrayList<Integer>tmpDatas=new ArrayList<>();

			for(int s=0;s<datas.size();s++){

				tmpDatas.add(datas.get(s).index);
				tmpDatas.add(datas.get(s).cnt);
			}
			gdatas.add(tmpDatas);

			//System.out.println();
		}

		return 	MakeMatrix(gdatas,bRow,cnts);

	}
	public static boolean ColumCalculate(boolean bRow,int cnts){
		//row sort

		ArrayList<ArrayList<Integer>>gdatas=new ArrayList<>();

		for(int i=0;i<m;i++){
			ArrayList<Data>datas=new ArrayList<>();

			for(int j=0;j<n;j++){
				int tmp=matrix[j][i];
				boolean bCheck=false;

				for(int s=0;s<datas.size();s++){
					if(datas.get(s).index==tmp&&tmp!=0){
						bCheck=true;
						int tmpcnt=datas.get(s).cnt;
						datas.get(s).cnt=tmpcnt+1;
						break;
					}

				}
				if(bCheck==false&&tmp!=0){
					datas.add(new Data(tmp,1));
				}

			}


			//sorting
			//ArrayList<Data> tmpdatas=new ArrayList<>();
			Sorting(datas);
			//makematrix
			//PrintData(datas);

			ArrayList<Integer>tmpDatas=new ArrayList<>();

			for(int s=0;s<datas.size();s++){

				tmpDatas.add(datas.get(s).index);
				tmpDatas.add(datas.get(s).cnt);
			}
			gdatas.add(tmpDatas);

			//System.out.println();
		}

		return MakeMatrix(gdatas,bRow,cnts);

	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		 r=scan.nextInt()-1;
		 c=scan.nextInt()-1;
		 k=scan.nextInt(); //anw
		n=3;
		m=3;

		matrix=new int[n][m];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matrix[i][j]=scan.nextInt();
			}
		}

		boolean bCheck= Checking(matrix,0);
		//System.out.println(r+","+c);
		for(int i=1;i<=100;i++){
			if(bCheck==true){

				break;
			}
			if(n>=m){
				//r cal
				bCheck=RowCalculate(true,i);
			}else{
				//c cal
				bCheck=ColumCalculate(false,i);
				//ColumCalculate();
			}
		}
		if(bCheck==false){
			System.out.println(-1);
		}

	}
}