import java.util.*;
import java.io.*;
/** 4주차
 * 1.BOJ 10026
 * 2.BFS
 * 3.양방향 탐색 영역 구하기 -> BFS
 */

public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dirx={-1,0,1,0};
    static int[] diry={0,1,0,-1};
    // static char tempChar;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr=new char[n][n];
        visited =new boolean[n][n];

        for(int i=0;i<n;i++){
            String str =br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=str.charAt(j);
            }
        }
        int normal=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    normal++;
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    normal++;
                }

            }
        }
        int abnormal=0;
        visited =new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='G') arr[i][j]='R';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    abnormal++;
                }
            }
        }
        System.out.println(normal+" "+abnormal);
    }

    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y]=true;
        char tempChar=arr[x][y];

        while(!queue.isEmpty()){
            int curx=queue.poll();
            int cury=queue.poll();

            for(int i=0;i<4;i++){
                int nx=curx+dirx[i];
                int ny=cury+diry[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(visited[nx][ny]||tempChar!=arr[nx][ny]) continue;

                visited[nx][ny]=true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }
}