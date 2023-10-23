import java.util.Scanner;
import java.util.Stack;

public class Main {
    static boolean is_moum(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (!str.equals("end")) {
            boolean is_rule1 = false;
            boolean is_rule2 = true;
            boolean is_rule3 = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                // 룰 1번 확인
                if (is_moum(str.charAt(i))) {
                    is_rule1 = true;
                }
                // 룰 2번 확인
                if (i > 1) {
                    if ((is_moum(str.charAt(i)) &&
                            is_moum(str.charAt(i - 2)) &&
                            is_moum(str.charAt(i - 1))) ||
                            (
                                    !is_moum(str.charAt(i)) &&
                                            !is_moum(str.charAt(i - 1)) &&
                                            !is_moum(str.charAt(i - 2))
                            )
                    ) {
                        is_rule2 = false;
                        break;
                    }
                }
                // 룰 3번 확인
                if (i > 0) {
                    if (
                            str.charAt(i) == str.charAt(i - 1)
                    ) {
//                        System.out.println("같은값 감지 : "+ str.charAt(i-1)+ " , "+ str.charAt(i));
                        if (is_moum(str.charAt(i)) && (str.charAt(i) == 'e' || str.charAt(i) == 'o')) {

                        } else {
                            is_rule3 = false;
                            break;
                        }
                    }

                }
            }
            if (is_rule1
                    && is_rule2
                    && is_rule3) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
            str = sc.next();
        }
    }
}