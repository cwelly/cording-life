class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int len = sequence.length;
        long  [] cash1 = new long [len];
        long  [] cash2 = new long [len];
        // -1  스타트
        int start = -1;
        int [] sub1 = new int [len];
        int  [] sub2  = new int [len];
        for(int i = 0 ; i < len ;  i ++){
            sub1[i]= sequence[i]*start ;
            start*=-1;
            sub2[i] = sequence[i]*=start;
        }
        cash1[0] = sub1[0];
        cash2[0] = sub2[0];
        answer= Math.max(Math.max(cash1[0],answer),cash2[0]);
        // 1 스타트
        for(int i  = 1 ; i < len ;  i++){
            cash1[i]= Math.max(0 , cash1[i-1])+sub1[i];
            cash2[i]=Math.max(0, cash2[i-1])+sub2[i];
            // System.out.println(cash1[i]+" , "+cash2[i]);
            answer= Math.max(Math.max(cash1[i],answer),cash2[i]);
        }
        return answer;
    }
}