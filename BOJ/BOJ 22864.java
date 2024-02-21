import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a =scan.nextInt();
        int b=scan.nextInt();
        int c =scan.nextInt();
        int m=scan.nextInt();

        int tired =0;
        int work=0;
        for(int hour=1; hour<24; hour++){
            if(tired+a<=m){
                work-=b;
                tired+=a;
            }else{
                tired-=c;
                if(tired<0) tired=0;
            }
        }
        System.out.println(-work);
    }
}