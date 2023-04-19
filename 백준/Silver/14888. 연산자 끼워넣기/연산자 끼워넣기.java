
import java.util.Scanner;

public class Main {
	static int n;
	static int arr[];
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		arr =new int [n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int pmmm [] = new int [4];
		for (int i = 0; i < pmmm.length; i++) {
			pmmm[i]=sc.nextInt();
		}
		int sol [] = new int [n-1];
		powerset(0 , sol , pmmm  );
		
		System.out.println(max+" "+min);
	}
	static void powerset(int cur, int[] sol,int [] pmmm) {
//		System.out.println(cur);
		if(cur==sol.length) {
			long total = arr[0];
			for (int i = 0; i <sol.length; i++) {
				switch(sol[i]) {
				case 0 :
					total+=arr[i+1];
					break;
				case 1:
					total-=arr[i+1];
					break;
				case 2:
					total*=arr[i+1];
					break;
				case 3:
					total/=arr[i+1] ;
					break;
				}
			}
			min = (min>total)?total : min;
			max = (max<total)?total : max;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(pmmm[i]==0) {
				continue;
			}
			sol[cur]=i;
			pmmm[i]-=1;
			powerset(cur+1, sol, pmmm);
			pmmm[i]+=1;
		}
		
	}
}
