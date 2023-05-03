
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for (int k = 0; k <tc; k++) {
			st = new StringTokenizer(bf.readLine());
			HashSet<Integer> hs = new HashSet<>();
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int tp = Integer.parseInt(st.nextToken());
				hs.add(tp);
			}
			st = new StringTokenizer(bf.readLine());
			n=  Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int tp =  Integer.parseInt(st.nextToken());
				if(hs.contains(tp)) {
//					System.out.println(1);
					bw.write("1\n");//출력
//					bw.newLine(); //줄바꿈
				}
				else {
//					System.out.println(0);
					bw.write("0\n");//출력
//					bw.newLine(); //줄바꿈
				}
			}
			
		}
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
	}

}
