
import java.util.HashSet;
import java.util.Scanner;

public class Main {
  static int n ;
  static int answer = Integer.MAX_VALUE;

  static int arr [][];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int [n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j]=sc.nextInt();
      }
    }
    HashSet<Integer> mapp = new HashSet<>();
    int sol[] = new int[n/2];
    powerset(0,sol,mapp);
    System.out.println(answer);
  }
  static void powerset(int cur, int[] sol, HashSet<Integer> mapp){
    if(cur == sol.length){
      int t1_power  = 0;
      int t2_power = 0;
      int sol2 []= new int [n/2];
      int cu =0 ;
      for (int i = 0; i < n; i++) {
        if(!mapp.contains(i)){
          sol2[cu] = i;
          cu++;
        }
      }
      //t1
      for (int i = 0; i < n; i++) {
        if(!mapp.contains(i)){
          for (int j = 0; j < sol2.length; j++) {
            t2_power+=arr[i][sol2[j]];
          }
        }
        else{
          for (int j = 0; j < sol.length; j++) {
            t1_power+=arr[i][sol[j]];
          }
        }
      }
      //t2
//      for (int i = 0; i < sol2.length; i++) {
//      }
      answer = (Math.abs(t1_power-t2_power)<answer) ?Math.abs(t1_power-t2_power) :answer ;
      return ;
    }
    int start = (cur==0) ? 0:sol[cur-1] ;
    for (int i = start; i < n; i++) {
      if(!mapp.contains(i)){
        sol[cur]=i;
        mapp.add(i);
        powerset(cur+1, sol , mapp);
        mapp.remove(i);
      }
    }
  }
//0 2 5 = 0,2 + 0,5 + 2,0 + 2,5 + 5,0 + 5,2
//  = 2 + 5 + 1 + 5 + 1 + 3 = 17
//1, 3, 4 = 1,3 + 1,4 + 3,1 + 3,4 + 4,1 + 4,3
// = 3 + 4 + 2 + 4 + 2 +4 = 19
}
