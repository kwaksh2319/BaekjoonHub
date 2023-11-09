import java.util.*;

import java.lang.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();
        int xsize=x.length();
        int ysize=y.length();

        int lists[][]=new int[xsize+1][ysize+1];

        for(int i=0;i<xsize+1;i++) {

            for(int j=0;j<ysize+1;j++) {
                lists[i][j]=0;

            }

        }

        for(int i=0;i<xsize+1;i++) {
            for(int j=0;j<ysize+1;j++) {
                if(i==0||j==0){
                    continue;
                }
                if(x.charAt(i-1)==y.charAt(j-1)){
                   lists[i][j]=lists[i-1][j-1]+1;
                }
                else{
                   lists[i][j]= Math.max( lists[i-1][j], lists[i][j-1] );
                }
            }
        }
        String str="";
        while(xsize!=0&&ysize!=0){



            if(lists[xsize-1][ysize] == lists[xsize][ysize]){

                    xsize-=1;

            }else if(lists[xsize][ysize-1] == lists[xsize][ysize]){

                    ysize-=1;

            }else{
                if(x.charAt( xsize-1 ) == y.charAt( ysize-1 ) ){
                    str+= Character.toString(x.charAt( xsize-1 ));
                }
                xsize-=1;
                ysize-=1;

            }


        }
        System.out.println(str.length());
        String tmp="";
        for(int i=str.length()-1;i>=0;i--){
            tmp+=str.charAt(i);
           // System.out.print(str.charAt(i));
        }
        if(str.length()>0){
            System.out.println(tmp);
        }
    }
}