import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        String str = a*b*c+"";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            int num = str.charAt(i)-'0';
            if(map.containsKey(num)){
                map.put(num , map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for (int i = 0; i <10 ; i++) {
            if(map.containsKey(i)){
                System.out.println(map.get(i));
            }
            else{
                System.out.println(0);
            }
        }

    }
}
