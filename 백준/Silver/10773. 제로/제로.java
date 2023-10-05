import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack  = new Stack<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp ==0 ){
                stack.pop();
            }
            else{
                stack.push(temp);
            }
        }
        int answer=0;
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        System.out.println(answer);
    }
}
