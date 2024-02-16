import java.util.*;

public class Main{
    static int n,k;
    static HashSet<String> check =new HashSet<>();
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();

        arr=new int[n]; //카드 담아놓을 배열
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        dfs(0,"");
        System.out.println(check.size());
    }
    static void dfs(int cnt, String str){
        if(cnt==k) {
            check.add(str);
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            visited[i]=true;
            dfs(cnt+1,str+arr[i]);
            visited[i]=false;
        }
    }

}