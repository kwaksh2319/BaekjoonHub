import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	Scanner scan=new Scanner(System.in);
        	int h=scan.nextInt();//4
        	int w=scan.nextInt();//8
        	int block[]=new int[w];
        	int start=0;
        	int end=0;
        	int min=0;
        	for(int i=0;i<w;i++) {
        		block[i]=scan.nextInt();
        	}
        	 int answer = 0;
        	
        	 for (int i = 1; i < w - 1; i++) {
                 int leftMax = 0;
                 int rightMax = 0;
                 
                 for (int j = 0; j < i; j++) {
                     leftMax = Math.max(leftMax, block[j]);
                 }

                 for (int j = i + 1; j < w; j++) {
                     rightMax = Math.max(rightMax, block[j]);
                 }

                 int water = Math.min(leftMax, rightMax) - block[i];
                 if (water > 0) {
                     answer += water;
                 }
             }
             System.out.println(answer);
        
    }
    
}
