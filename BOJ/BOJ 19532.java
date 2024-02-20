import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a =scan.nextInt();
        int b=scan.nextInt();
        int c =scan.nextInt();
        int d=scan.nextInt();
        int e =scan.nextInt();
        int f=scan.nextInt();

        boolean flag1=false;
        boolean flag2=false;

        for(int x=-999;x<1000;x++){
            for(int y=-999;y<10000;y++){
                if((a*x)+(b*y)==c){
                    flag1=true;
                }
                if((d*x)+(e*y)==f){
                    flag2=true;
                }
                if(flag1==true&&flag2==true){
                    System.out.println(x+" "+y);
                    return;
                }
                flag1=false;
                flag2=false;
            }
        }
    }
}