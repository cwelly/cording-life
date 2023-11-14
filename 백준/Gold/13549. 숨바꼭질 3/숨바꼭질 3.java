import java.util.*;

public class Main {
    static HashMap<Integer,Integer> map ;
    static int answer = 0;
    static int n , k;
    static class point{
        int cnt;
        int pos;
        point(int pos ,int cnt ){
            this.pos = pos;
            this.cnt= cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map= new HashMap<>();
        int mmax =100001;
        int answer=100001;
        Deque<point> deque = new LinkedList<>();
        n = sc.nextInt();
        k = sc.nextInt();
        int now=n;
        deque.add(new point(n,0));
        while(!deque.isEmpty()){
            point tmp= deque.pollFirst();
            map.put(tmp.pos,tmp.cnt);
            if(tmp.pos==k){
                answer=Math.min(tmp.cnt ,answer);
                continue;
            }
            // 순간이동
            if(tmp.pos<k && map.getOrDefault(tmp.pos*2 , mmax)>tmp.cnt){
                deque.add(new point(tmp.pos*2 , tmp.cnt));
            }
            // 걷기
            if(tmp.pos>0 && map.getOrDefault(tmp.pos-1 , mmax)>tmp.cnt){
                deque.add(new point(tmp.pos-1,tmp.cnt+1));
            }
            if(tmp.pos<k&& map.getOrDefault(tmp.pos+1 , mmax)>tmp.cnt){
                deque.add(new point(tmp.pos+1,tmp.cnt+1));
            }

        }
        System.out.println(answer);
    }
}
