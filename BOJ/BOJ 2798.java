import java.util.*;

public class Main{
    static int[] arr;
    static boolean[] visited;
    static int ans,sum,n,m;
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        n = scan.nextInt();
        m=scan.nextInt();
        arr =new int[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        dfs(0,0);
        System.out.println(ans);
    }
    static void dfs(int cnt,int sum){

        for(int i=0; i<n;i++){
            if(cnt==3){
                if(sum<=m) {
                    ans = Math.max(sum, ans);
                }
                return;
            }
            if(!visited[i]){
                visited[i]=true;
                dfs(cnt+1,sum+arr[i]);
                visited[i]=false;
            }
        }

    }
}