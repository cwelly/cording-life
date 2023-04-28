
import java.util.*;

public class Main {
  static class member  implements Comparable<member>{
    String str;
    member(String str){
      this.str=str;
    }

    @Override
    public int compareTo(member o) {
      return o.str.compareTo(this.str);
    }
  }
  public static void main(String[] args) {
    PriorityQueue<member> pq = new PriorityQueue<>();
    HashSet<String> hs = new HashSet<>();
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int i = 0; i <tc ; i++) {
      String name = sc.next();
      String tmp = sc.next();
//      System.out.println(name+" "+tmp);
      if(tmp.equals("enter")){
        if(!hs.contains(name)){
          hs.add(name);
        }
      }
      if(tmp.equals("leave")){
        if(hs.contains(name)){
          hs.remove(name);
        }
      }
    }
    Iterator<String> iterator = hs.iterator() ;
//    System.out.println(iterator.next());
    while(iterator.hasNext()){
      pq.add(new member(iterator.next()));
    }
    while(!pq.isEmpty()){
      System.out.println(pq.poll().str);
    }

  }
}
