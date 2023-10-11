import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h=sc.nextInt();
        int w = sc.nextInt();
        int arr [] = new int [w];
        for (int i = 0; i < w; i++) {
            arr[i]=sc.nextInt();
        }
        int answer=0;
        bb : for (int i = 1; i <w-1 ; i++) {
            
            
            //왼쪽 체크
            int l_best = arr[i]-1;
            for (int j = 0; j <i ; j++) {
                if(arr[j]>l_best){
                    l_best= arr[j];
                }
            }
            //오른쪽 체크
            int r_best = arr[i]-1;
            for (int j = i+1; j <w ; j++) {
                if(arr[j]>r_best){
                    r_best= arr[j];
                }
            }
            
            // 오른쪽 왼쪽중 낮은 곳으로 비교
            // 둘중 하나라
            if(l_best<arr[i] || r_best<arr[i]){
                continue ;
            }
            else{
                answer+=Math.min(l_best,r_best) - arr[i];
            }
        }
        System.out.println(answer);

    }
}
