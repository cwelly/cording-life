import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m ,l , k;
    static Point [] arr;
    static  int answer = -1;
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new Point[k];
        for(int i =0 ; i < k ; i++){
            st = new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[i]= new Point(x,y);
        }

        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ; j < k ; j++){
                calc(arr[i].x , arr[j].y);
            }
        }
        System.out.println(k-answer);
    }
    static void calc(int a , int b){
        int count = 0 ;
        for (int i = 0 ; i < k ; i++){
            int tx = arr[i].x;
            int ty= arr[i].y;
            if( tx >= a && tx <= l+a && ty>=b && ty <= b+l  ){
                count+=1;
            }
        }
        answer = Math.max(count  ,answer);
//        System.out.println(a + "  , " + b + " : "+answer);

    }

}
