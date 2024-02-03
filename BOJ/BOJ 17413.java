import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        boolean flag = false;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(str.charAt(i));
                continue;
            }
            if(str.charAt(i)=='>'){
                flag=false;
                sb.append(str.charAt(i));
                continue;
            }
            if(flag == true){
                sb.append(str.charAt(i));
            }

            if(flag == false){
                if(str.charAt(i)==' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }else{
                    stack.push(str.charAt(i));
                }
            }

            if(i==str.length()-1){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }

        }
        System.out.println(sb.toString());
    }
}

