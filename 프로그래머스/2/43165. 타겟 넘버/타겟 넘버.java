import java.util.*;
class Solution {
   public static int[] gnumbers;
   public static int gtarget;
    public static boolean[] gbCheck;
    public static int gcnt=0;
    public Solution(){
        
    }
    
    public void dfs(int k,int sum,int cnt){
          
        if(cnt>=gnumbers.length){
            if(sum==gtarget){
                gcnt++;
            }
            
           // System.out.println(sum);
            return ;
        }
        dfs(k+1 , sum + gnumbers[k] , cnt+1 ); 
        dfs(k+1 , sum - gnumbers[k] , cnt+1 ); 
        /*
         for(int i=k;i<gnumbers.length;i++){
             if(gbCheck[ i ]==false){
                  gbCheck[ i ] = true;
                 
                  gbCheck[ i ] = false; 
             }
  
         }*/
        return;
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Solution s=new Solution();
        gnumbers=numbers;
        
        boolean[] bCheck=new boolean[gnumbers.length];
        gbCheck=bCheck;
        
        gtarget=target;
        
        s.dfs(0,0,0);
        answer=gcnt;
        return answer;
    }
}