import java.util.*;
public class Main {
	public static void main(String[] args) {
		HashMap<Integer,Integer> hashSet = new HashMap<>();
		int m=0, n=0 ;
		Scanner scan =new Scanner(System.in);
		m=scan.nextInt();
		int tmp = 0;
		for(int i =0 ; i<m;i++) {
			tmp = scan.nextInt();
			if(hashSet.containsKey(tmp)) {
				hashSet.put(tmp, hashSet.get(tmp)+1);
//				System.out.println("이미 있던 "+tmp+"를 넣었습니다");
			}
			else {
//				System.out.println("처음보는 "+tmp+" 입니다");
				hashSet.put(tmp , 1);
			}
		}
		n= scan.nextInt();
		StringBuilder str =new StringBuilder();
		for(int i=0 ; i<n; i++) {
			tmp = scan.nextInt();
			if(hashSet.containsKey(tmp)) {
				str.append(hashSet.get(tmp)+" ");
			}
			else {
				str.append(0+" ");
			} 
		}
		System.out.println(str.toString());
		
	}
}
