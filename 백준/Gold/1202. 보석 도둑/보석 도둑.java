import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static  class Vosuc {
        int v;
        int m;
        Vosuc(int v, int m){
            this.v=v;
            this.m=m;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 보석갯수
        int n = Integer.parseInt(st.nextToken());
        // 가방 갯수
        int  k = Integer.parseInt(st.nextToken());
        PriorityQueue<Vosuc> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.v-o1.v;
        });
        List<Vosuc> vosucs = new ArrayList<>();
        int [][] arr = new int [n][2];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(bf.readLine());
            // 해당 보석의 무게
            int m = Integer.parseInt(st.nextToken());

            // 해당 보석의 가치
            int v = Integer.parseInt(st.nextToken());
            arr[i][0]=m;
            arr[i][1]=v;
            vosucs.add(new Vosuc(v,m));
        }
        //저장된 보석들을 무게순으로 오름차순 정렬.
        Collections.sort(vosucs,(o1, o2) -> {
            if(o1.m==o2.m){
                return o2.v-o1.v;
            }
            return o1.m-o2.m;
        });
//        System.out.println(vosucs.get(0).m+" , "+vosucs.get(0).v);

        // 가방의 최대 무게
        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            bags.add(tmp);
        }
        Collections.sort(bags);
        // 최대 무게 저장
        Long answer =0L;
        // 보석 확인 인덱스
        int idx = 0;
        //가방 순회
        for (int i = 0; i < k; i++) {
            // 무게를 넘어가는 보석이 나올때까지 확인
            while(true){
                // 이미 모든 보석을 확인했다면 end
                if(idx>=n){
                    break;
                }
                // 현재 가방 무게보다 보석이 크다면end
                if(vosucs.get(idx).m > bags.get(i)){
                    break;
                }
                pq.add(new Vosuc(vosucs.get(idx).v, vosucs.get(idx).m));
                idx++;
            }
            // pq가 있는지 체크후 가장 큰것하나가져오기
            if(!pq.isEmpty()){
                answer+=Math.abs(pq.poll().v);
            }
        }

        System.out.println(answer);

    }
}
