import java.util.*;
class Solution {
    int truck;
    int count;
    public Solution(){
       
    }
    public Solution(int truck,int count){
        this.truck=truck;
        this.count=count;
    }
    public void setCount(int count){
        this.count=count;
    }
    public void  setTruck(int truck){
        this.truck=truck;
    }
    public int getCount(){
        return this.count;
    }
    public int getTruck(){
       return this.truck;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
      
        int answer =0;
        //트럭 여러대가 강을 가로지르는 일차선 다리를 정해진 순으로 지나갑니다.
        //7,4,5,6
        //bridge_length 다리에 올라갈 수 있는 트럭 수 bridge_length
        //weight 다리가 견디는 무게
        //truck_weights
        Queue<Solution> trucks=new LinkedList<Solution>();
          LinkedList<Solution> bridge = new LinkedList<Solution>();
     
        for(int i=0;i<truck_weights.length;i++){
            trucks.add(new Solution(truck_weights[i],0));
        }
        int count=1;
        int now=0;
        Solution tmp;
        boolean ttt=false;
        boolean bbb=false;
        while(trucks.size()>0||bridge.size()>0){
            //대기트럭
            //다리 비었는지 체크
            
          // System.out.println(count);
            answer++;
            
            
            if(!bridge.isEmpty()){
                //잇는경우
               //기존 bridge count+1 
                int n=0;
               for(int i=0;i<bridge.size();i++){
                   bridge.get(i).setCount( bridge.get(i).getCount()+1 );
                   //System.out.println(bridge.get(i).getTruck());
                   if( bridge.get(i).getCount() > bridge_length){
                       
                       n++;
                   }
               }
                 //카운트가 넘을시 bridge out 
                for(int i=0;i<n;i++){
                     now-=bridge.get(0).getTruck();
                     bridge.remove(0);
                }
                
                if(trucks.size()>0){
                     Solution start=trucks.peek();

                    //무게체크
                    if(now+start.getTruck() <= weight){
                        now+=start.getTruck();
                        start.setCount(1);
                        bridge.add(start);
                        trucks.poll();
                    }else{
                        //System.out.println("x");
                    }
                }else{
                    //System.out.println("x");
                }
               
              
            }else{
                //없는경우->add
               
                Solution start=trucks.peek();
                trucks.poll();
                now+=start.getTruck();
                //System.out.println(now);
                start.setCount(1);
                bridge.add(start);
            }
             
             
        }
        return answer;
    }
}