
import java.util.*;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class Main {
	public static int n=9;
	public static int [][]maps=new int[n][n];
	
	private static boolean isBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (maps[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public static boolean isRow(int r,int num) {
		for(int i=0;i<9;i++) {
			 if(maps[r][i]==num) {
				 return true;
			 }
		}
		return false;
	}
	 private static boolean isCol(int col, int number) {
	        for (int i = 0; i < n; i++) {
	            if (maps[i][col] == number) {
	                return true;
	            }
	        }
	        return false;
	    }
	public static boolean check(int i, int j, int number) {
		return !isRow(i,number)&&!isBox(i,j,number) && !isCol(j, number);
	}
	
	
	public static boolean backtracking() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if( maps[i][j]==0 ) {
					for( int num=1;num<=n;num++ ) {
						if( check( i,j,num ) == true ) {
							maps[i][j]=num;
							
							
							if( backtracking() == true ) {
								return true;
							}else {
								maps[i][j]=0;
							}
						}
					}
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan =new Scanner(System.in);
        //스도쿠는 18세기 스위스 수학자가 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 
		//현재 많은 인기를 누리고 있다
		//게임은 아래 그림과 같이 가로,세로 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판위에서 
		//1~9까지이의 숫자 중 하나가 쓰여잇다.
		
		//1 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한번씩만 나타나야 한다.
		//2 굵은 선으로 구분되는 잇는 3x3 안에서는 1부터 9까지 한번씩 나타나야한다
		
	    
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) 
	    	{
	    		maps[i][j]=scan.nextInt();
	    	}
	    }
	    if(backtracking()==true) {
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n;j++) {
	    			System.out.print(maps[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    }	
	}
}
