import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i <tc ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> min= new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String strs [] = bf.readLine().split(" ");
                int tmp = Integer.parseInt(strs[1]);
                // 추가 인경우
                if(strs[0].equals("I")){
                    int cnt = map.getOrDefault(tmp , 0);
                    map.put(tmp , cnt+1);
                    min.add(tmp);
                    max.add(tmp);
                }
                // 삭제인경우
                else{
                    if(map.size()==0){
                        continue;
                    }
                    PriorityQueue<Integer> que = (tmp==1)?max:min;
                    remove(que, map);
                }
            }// for
            if(map.size()==0){
                System.out.println("EMPTY");
            }
            else{
                int num = remove(max,map);
                System.out.print(num+" ");
                System.out.println(  (map.size()>0)?remove(min,map):num );
            }


        }//tc

    }// main
    static int remove(PriorityQueue<Integer> que , HashMap<Integer, Integer> map){
        int n;
        while(true){
            n = que.poll();
            int cnt = map.getOrDefault(n , 0);
            if(cnt == 0){
                continue;
            }else if(cnt==1){
                map.remove(n);
            }
            else {
                map.put(n,cnt-1);
            }
            break;
        }
        return n;
    }

}// boj
