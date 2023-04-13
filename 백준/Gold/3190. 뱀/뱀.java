


import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
	// 오른쪽부터 하 좌 상
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	static int n;
	static public class snake{
		int x,y;

		public snake(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		ArrayList<snake> s = new ArrayList<>();
		int [][] map = new int[n][n];
		s.add(new snake(0,0));
		map[0][0]=1;
		//사과 입력받기
		int al =sc.nextInt();
		for (int i = 0; i < al; i++) {
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			map[x][y]=2;
		}
		// 명령 입력받기
		int ml = sc.nextInt();
		int [][] must = new int[ml][2];
		for (int i = 0; i < must.length; i++) {
			int time= sc.nextInt();
			String dir = sc.next();
			must[i][0]=time;
			if(dir.equals("L")) {
				must[i][1]=-1;
			}
			else {
				must[i][1]=1;
			}
		}
		int cur_apple=al;
		int time=0;
		int must_idx=0;
		int dir=0;
		while(true) {
//			System.out.println(time);
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int ix=s.get(s.size()-1).x+dx[dir];
			int iy=s.get(s.size()-1).y+dy[dir];
//			System.out.println("time : "+time+ " ix : "+ix+" iy : "+iy);
			time++;
			if(ix<0 || ix>=n || iy<0 || iy>=n || map[ix][iy]==1 ) {
				break;
			}
			s.add(new snake(ix,iy));
			if(map[ix][iy]==2) {
//				if(--cur_apple==0) {
//					break;
//				}
			}
			else {
				map[s.get(0).x][s.get(0).y]=0;
				s.remove(0);
			}
			map[ix][iy]=1;
			
			if(must_idx<ml &&time==must[must_idx][0]) {
				dir= (dir+4+must[must_idx][1])%4;
				must_idx++;
			}
			
		}
		System.out.println(time);
		
	}

}
