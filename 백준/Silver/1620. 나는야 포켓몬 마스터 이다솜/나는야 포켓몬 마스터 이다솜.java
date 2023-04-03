import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, String> hashKey = new HashMap<>();
		HashMap<String, Integer> hashVal = new HashMap<>();
		for(int i=1; i<=n ; i++ ) {
			String str = sc.next();
			hashKey.put(i, str);
			hashVal.put(str, i);
		}
		for(int j = 0 ;j<m ;j++) {
			String str = sc.next();
			if(str.charAt(0)>='0'&& str.charAt(0)<='9') {
				int num = Integer.parseInt(str);
				System.out.println(hashKey.get(num));
			}
			else {
				System.out.println(hashVal.get(str));
			}
		}
		
		
	}

}
