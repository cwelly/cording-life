
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int n =0;
	static Long s=(long) 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Long, Integer> hm = new HashMap<>();
		int c= sc.nextInt();
		for (int i = 0; i < c; i++) {
			Long t = sc.nextLong();
			if(i == 0) {
				n=1;
				hm.put(t, 1);
				s=t;
				continue;
			}
//			System.out.println((i+1)+" : "+hm.containsKey(t));
			if(hm.containsKey(t)) {
				hm.put(t,hm.get(t)+1);
//				System.out.println((i+1)+" : "+s+" : "+hm.get(t));
				if(hm.get(t)  >  n) {
					n=hm.get(t);
					s=t;
				}
				else if(hm.get(t) == n) {
//					System.out.println(i+" : "+t+"<- 입력값 : "+(s<t));
					s = (s <t  )?s:t;
				}
			}
			else {
				hm.put(t, 1);
				if(n==1 && s>t) {
					s=t;
				}
			}
//			System.out.println(i+" : "+s);
		}
		System.out.println(s);
	}

}
