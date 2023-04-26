
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine()) ;
		HashMap<String, String> hm = new HashMap<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			hm.put(st.nextToken(), st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			System.out.println(hm.get(st.nextToken()));
		}
		
	}

}
