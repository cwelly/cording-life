import java.util.*;
class Solution {
    // static class Point implements Comparable<Point>{
    //     int val;
    //     int idx;
    //     Point(int val , int idx){
    //         this.val;
    //         this.idx;
    //     }
    //     int CompareTo(Point Object){
    //         return o.val- this.val;
    //     }
    // }
    public int solution(int[][] scores) {
        int len = scores.length;
        int mainN = scores[0][0];
        int mainM = scores[0][1];
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]- o2[1];
            }
            return o2[0]-o1[0];
        });
        int mmax = scores[0][1];
        for (int i = 1; i < len; i++) {
            if(scores[i][1]<mmax){
                if(scores[i][0]==mainN && scores[i][1]==mainM){
                   return -1;
                    // return;
                }
                scores[i][0]=-1;
                scores[i][1]=-1;
            }
            else{
                mmax= scores[i][1];
            }
        }
        //aa
        Arrays.sort(scores , (o1, o2) -> {
            return (o2[0]+o2[1]) -(o1[0]+o1[1]);
        });
        for (int i = 0; i <len ; i++) {
            if(scores[i][0]+scores[i][1] == mainM + mainN){
               return i+1;
                // return;
            }
        }
        return 0;
    }
}