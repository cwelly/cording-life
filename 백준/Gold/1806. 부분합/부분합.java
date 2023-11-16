import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int s= sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start= 0 ;
         int end = 1;
         int answer= 10000001;
         int now =arr[0];
         while(end<=n){
             // 현재 토탈 확인
             if(now>=s){
                 answer= Math.min(answer, end-start);
//                 System.out.println(start+" , "+end+" : "+now);
             }
             if(now<s || end-start==1){
                 end+=1;
                 if(end>n){
                     break;
                 }
                 now+=arr[end-1];
             }
             else{
                 now-=arr[start];
                 start+=1;
             }
         }
         while(start<n){
//             System.out.println(start+" , "+end+" :" +now);
             now-=arr[start];
             start+=1;
             if(now>=s){
                 answer= Math.min(answer, end-start);
//                 System.out.println(start+" , "+end+" : "+now);
             }
         }
         if(answer==10000001){
             System.out.println(0);
         }
         else{

             System.out.println(answer);
         }

    }
}
