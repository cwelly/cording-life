
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int n=-1 ;
	static String str="str";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int tt =1;
			String temp = sc.next();
			if(hm.containsKey(temp)) {
				hm.put(temp, hm.get(temp)+1);
				if(hm.get(temp) == n) {
					if(str.compareTo(temp)>0) {
						str=temp;
					}
				}
				else if(hm.get(temp) > n){
					str=temp;
					n=hm.get(temp);
				}
			}
			else {
				hm.put(temp, tt);
				if(hm.get(temp) == n) {
					if(str.compareTo(temp)>0) {
						str=temp;
					}
				}
				else if(hm.get(temp) > n){
					str=temp;
					n=hm.get(temp);
				}
			}
//			System.out.println(i+" 번째 큰ㄱ밧 : "+str);
		}
		System.out.println(str);
//		str= "peanuts";
//		System.out.println(str.compareTo("chocolate"));
	}

}
