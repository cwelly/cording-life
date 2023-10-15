import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toUpperCase(Locale.ROOT);
        HashMap<Character , Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }
            else{
                map.put(a,1);
            }
            if(map.get(a)>max){
                max = map.get(a);
            }
        }
        char answer = '0';
        for (Character key : map.keySet()){
            if(map.get(key)==max){
                if(answer!='0'){
                    System.out.println("?");
                    return;
                }
                answer= key;
            }
        }
        System.out.println(answer);

    }
}
