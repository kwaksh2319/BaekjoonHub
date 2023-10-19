import java.util.*;
class Solution {
    private int i;
    private int j;
    private int cnt;
    public Solution(){
        
    }
    public Solution(int i,int j,int cnt){
        this.i=i;
        this.j=j;
        this.cnt=cnt;
    }
    public int idata(){
        return this.i;
    }
    
    public int jdata(){
        return this.j;
    }
    public int cntdata(){
        return this.cnt;
    }
    public void idata(int i){
         this.i=i;
    }
    
    public void jdata(int j){
       this.j=j;
    }
    public void cntdata(int cnt){
       this.cnt=cnt;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        //ror 게임은 두팀으로 나누어서 진행하며,
        //상대 팀 진영을 먼저 파괴하면 이기는 게임 입니다.
        //따라서 각 팀은 상대팀 진영에 최대한 빨리 도착하는것이 유리합니다.
        //ror
        int diri[]={1,-1,0,0};
        int dirj[]={0,0,1,-1};
        Queue<Solution> q=new LinkedList<>();
        int n=maps.length;
        int m=maps[0].length;
       boolean[][] bVisisted=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i][j]==0){
                    bVisisted[i][j]=true;
                }
            }
        }
   
        q.add(new Solution (0,0,1));
        bVisisted[0][0]=true;
        boolean end=false;
        int cnt=0;
        while(!q.isEmpty()){
            Solution start=q.peek();
         //   System.out.println(start.idata()+":"+start.jdata()+":"+start.cntdata());
            q.poll();
            if(end==true){
               
                break;
            }
           
            
            cnt++;
            for(int i=0;i<4;i++){
              int tmpDiri=start.idata()+diri[i];
              int tmpDirj=start.jdata()+dirj[i];
                if(tmpDiri==-1||tmpDirj==-1||tmpDiri>=n||tmpDirj>=m){
                    continue;
                }
                if(bVisisted[tmpDiri][tmpDirj]==true){
                    continue;
                }
                q.add(new Solution(tmpDiri,tmpDirj, start.cntdata() + 1 ));
                bVisisted[tmpDiri][tmpDirj]=true;
                if(tmpDiri==n-1 &&tmpDirj==m-1){
                    i=4;
                    answer=start.cntdata() + 1;
                    end=true;
                    continue;
                }
              
            }
        }
        
        if(end==false){
            answer=-1;
        }
        
        return answer;
    }
}