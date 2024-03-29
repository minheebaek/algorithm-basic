import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack =new Stack<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order=st.nextToken();
            if(st.hasMoreTokens()){
                int num=Integer.parseInt(st.nextToken());
                stack.push(num);
            }

            if(order.equals("pop")){
                if(stack.empty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.pop());
                }
            }
            if(order.equals("size")){
                System.out.println(stack.size());
            }
            if(order.equals("empty")){
                if(stack.empty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }
            if(order.equals("top")){
                if(stack.empty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.peek());
                }
            }
        }

    }
}