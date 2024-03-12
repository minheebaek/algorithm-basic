import java.util.*;
import java.io.*;

/**
 * pos를 활용해서 pop, size, top 등을 구했다. pop에서 pos--;만 하면 stack[pos]에 원소가 있는 상태니까 top했을때 잘못하면
 * 최상위 원소가 그대로 나오는거 아니야? 했는데 top에선 pos-1하니까 그럴 일은 발생하지 않는다.
 * stack 사이즈는 pos 값과 일치한다는 사실도 기억하자
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int pos=0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order=st.nextToken();
            if(st.hasMoreTokens()){
                int num=Integer.parseInt(st.nextToken());
                arr[pos++]=num;
            }
            if(order.equals("pop")) {
                if(pos==0){
                    System.out.println("-1");
                }else{
                    System.out.println(arr[pos-1]);
                    pos--;
                }
            }
            if(order.equals("size")){
                System.out.println(pos);
            }
            if(order.equals("empty")){
                if(pos==0){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }
            if(order.equals("top")){
                if(pos>0){
                    System.out.println(arr[pos-1]);
                }else{
                    System.out.println("-1");;
                }
            }
        }
    }
}