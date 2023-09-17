import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static String s;
    static String t;
    static HashSet<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        hs = new HashSet<>();
        answer= 0;
        s = (st.nextToken());
        st= new StringTokenizer(bf.readLine());
        t= st.nextToken();
//        System.out.println(t.charAt(0));
        dfs(t);
        System.out.println(answer);

    }
    static void dfs(String ex){

        if(s.equals(ex)){
            answer=1;
            return;
        }
        if(answer==1 || ex.length()<=s.length()){
            return;
        }
//        hs.add(ex);
        // 처음이 B라면 B를 지우고 뒤집는거 가능
        if(ex.charAt(0) == 'B'){
            String temp=ex.substring(1);
            StringBuffer sb = new StringBuffer(temp);
            temp = sb.reverse().toString();
            dfs(temp);
        }
        // 마지막이 A라면 마지막만 지우기 가능
        if(ex.charAt(ex.length()-1) =='A'){
            dfs(ex.substring(0,ex.length()-1));
        }

    }
}
