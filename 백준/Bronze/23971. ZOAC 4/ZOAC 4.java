import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        // h -n , w - m
        int x = h/(n+1);
        x+= (h%(n+1))==0?0 :1;
        int y = w/(m+1);
        y+= (w%(m+1))==0?0 :1;
        System.out.println(x*y);
    }
}
