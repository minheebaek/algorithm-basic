import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[11];
        int change = 0;
        for(int i=0; i<=10; i++){
            arr[i] = -1;
        }
        for(int i=0; i<N; i++){
            int cow = scan.nextInt();
            int road = scan.nextInt();
            if(arr[cow]==-1){
                arr[cow] = road;
            }else{
                if(road!=arr[cow]){
                    change++;
                    arr[cow] = road;
                }
            }
        }
        System.out.println(change);
    }
}