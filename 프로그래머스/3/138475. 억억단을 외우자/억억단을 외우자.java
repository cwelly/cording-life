import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int [starts.length];
        HashMap<Integer , Integer> map = new HashMap<>();
        int dp [] = new int [e+1];
        // Arrays.sort(starts);
        for(int  i = 1; i < e+1 ; i ++){
            for(int j  = 1; j*i<=e ; j++){
                dp[i*j]+=1;
            }
            // System.out.println(i+" : "+dp[i]);
        }
        int max  =-1;
        int ans =e;
        for(int  i = e ; i >0 ; i -- ){
            if(dp[i]>=max){
                max = dp[i];
                ans = i;
            }
            map.put(i , ans);            
        }
        for(int i = 0 ; i < starts.length ; i ++){
            answer[i] = map.get(starts[i]);
        }
        
        return answer;
    }
}