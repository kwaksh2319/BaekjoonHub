import java.util.*;
class Solution {
    public static int gn;
    public static int gcomputers[][];
    public static boolean gbCheck[];
     public static int gcnt;
    public Solution(){
        
    }
    void dfs(int k){
         gbCheck[k]=true;
     //  System.out.println(k);
        for(int i=0;i<gcomputers[k].length;i++){
            if(gbCheck[i]==false&&gcomputers[k][i]==1){
                
                dfs(i);
            }
            
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 1 1 0
        // 1 1 0
        // 0 0 1
        gcomputers=computers;
        boolean bCheck[]=new boolean[computers.length];
        gbCheck=bCheck;
        gn=n;
        
        Solution s=new Solution();
        for(int i=0;i<n;i++){
            if(gbCheck[i]==false&&gcomputers[i][i]==1){
                 gcnt++;
                 s.dfs(i);  
            }
        }
        answer=gcnt;
        
        
        return answer;
    }
}