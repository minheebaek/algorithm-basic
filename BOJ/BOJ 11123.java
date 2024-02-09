import java.util.*;
import java.io.*;

public class Main {
    static int H,W;
    static Character[][] grid;
    static int[] dirX ={0,0,-1,1};
    static int[] dirY={-1,1,0,0};
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            grid = new Character[H][W];
            visited = new boolean[H][W];
            count =0;
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = str.charAt(j);
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && grid[i][j] == '#') {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visited[i][j]=true;
        while(!queue.isEmpty()){
            int x=queue.poll();
            int y=queue.poll();

            for(int k=0; k<4; k++){
                int nx =x+dirX[k];
                int ny =y+dirY[k];

                if(nx>=0&&ny>=0&&nx<H&&ny<W){
                    if(!visited[nx][ny] && grid[nx][ny]=='#'){
                        visited[nx][ny]=true;
                        queue.add(nx);
                        queue.add(ny);
                    }
                }
            }
        }
    }
}