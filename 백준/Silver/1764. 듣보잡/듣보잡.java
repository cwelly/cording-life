
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int m = sc.nextInt();
		TreeSet<String> tree = new TreeSet<>();
		TreeSet<String> answer = new TreeSet<>();
		String str="";
		for(int i =0 ; i<n ; i++ ) {
			str = sc.next();
			tree.add(str);
		}
		for (int i = 0; i < m; i++) {
			str= sc.next();
			if(tree.contains(str)) {
				answer.add(str);
			}
		}
		System.out.println(answer.size());
		Iterator iter = answer.iterator(); 
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}

}
