
import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        ArrayList<Long>crains=new ArrayList<>();
        ArrayList<Long>boxs=new ArrayList<>();

        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            long crain=scan.nextLong();
            crains.add(crain);
        }

        int m=scan.nextInt();

        for(int i=0;i<m;i++){
            long box=scan.nextLong();
            boxs.add(box);
        }

        Collections.sort(crains);
        Collections.sort(boxs);
        Collections.reverse(crains);
        Collections.reverse(boxs);

        int i=0;
        int j=0;
        int gcnt=0;
        boolean bchk=false;
        while(!boxs.isEmpty()){

            if(boxs.get(i)<=crains.get(j)){
               // System.out.print(boxs.get(i));
               // System.out.print(crains.get(j));
                if( j==0 ){
                    gcnt++;
                }
                boxs.remove( i );

                j++;
                j = j%n;
                i=0;
            }else{
                if(j == 0){
                    bchk = true;
                    break;
                }
                i++;
            }

            if(i>boxs.size()-1){
                i=0;
                j=0;
            }

        }

        if(bchk==false){
            System.out.println(gcnt);
        }else{
            System.out.println(-1);
       }


    }
}