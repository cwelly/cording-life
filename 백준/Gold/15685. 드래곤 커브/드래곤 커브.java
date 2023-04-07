import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static class dot {
    int start_x;
    int start_y;
    int dir;

    dot(int start_x, int start_y, int dir) {
      this.dir = dir;
      this.start_x = start_x;
      this.start_y = start_y;
    }

    @Override
    public String toString() {
      return "dot{" +
              "start_x=" + start_x +
              ", start_y=" + start_y +
              ", dir=" + dir +
              '}';
    }
  }

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int n;
  static int answer =0;
  static int[][] result_xy = new int[101][101];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    int[][] input = new int[n][4];
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int d = sc.nextInt();
      int g = sc.nextInt();
      input[i][0] = x;
      input[i][1] = y;
      /*
      0: x좌표가 증가하는 방향 (→)
      1: y좌표가 감소하는 방향 (↑)
      2: x좌표가 감소하는 방향 (←)
      3: y좌표가 증가하는 방향 (↓)
      시계 방향  : d = (d+1)%4
       */
      input[i][2] = d;
      input[i][3] = g;
      // i 하나에 메소드 하나씩돌려서 g까지의 값을 실행하는 걸 구성해라. 만들때마다 역방향으로 구성하라
      result_xy[x][y] = 1;
      result_xy[x+dx[d]][y+dy[d]]=1;
      List<dot> ttmp = new ArrayList<>();
      ttmp.add(new dot(input[i][0], input[i][1], input[i][2]));
      dfs(ttmp, 1, input[i][3]);
    }
    /*
    일단
    1. 각 i 마다 커브를 완성시키고
      param  :
      현 드래곤 커브 cur_curve (ArrayList) : 모든 시작점 , 방향을 순서대로 가진다.
      , 현재 세대 cur_ge (int)
      , 종료 세대 end_ge (int)
      logic  : dfs 로 인자들을 받고 , 받아온 전세대 드래곤 커브 마다 현재 드래곤 커브를 추가해야한다.
               로직을 돌면서 새로 확인한 끝점마다 result_xy에 기록

    2. 완성된 좌표계에서 사각형이 몇개인지 카운트한다.
      param  : noparam
      logic  : 0부터 99개까지의 x , 0부터 99개까지의 y 를 돌면서 해당 사각형에 모두 점이 있는지 체크
      return : int 앤서 리턴
     */
    return_answer();
    System.out.println(answer);
  }

  public static void dfs(List<dot> cur_curve, int cur_ge, int end_ge) {
    if (cur_ge > end_ge) {
      return;
    }
    List<dot> next_curve = new ArrayList<>(cur_curve);
    int leng = next_curve.size() - 1;
    int cur_x = next_curve.get(leng).start_x+dx[next_curve.get(leng).dir];
    int cur_y = next_curve.get(leng).start_y+dy[next_curve.get(leng).dir];
    for (int i = leng; i >= 0; i--) {
      dot temp = cur_curve.get(i);

      // 현재 보고 있는 방향을 90도로 변형
      int tdir = (temp.dir+1)%4;
      // 여기서 방향과 꼭지점을 넘겨줄 리스트에 추가
      next_curve.add(new dot(cur_x, cur_y , tdir));

      cur_x +=  dx[tdir];
      cur_y +=  dy[tdir];
      // 다음 값을 찾았다면 그값을 result_xy에 추가
      result_xy[cur_x][cur_y]=1;
    }
    dfs(next_curve, cur_ge + 1, end_ge);
  }
  public static int  return_answer (){
    for (int i = 0; i <100 ; i++) {
      for (int j = 0; j <100 ; j++) {
        if(result_xy[i][j]==1 && result_xy[i+1][j]==1 &&result_xy[i][j+1]==1 &&result_xy[i+1][j+1]==1 ){
          answer+=1;
        }
      }
    }
    return 0;
  }

}