import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr [] = new int[n];
        int answer [] = new int [n];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer , Integer> hm = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int num =Integer.parseInt(st.nextToken());
            arr[i]= num;
            if(hm.containsKey(num)){
                hm.put(num , hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ;  i>=0 ;i--){
            // 스택에서 현재 값보다 적은 값들 다 제거
            while(!stack.isEmpty() &&  hm.get(stack.peek()) <= hm.get(arr[i]) ){
                stack.pop();
            }
            // 정답에 스택의 값을 peek 하기
            if(stack.isEmpty()){
                answer[i]= -1;
//                sb.insert(0 , " "+-1);
            }
            else{
                answer[i] = stack.peek();
//                sb.insert(0 , " "+stack.peek());
            }
            // 스택에 현재 값 넣기
            stack.push(arr[i]);
        }
        sb.append(answer[0]);
        for (int i = 1; i < n; i++) {
            sb.append(" "+answer[i]);
        }
        System.out.print(sb.toString());


    }
}
// 1 1 2 3 4 2 1
// 4 4 2 1 1 2 4
//