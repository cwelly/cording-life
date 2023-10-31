import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextInt()+"";
        str = str.substring(0,str.length()-2);
        int n =Integer.parseInt(str);
        int f = sc.nextInt();
        int a= 0 ; int b=0;
        for (int i = 0; i <10 ; i++) {
            String t = i+"";
            for (int j = 0; j < 10; j++) {
                String tt=t+j+"";
                int temp = Integer.parseInt(str+tt);
                if(temp%f==0){
                    System.out.println(tt);
                    return;
                }
            }
        }

        System.out.println(n);
    }
}
