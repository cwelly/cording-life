import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        // 큰친구들
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // 작은 친구들
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int tmp= Integer.parseInt(st.nextToken());
            // 처음 넣을때는 max 에 넣는다
            if (max.size()==0  ) {
                max.add(tmp);
//                System.out.println(tmp);
                sb.append(tmp+"\n");
                continue;
            }
            // 두번째인경우
            else if(min.size()==0){
                // 만약 낮은 중간값보다 값이 작다면?
                if(max.peek() >tmp ){
                    min.add(max.poll());
                    max.add(tmp);
                }
                // 중간값보단 크다면?
                else{
                    min.add(tmp);
                }
            }
            // 그 이외의 경우
            else{
                // 일단 맥스에 먼저 넣을거야
                // tmp값이 1 min 2 max 3 범위중에 어딘지 넣기
                if(tmp>min.peek()){
                    min.add(tmp);
                }
                else {
                    max.add(tmp);
                }
                // 나라시 작업 min.size , max.size 비교해서 넣기
                if(Math.abs(min.size()-max.size())>1){
                    if(min.size()> max.size()){
                        max.add(min.poll());
                    }
                    else{
                        min.add(max.poll());
                    }

                }
            }

            // 다 정리되면 출력
            // 두개의 크기가 같다면
            if(min.size()==max.size()){
//                System.out.println(max.peek());
                sb.append(max.peek()+"\n");
            }
            else{
                sb.append((max.size()> min.size())?max.peek():min.peek());
                sb.append("\n");
//                System.out.println((max.size()> min.size())?max.peek():min.peek());
            }


        }
        System.out.println(sb.toString());

    }
}
