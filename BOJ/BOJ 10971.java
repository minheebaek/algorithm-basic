import java.util.*;
import java.io.*;

public class Main {
    static int[][] city;
    static boolean[] visited;
    static int N;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        city=new int[N][N];
        visited=new boolean[N]; //도시 방문 여부 체크

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        visited[0]=true;
        dfs(0,0);
        System.out.println(ans);
    }
    static void dfs(int now, int cost){
        //도시를 다 탐방하면 다시 처음 도시로 돌아와야함
        if(allVisited()){
            if(city[now][0]>0){ //처음 도시로 갈수있으면
                ans=Math.min(ans,cost+city[now][0]); //최소비용 갱신
            }
        }
        for(int i=1; i<N;i++){ //다음 도시 탐색
            if(!visited[i]&&city[now][i]>0){
                visited[i]=true;
                dfs(i,cost+city[now][i]);
                //경로 다 탐색했으면 visited[i]=false 해서 다른 경로도 구할 수 있어야함
                visited[i]=false;
            }
        }
    }
    static boolean allVisited(){
        for(int i=0; i<N; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

}
