import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = sc.nextInt();
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int deleted_count = 0 ;
        String rest="";
        for (int i = 0; i < str.length(); i++) {
            int num  = str.charAt(i)-'0';
            // 만약 스택이 비어 있는지 체크
            if(!stack.isEmpty()){
                // 삭제한 갯수가 다 털리거나 , 스택이 빌때까지 반복
                while(!stack.isEmpty() &&deleted_count <cnt  ){
                    if(stack.peek() <num){
                        deleted_count+=1;
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
            }

            stack.push(num);
            // 만약 삭제가 전부 된상태라면
            if(deleted_count == cnt){
                stack.pop();
                rest = str.substring(i);
//                System.out.println(i+" , " + str.substring(i));
                break;
            }
        }
        // 삭제안된 부분 처리하는 로직 들어가야함
        if(deleted_count<cnt){
            while(deleted_count!=cnt){
                int c =stack.pop();
                deleted_count+=1;
//                System.out.println(c);
            }
        }
//10 4
//9876543333
        for (int i = 0; i <stack.size() ; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb.toString()+rest);
    }
}
