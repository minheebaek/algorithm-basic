import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        int[] arr =new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-97]+=1;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}