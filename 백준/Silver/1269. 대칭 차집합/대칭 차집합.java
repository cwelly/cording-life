
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int n,m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int tmp = 0;
		long answer = 0;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			setA.add(tmp);
		}
		for (int i = 0; i <m; i++) {
			tmp = sc.nextInt();
			setB.add(tmp);
		}
		for(Integer iter : setA) {
			if(!setB.contains(iter)) {
				answer+=1;
				
			}
		}
		for(Integer iter : setB) {
			if(!setA.contains(iter)) {
				answer+=1;
			}
			
		}
		
		
		System.out.println(answer);
	}

}
