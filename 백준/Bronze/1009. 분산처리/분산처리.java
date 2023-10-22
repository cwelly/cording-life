import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i <test ; i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            int ans = a%10;
            for (int j = 1; j < b; j++) {
                ans = (ans*a)%10;
            }
            if(ans == 0){
                System.out.println(10);
            }
            else{

                System.out.println(ans);
            }
        }
    }
}
