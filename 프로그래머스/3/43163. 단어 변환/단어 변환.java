import java.util.*;
class Solution {
    public static String gbegin;
    public static String gtarget;
    public static String[] gwords;
    public static boolean[] gbCheck;
     public static int gn=0;
   public static int gmincnt=0;
    public Solution(){
        
    }
    
    void dfs(String start,int t ){
     
        
        for(int k=0;k<gwords.length;k++){
               int cnt=0;
               int anw=0;
            // System.out.println(gwords.length);
            // System.out.println(gn);
            if(gbCheck[k]==false){
                for(int i=0;i<gn;i++){
                    if( start.charAt(i) == gtarget.charAt(i)){
                        anw++;
                     }
                    
                    if( start.charAt(i) == gwords[k].charAt(i)){
                        cnt++;
                     }
                
                }
                    if(anw==gn){
                        if(gmincnt==0){
                            gmincnt=t;
                        }else {
                            if(gmincnt>t){
                                gmincnt=t;
                            }
                        }
                         return ;
                    }
                    if(cnt==gn-1){
                        gbCheck[k]=true;
                        dfs(gwords[k],t+1) ;   
                        gbCheck[k]=false;
                    }
        
                    
            }
             
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        gbegin=begin;
        gtarget=target;
        gwords=words;
        Solution s= new Solution();
         boolean[] bCheck=new boolean[words.length];
         gbCheck=bCheck;
         gn=begin.length();
        s.dfs(begin,0);
        answer=gmincnt;
        return answer;
    }
}