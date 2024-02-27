import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();

        int[] arr=new int[1000001];
        boolean[] occur =new boolean[2000001];
        //18번째줄에 x-arr[i]이 1000000을 넘어갈 수 있기때문에 원래는 예외처리를 따로 해야하지만 그냥 2000000으로 하고 예외처리 하지 않는다.
        int ans=0;

        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int x=scan.nextInt();
        for(int i=0;i<n;i++){
            if(x-arr[i]>0&&occur[x-arr[i]]) ans++;
            occur[arr[i]] =true;
        }
        System.out.println(ans);
    }
}