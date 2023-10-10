import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
         int n = sc.nextInt();
         int  [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i]=  sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        Long answer =0L ;
        for (int i = n-1; i >=0 ; i--) {
            
            // 스택 비우기
            while(!stack.isEmpty() && arr[stack.peek()] <arr[i] ){
                stack.pop();
            }
            // 가장 높은 스택값 기반 계산
            if(stack.isEmpty()){
                answer+= (n-1)-i;
//                System.out.println((i)+"는 : 비어있음");
            }
            else{
                answer+=(stack.peek()-i-1);
//                System.out.println((i)+"는 : "+stack.peek());
            }
            // 스택에 푸쉬
            stack.push(i);
        }

        System.out.println(answer);
    }
}
