import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        int[] arr=new int[10];

        for(int i=0;i<str.length(); i++){
            int num =str.charAt(i)-'0';
            if(num==9){
                num=6;
            }
            arr[num]+=1;
        }

        if(arr[6]%2==1){
            arr[6]=arr[6]/2+1;
        }else{
            arr[6]=arr[6]/2;
        }
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }

        System.out.println(max);
    }
}