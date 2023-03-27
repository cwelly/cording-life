
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<String> hash = new HashSet<>();
		String str = sc.next();
		for(int i=0 ; i<str.length() ; i++) {
			for (int j = 0; j < str.length()-i; j++) {
				String tmp = str.substring(j, j+i+1);
				hash.add(tmp);
			}
		}
		System.out.println(hash.size());
	}

}