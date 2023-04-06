import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashSet<String> hashSet = new HashSet<>();
		int result = 0 ;
		for(int i = 0 ; i < n ; i++) {
			String str = sc.next();
			hashSet.add(str);
		}
		for (int i = 0; i < m; i++) {
			String str = sc.next();
			if(hashSet.contains(str)) {
				result+=1;
			}
		}
		System.out.println(result);
	}

}
