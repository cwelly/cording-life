class Solution {
   final static Solution method = new Solution();
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int k = 1000 * 100;
        t1 += 10;
        t2 += 10;
        temperature += 10;
        
        int[][] DP = new int[onboard.length][51];
        for (int i = 0; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                DP[i][j] = k;
            }
        }
        
        DP[0][temperature] = 0;
        
        int flag = 1;
        if (temperature > t2) {
            flag = -1;
        }
        
        for (int i = 1; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                int minV = k;
                // 현재 값이 승객이 타고 있고 , 적정온도 안의 값인 경우
                // 혹은 승객이 안타고있는 경우 테스트
                if (( onboard[i] == 1 && t1 <= j && j <= t2 ) || onboard[i] == 0) {
                    //# 1. 에어컨을 키지 않고 실외온도와 달라서 실내온도가 -flag 되는 경우
                    if (0 <= j+flag && j+flag <= 50) {
                        // 전체 최소값(minV) 과 ㄴ
                        minV = method.min(minV, DP[i-1][j+flag]);
                    }
                    //# 2. 에어컨을 키지 않고 현재온도 j 가 실외온도랑 같아서 변하지 않는 경우
                    if (j == temperature) {
                        minV = method.min(minV, DP[i-1][j]);
                    }
                    //# 3. 에어컨을 키고 현재온도가 변하는 경우
                    if (0 <= j-flag && j-flag <= 50) {
                        minV = method.min(minV, DP[i-1][j-flag] + a);
                    }
                    //# 4. 에어컨을 키고 현재온도가 희망온도라서 온도가 변하지 않는경우
                    if (t1 <= j && j <= t2) {
                        minV = method.min(minV, DP[i-1][j] + b);
                    }
                    
                    DP[i][j] = minV;
                    
                }
            }
        }
        
        int i = onboard.length-1;
        int answer = DP[i][0];
        for (int j = 1; j < 51; j++) {
            answer = method.min(answer, DP[i][j]);
        }
        return answer;
    }
    
    public int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}