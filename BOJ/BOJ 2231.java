import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            int sum=i;
            String temp =i+"";
            for(int j=0;j<temp.length();j++){
                sum+=temp.charAt(j)-'0';
            }
            if(sum==n){
                System.out.println(i);
                return;
            }
            if(i==n-1){
                System.out.println("0");
            }
        }
    }
}