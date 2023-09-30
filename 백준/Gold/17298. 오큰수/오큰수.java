import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n ;
    static int arr [];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n= Integer.parseInt(st.nextToken());
        arr = new int [n];
        int answer [] = new int [n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i<n ; i ++ ) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        Stack<Integer> stack = new Stack<>();
        for(int i = n -1 ;  i>=0 ; i --){
            //  스택 털어서 가장 왼쪽에있는 큰값 골라내기
            while(!stack.isEmpty() && stack.peek() <=arr[i] ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer[i]=stack.peek();
            }
            else{
                answer[i]=-1;
            }
            stack.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }

}
