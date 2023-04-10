
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int [][] earth;
	static int [][] supply;
	static int [] dx= {-1,-1,-1,0,0,1,1,1};
	static int [] dy= {-1,0,1,-1,1,-1,0,1};
//	static PriorityQueue<Tree> trees;
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		
		Tree(int x , int y, int age){
			this.x=x; this.y=y; this.age=age;
		}
		
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return  this.age  -o.age ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		PriorityQueue<Tree> trees = new PriorityQueue<>();
		earth= new int [n][n];
		supply= new int [n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				supply[i][j]=Integer.parseInt(st.nextToken());
				earth[i][j]=5;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken())-1;
			int ty = Integer.parseInt(st.nextToken())-1;
			int tage = Integer.parseInt(st.nextToken());
			trees.add(new Tree(tx, ty, tage));
		}
		for (int i = 0; i < k; i++) {
			// 봄
			//여름
//			System.out.println((i+1)+"번째 시작");
//			print(i+1,trees);
			trees = spring_summer(trees);
//			System.out.println((i+1)+"번째 봄 끝난 후");
//			print(i+1,trees);
			//가을
			trees = fall(trees);
//			System.out.println((i+1)+"번째 가을 끝난 후");
//			print(i+1,trees);
			//겨울
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					earth[j][j2] += supply[j][j2];
				}
			}
		}
		System.out.println(trees.size());
	}

	private static void print(int j, PriorityQueue<Tree> trees) {
		int len =trees.size();
		Iterator<Tree> ic = trees.iterator();
		while(ic.hasNext()) {
			Tree temp= ic.next();
			System.out.println(temp.x+" , "+temp.y+" , 나이 :"+temp.age);
		}
//		for (int i = 0; i < len; i++) {
//			Tree temp= trees.poll();
//			System.out.println(temp.x+" , "+temp.y+" , 나이 :"+temp.age);
//		}
		System.out.println("땅");
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(" "+earth[i][k]);
			}
			System.out.println();
		}
	}

	private static PriorityQueue<Tree> fall(PriorityQueue<Tree> trees) {
		int len =trees.size();
		PriorityQueue<Tree> origin = new PriorityQueue<>();
		for (int i = 0; i < len; i++) {
			Tree temp =trees.poll();
			origin.add(temp);
			if(temp.age%5==0) {
				// 모서리 인 경우
				for (int j = 0; j < 8; j++) {
					if(temp.x+dx[j]>=0&& temp.x+dx[j]<n && temp.y+dy[j]>=0 && temp.y+dy[j]<n) {
						origin.add(new Tree(temp.x+dx[j] , temp.y+dy[j],1));						
					}
				}
//				if(temp.x==0 || temp.x == n-1 || temp.y==0 || temp.y==n-1) {
//					if(temp.x==0) {
//						if(temp.y==0) {
//							// 왼쪽 위 모서리 인경우
//							origin.add(new Tree(temp.x+dx[4] , temp.y+dy[4],1));
//							origin.add(new Tree(temp.x+dx[6] , temp.y+dy[6],1));
//							origin.add(new Tree(temp.x+dx[7] , temp.y+dy[7],1));
//							//continue;
//						}
//						else if(temp.y==n-1) {
//							// 오른쪽위 모서리 인경우
//							origin.add(new Tree(temp.x+dx[3] , temp.y+dy[3],1));
//							origin.add(new Tree(temp.x+dx[5] , temp.y+dy[5],1));
//							origin.add(new Tree(temp.x+dx[6] , temp.y+dy[6],1));
//							//continue;
//						}
//						else {
//							//위 변인 경우
//							for (int j = 3; j < 8; j++) {
//								origin.add(new Tree(temp.x+dx[j] , temp.y+dy[j],1));
//							}
//							//continue;
//						}
//					}
//					else if(temp.x==n-1) {
//						if(temp.y==0) {
//							//왼쪽 아래 모서리인 경우
//							origin.add(new Tree(temp.x+dx[1] , temp.y+dy[1],1));
//							origin.add(new Tree(temp.x+dx[2] , temp.y+dy[2],1));
//							origin.add(new Tree(temp.x+dx[4] , temp.y+dy[4],1));
//							//continue;
//						}
//						else if(temp.y==n-1) {
//							// 오른쪽 아래 모서리인경우
//							origin.add(new Tree(temp.x+dx[0] , temp.y+dy[0],1));
//							origin.add(new Tree(temp.x+dx[1] , temp.y+dy[1],1));
//							origin.add(new Tree(temp.x+dx[3] , temp.y+dy[3],1));
//							//continue;
//						}
//						else {
//							// 아래 변인 경우
//							for (int j = 0; j < 5; j++) {
//								origin.add(new Tree(temp.x+dx[j] , temp.y+dy[j],1));
//							}
////							continue;
//						}
//					}
//					else if(temp.y==0) {
//						//왼쪽 변인 경우
//						origin.add(new Tree(temp.x+dx[1] , temp.y+dy[1],1));
//						origin.add(new Tree(temp.x+dx[2] , temp.y+dy[2],1));
//						origin.add(new Tree(temp.x+dx[4] , temp.y+dy[4],1));
//						origin.add(new Tree(temp.x+dx[6] , temp.y+dy[6],1));
//						origin.add(new Tree(temp.x+dx[7] , temp.y+dy[7],1));
////						continue;
//					}
//					else if(temp.y==n-1){
//						// 오른쪽 변인 경우
//						origin.add(new Tree(temp.x+dx[0] , temp.y+dy[0],1));
//						origin.add(new Tree(temp.x+dx[1] , temp.y+dy[1],1));
//						origin.add(new Tree(temp.x+dx[3] , temp.y+dy[3],1));
//						origin.add(new Tree(temp.x+dx[5] , temp.y+dy[5],1));
//						origin.add(new Tree(temp.x+dx[6] , temp.y+dy[6],1));
////						continue;
//					}
//				}
//				else {
//					for (int j = 0; j < 8; j++) {
//						origin.add(new Tree(temp.x+dx[j] , temp.y+dy[j],1));
//					}
//				}
			}
		}
		
		return origin;
	}

	private static PriorityQueue<Tree> spring_summer(PriorityQueue<Tree> trees) {
		PriorityQueue<Tree> retu = new PriorityQueue<>();
		PriorityQueue<Tree> deads = new PriorityQueue<>();
		// spring
		int len = trees.size();
//		System.out.println("len : "+len);
		for (int i = 0; i < len; i++) {
			Tree temp = trees.poll();
//			System.out.println(temp.x+", "+temp.y+" : "+temp.age);
			if(earth[temp.x][temp.y]-temp.age>=0) {
				earth[temp.x][temp.y] -=temp.age;
				temp.age+=1;
				retu.add(temp);
			}
			else {
				deads.add(temp);
			}
		}
		// summer
		len = deads.size();
		for (int i = 0; i < len; i++) {
			Tree temp = deads.poll();
			earth[temp.x][temp.y]+=temp.age/2;
		}
		
		return retu;
	}

}
