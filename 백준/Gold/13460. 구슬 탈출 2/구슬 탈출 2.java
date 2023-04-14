import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n,m;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	static int answer=Integer.MAX_VALUE;
	static public class rb{
		int rx,ry,bx,by;
		boolean v;
		public rb(int rx, int ry, int bx, int by, boolean v) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.v = v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		// 파랑과 빨강의 위치
		int rx=0,ry=0;
		int bx=0,by=0;
		char [][] map= new char[n][m];
		for (int i = 0; i < n; i++) {
			String tmp =sc.next();
			map[i]=tmp.toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]=='B') {
					bx=i;by=j;
				}
				if(map[i][j]=='R') {
					rx=i;ry=j;
				}
			}
		}
		// 0 == 움직일 방향
//		System.out.println(rx+" , "+ry+" , "+bx+" , "+by);
		rec(map,rx,ry,bx,by  ,0);
		if(answer==Integer.MAX_VALUE) {
			answer=-1;
		}
		System.out.println(answer);
	}
	private static void rec(char[][] map, int rx, int ry, int bx, int by, int cnt) {
		if(cnt==10) {
			return ;
		}
		if(cnt>answer) {
			return;
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println("");
//		}
//		System.out.println(cnt);
//		System.out.println();
		for (int i = 0; i < 4; i++) {
			char temp[][]=new char[n][m];
			for (int j = 0; j < n; j++) {
				temp[j]=Arrays.copyOf(map[j], m);
			}
			
			rb tmp =move(temp, i, rx, ry, bx, by, cnt+1);
			if(tmp.v) {
				rec(temp, tmp.rx, tmp.ry, tmp.bx, tmp.by, cnt+1);
			}
		}
	}
	//방향이 주어지면, 그방향으로 map의 값들을 이동시키는 함수
	private static rb move(char[][] map, int dir, int rx, int ry, int bx, int by, int cnt) {
		int tmprx=rx,tmpry=ry,tmpbx=bx,tmpby=by;
		//파랑 먼저
		for (int i = 1; i < n+m; i++) {
			int ix=tmpbx+dx[dir];
			int iy=tmpby+dy[dir];
			if(map[ix][iy]=='O') {
				return new rb(0,0,0,0,false);
			}
			else if(map[ix][iy]!='#') {
				tmpbx=ix;
				tmpby=iy;
			}
			else {
				break;
			}
		}
		//빨강 다음
		for (int i = 1; i < n+m; i++) {
			int ix=tmprx+dx[dir];
			int iy=tmpry+dy[dir];
//			System.out.println(ix+" , "+iy);
			if(map[ix][iy]=='O') {
				answer= answer>cnt? cnt: answer;
				return new rb(0,0,0,0,false);
			}
			else if(map[ix][iy]!='#') {
				tmprx=ix;
				tmpry=iy;
			}
			else {
				break;
			}
		}
//		System.out.println("tmprx : "+tmprx+" tmpry : "+tmpry+" tmpbx : "+tmpbx+" tmpby : "+tmpby);
		if(tmprx==tmpbx && tmpry==tmpby) {
			//상이거나 
			if(dir==0 ) {
				if(rx>bx) {
					tmprx+=1;
				}
				else {
					tmpbx+=1;
				}
			}
			//하일때
			else if(dir ==1) {
				if(rx>bx) {
					tmpbx-=1;
				}
				else {
					tmprx-=1;
				}
			}
			//왼쪽이나 
			else if(dir==2) {
				if(ry>by) {
					tmpry+=1;
				}
				else {
					tmpby+=1;
				}
			}
			//오른쪽
			else {
				if(ry>by) {
					tmpby-=1;
				}
				else {
					tmpry-=1;
				}
			}
			
		}
		map[rx][ry]='.';
		map[bx][by]='.';
		map[tmprx][tmpry]='R';
		map[tmpbx][tmpby]='B';
		
		return new rb(tmprx,tmpry,tmpbx,tmpby,true);
	}

}
