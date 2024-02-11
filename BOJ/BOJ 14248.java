import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int count=1;
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        arr=new int[n+1];
        visited=new boolean[n+1];

        for(int i=1; i<=n; i++){
            arr[i]=scan.nextInt();
        }
        int s= scan.nextInt();
        bfs(s);
        System.out.println(count);
    }
    static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s]=true;

        while(!queue.isEmpty()){
            int x=queue.poll();

            if(x+arr[x]>=1&&x+arr[x]<=n&&!visited[x+arr[x]]){
                visited[x+arr[x]]=true;
                queue.add(x+arr[x]);
                count++;
            }
            if(x-arr[x]>=1&&x-arr[x]<=n&&!visited[x-arr[x]]){
                visited[x-arr[x]]=true;
                queue.add(x-arr[x]);
                count++;
            }
        }
    }
}
