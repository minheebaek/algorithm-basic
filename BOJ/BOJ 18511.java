import java.io.*;
import java.util.*;

public class Main{
    static int N, K, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        String str = br.readLine();
        st = new StringTokenizer(str);

        for(int i=0; i<K;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순으로 정렬되어있음
        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int num){
        if(num>N) return; //목표금액보다 큰경우 종료
        if(num>ans) ans=num;

        for(int i=K-1;i>=0; i--){
            dfs((num*10)+arr[i]);
        }
    }

}