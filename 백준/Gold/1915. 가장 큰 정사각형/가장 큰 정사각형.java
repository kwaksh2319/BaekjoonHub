
import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [][]maps=new int[n][m];
        scan.nextLine();
        for(int i=0;i<n;i++){
            String tmp=scan.nextLine();
            for(int j=0;j<tmp.length();j++){
                maps[i][j]=tmp.charAt(j)-'0';
            }
        }

        int [][]dp=new int[n][m];
        int gcnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i][j]==1){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                
                }
                gcnt=Math.max(gcnt,dp[i][j]);
            }
        }

        System.out.print(gcnt*gcnt);
    }
}