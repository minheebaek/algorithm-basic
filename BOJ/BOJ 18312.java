import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int m=scan.nextInt();
        int count=0;

        for(int hh=0;hh<=n;hh++){
            for(int mm=0;mm<60;mm++){
                for(int ss=0;ss<60;ss++){
                    String time=((hh<10)?"0"+hh:hh+"")+((mm<10)?"0"+mm:mm+"")+((ss<10)?"0"+ss:ss+"");
                    if(time.contains(m+""))count++;
                }
            }
        }
        System.out.println(count);
    }
}