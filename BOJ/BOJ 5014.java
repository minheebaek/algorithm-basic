import java.util.*;
import java.io.*;

public class Main{
    static int[] floor;
    static boolean[] visited;
    static int[] temp;
    static int F,S,G,U,D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        floor = new int[F+1];
        visited = new boolean[F+1];
        temp = new int[] {U,-D};


        bfs(S);
    }

    public static void bfs(int S){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        floor[S] = 0;

        while(!queue.isEmpty()){
            int cur=queue.poll();

            if(cur == G){
                System.out.println(floor[cur]);
                return;
            }
            for(int i=0; i<2; i++){
                int nowfloor = cur+temp[i];
                if(nowfloor>=1 && nowfloor<=F){
                    if(!visited[nowfloor]){
                        queue.add(nowfloor);
                        visited[nowfloor]=true;
                        floor[nowfloor] = floor[cur]+1;

                    }
                }
            }

        }
        System.out.println("use the stairs");
    }
}