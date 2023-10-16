import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            if(a==0 && b==0 && c==0){
                return;
            }
            int max =Math.max(a,Math.max(b,c));
            if(max>=a+b+c-max  ){
                System.out.println("Invalid");
            }
            else if(a== b && b==c){
                System.out.println("Equilateral");
            }
            else if((a==b && b!=c) || (b==c && c!=a) || (a==c&& b!=c)){
                System.out.println("Isosceles");
            }
            else if(a!=b && b!=c && c!=a){
                System.out.println("Scalene");
            }
        }
    }
}
