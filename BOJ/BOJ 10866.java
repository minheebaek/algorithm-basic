import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();


        for(int i=0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.size()>0){
                        System.out.println(deque.remove());
                        break;
                    }else{
                        System.out.println("-1");
                        break;
                    }

                case "pop_back":
                    if(deque.size()>0){
                        System.out.println(deque.removeLast());
                        break;
                    }else{
                        System.out.println("-1");
                        break;
                    }
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        System.out.println("1");
                        break;
                    }else{
                        System.out.println("0");
                        break;
                    }
                case "front":
                    if(deque.size()>0){
                        System.out.println(deque.peek());
                        break;
                    }else{
                        System.out.println("-1");
                        break;
                    }
                case "back":
                    if(deque.size()>0){
                        System.out.println(deque.peekLast());
                        break;
                    }else{
                        System.out.println("-1");
                        break;
                    }

            }
        }
    }
}