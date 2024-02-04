import java.io.*;

public class Main{
    static int N;
    static int[] dirX ={0,0,-1,1};
    static int[] dirY ={-1,1,0,0};
    static char[][] area;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){//정상
            String str=br.readLine();
            for(int j=0; j<N; j++){
                area[i][j]=str.charAt(j);
            }
        }
        int normal =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    visited[i][j]=true;
                    dfs(i,j);
                    normal++;
                }
            }
        }


        visited = new boolean[N][N];

        for(int i=0; i<N; i++){ //비정상
            for(int j=0; j<N; j++){
                if(area[i][j]=='G'){
                    area[i][j]='R';
                }
            }
        }
        int abnormal=0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                    abnormal++;
                }
            }
        }

        System.out.println(normal+" "+abnormal);
    }
    public static void dfs(int x, int y){
        char tempchar = area[x][y];
        for(int i=0; i<4; i++){
            int nowx=x+dirX[i];
            int nowy=y+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<N&&nowy<N){
                if(!visited[nowx][nowy]&&area[nowx][nowy]==tempchar){
                    visited[nowx][nowy]=true;
                    dfs(nowx,nowy);
                }
            }
        }
    }
}