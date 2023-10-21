import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String arr [] = new String [1001];
        arr[1]= "SK"; // 1은 sk
        arr[2]= "CY"; // 2=cy
        arr[3]= "SK";
        for (int i = 4; i < 1001; i++) {
            if(arr[i-1] == "SK"){
                arr[i] = "CY";
            }
            else{
                arr[i]="SK";
            }

//            System.out.println("i 는 : "+i +" , 값 : "+arr[i]);

        }
        System.out.println(arr[n]);
    }
}
// 1 2 3 4 5 6 7 8 9 0
// 1 2 1 2 1 2

