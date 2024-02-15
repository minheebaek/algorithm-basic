import java.util.*;
import java.io.*;

public class Main{
    static char[][] gragh;
    static boolean[][] visited;
    static int r,c;
    static int[] dirX={0,0,-1,1};
    static int[] dirY={-1,1,0,0};
    static int sheep,wolf;
    static int anssheep,answolf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        gragh=new char[r][c];
        visited =new boolean[r][c];

        for(int i=0;i<r;i++){
            String str =br.readLine();
            for(int j=0;j<c;j++){
                gragh[i][j]=str.charAt(j);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(gragh[i][j]=='o'&&!visited[i][j]){
                    visited[i][j]=true;
                    wolf=0;
                    sheep=1;
                    dfs(i,j);
                    if(sheep>wolf){
                        wolf=0;
                    }else{
                        sheep=0;
                    }
                    anssheep+=sheep;
                    answolf+=wolf;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                if(visited[i][j]==false){
                    if(gragh[i][j]=='v'){
                        visited[i][j]=true;
                        answolf++;
                    }
                }
            }
        }
        System.out.println(anssheep+" "+answolf);

    }
    static void dfs(int x, int y){
        for(int i=0;i<4;i++){
            int nowx=x+dirX[i];
            int nowy=y+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<r&&nowy<c){
                if(gragh[nowx][nowy]!='#'&&!visited[nowx][nowy]){
                    if(gragh[nowx][nowy]=='o'){
                        sheep++;
                    }
                    if(gragh[nowx][nowy]=='v'){
                        wolf++;
                    }
                    visited[nowx][nowy]=true;
                    dfs(nowx,nowy);
                }
            }
        }

    }
}