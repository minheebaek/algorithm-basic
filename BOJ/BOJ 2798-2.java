import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int m=scan.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int temp = arr[i] + arr[j] + arr[k];
                    if(temp<=m){
                        ans=Math.max(temp,ans);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}