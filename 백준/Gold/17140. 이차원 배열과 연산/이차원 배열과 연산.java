import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n,m,k;
	static int [][] arr;
	static class mapp implements Comparable<mapp>{
		int val ;
		int cnt ;
		mapp(int val , int cnt){
			this.val=val;
			this.cnt  =cnt;
		}
		@Override
		public int compareTo(mapp o) {
			// TODO Auto-generated method stub
			if(this.cnt==o.cnt) {
				return this.val-o.val;
			}
			return this.cnt - o.cnt;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		arr = new int [3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int answer =0 ;
		while(do1()) {
//			System.out.println(answer);
//			print();
			answer++;
			if(answer==101) {
				System.out.println((-1));
				return ;
			}
		}
		System.out.println(answer);
	}
	static void print() {
		System.out.println("\n프린트 하겟소\n");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static boolean do1() {
		// 먼저 arr[n][m] == c 인경우 return false;
		int r_len = arr.length;
		int c_len = arr[0].length;
		if(r_len>(n-1) && c_len>(m-1) && arr[n-1][m-1]==k) {
			return false;
		}
		//  아닌 경우 행렬 연산 시작
		else {
			int m_len=0;
			if(r_len>=c_len) {
				List<List<Integer>> lis = new ArrayList<>();
				
				for (int i = 0; i < arr.length; i++) {
					lis.add(new ArrayList<>());
//					System.out.println(i+"번째 행 드간다");
					PriorityQueue<mapp> pq = new PriorityQueue<>();
					HashMap<Integer, Integer> hm = new HashMap<>();
					for (int j = 0; j < c_len; j++) {
						if(arr[i][j]==0) {
							continue;
						}
						if(hm.containsKey(arr[i][j])) {
							hm.put(arr[i][j],hm.get(arr[i][j])+1);
						}
						else {
							hm.put(arr[i][j], 1);
						}
					}
					// 크기 별로 할수있도록 정렬하는 것
					for(Integer val : hm.keySet()) {
						pq.add(new mapp(val, hm.get(val)));
					}
					// lis 에 최대 50개까지 넣고 , m_len 최신화 
					int ii = 0;
					while(ii<50 && !pq.isEmpty()) {
						mapp temp = pq.poll();
//						System.out.print(temp.val+" ");
//						System.out.println(temp.cnt);
						lis.get(i).add(temp.val);
						lis.get(i).add(temp.cnt);
					}
					m_len = (lis.get(i).size()> m_len)?lis.get(i).size() :m_len ;
				}
				//최대 길이를 구했고 , 거기에 들어갈 값들을 정함.
				arr=  new int[r_len][m_len];
//				System.out.println(r_len);
//				System.out.println(m_len);
				for (int i = 0; i < r_len; i++) {
					List<Integer> tmp = lis.get(i);
					for (int j = 0; j < tmp.size(); j++) {
						arr[i][j]=tmp.get(j);
					}
				}
			}
			else {

				List<List<Integer>> lis = new ArrayList<>();
				
				for (int i = 0; i < c_len; i++) {
					lis.add(new ArrayList<>());
//					System.out.println(i+"번째 열 드간다");
					PriorityQueue<mapp> pq = new PriorityQueue<>();
					HashMap<Integer, Integer> hm = new HashMap<>();
					for (int j = 0; j < r_len; j++) {
						if(arr[j][i]==0) {
							continue;
						}
						if(hm.containsKey(arr[j][i])) {
							hm.put(arr[j][i],hm.get(arr[j][i])+1);
						}
						else {
							hm.put(arr[j][i], 1);
						}
					}
					// 크기 별로 할수있도록 정렬하는 것
					for(Integer val : hm.keySet()) {
						pq.add(new mapp(val, hm.get(val)));
					}
					// lis 에 최대 50개까지 넣고 , m_len 최신화 
					int ii = 0;
					while(ii<50 && !pq.isEmpty()) {
						mapp temp = pq.poll();
//						System.out.print(temp.val+" ");
//						System.out.println(temp.cnt);
						lis.get(i).add(temp.val);
						lis.get(i).add(temp.cnt);
					}
					m_len = (lis.get(i).size()> m_len)?lis.get(i).size() :m_len ;
				}
				//최대 길이를 구했고 , 거기에 들어갈 값들을 정함.
				arr=  new int[m_len][c_len];
				for (int i = 0; i < c_len; i++) {
					List<Integer> tmp = lis.get(i);
					for (int j = 0; j < tmp.size(); j++) {
						arr[j][i]=tmp.get(j);
					}
				}
			}
			return true;
		}
	}

}
