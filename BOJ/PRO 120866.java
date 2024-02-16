class Solution {
    static int[] dirx={0,0,-1,1,1,-1,1,-1};
    static   int[] diry={-1,1,0,0,1,-1,-1,1};

    static boolean[][] visited;
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length];

        //폭탄이 있는 부분 싹다 조회하고 폭탄 주변을 탐색해서 1로 만들기
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    check(i,j,board);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(visited[i][j]){
                    cnt++;
                }
            }
        }

        int answer =board.length*board.length ;
        return answer-cnt;
    }
    static void check(int x,int y,int[][] board){
        for(int k=0;k<8;k++){
            int nowx=x+dirx[k];
            int nowy=y+diry[k];

            if(nowx>=0&&nowy>=0&&nowx<board.length&&nowy<board.length){
                if(board[nowx][nowy]==0&&!visited[nowx][nowy]){
                    visited[nowx][nowy]=true;
                }
            }
        }
    }
}