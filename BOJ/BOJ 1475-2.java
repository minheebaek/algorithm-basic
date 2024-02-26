import java.io.*;
//두번째 풀이 모범답안 참고함
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr=new int[10];
        while(num>0){
            arr[num%10]+=1;
            num/=10;
        }

        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(i==6||i==9) continue;
            max=Math.max(arr[i],max);
        }

        max=Math.max(max,(arr[6]+arr[9]+1)/2);
        System.out.println(max);
    }
}