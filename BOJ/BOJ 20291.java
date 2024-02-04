import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str,".");
            String temp2 = st.nextToken();
            String temp = st.nextToken();
            if(!map.containsKey(temp)){
                list.add(temp);
                map.put(temp,1);
            }else{
                int value = map.get(temp);
                map.replace(temp,value+1);
            }
        }

        Collections.sort(list);
        for(String str : list){
            System.out.println(str+" "+map.get(str));
        }
    }
}