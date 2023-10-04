import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int a_cnt = 0;
        int ppap = 0;
        String PPAP =  "PPAP";
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)=='A'){
                a_cnt+=1;
            }
        }
        for (int i = 0; i <str.length() ; i++) {
            stack.push(str.charAt(i));
            if(stack.size()>=4){
                boolean is_same = true;
                for(int j = stack.size()-4 ; j <stack.size() ; j++){
                    if(stack.get(j) != PPAP.charAt(j+4-stack.size())){
                        is_same=false;
                    }
                }
                if(is_same){
                    // ppap  터트린 경우
                    stack.pop();stack.pop();stack.pop();
                    ppap+=1;
                }
            }
        }
        if(stack.size()==1 && stack.get(0)!='A'){
            System.out.println(PPAP);
        }
        else{
            System.out.println("NP");
        }
//        if(ppap==a_cnt){
//            System.out.println(PPAP);
//        }
//        else{
//            System.out.println("NP");
//        }

        
    }
}
