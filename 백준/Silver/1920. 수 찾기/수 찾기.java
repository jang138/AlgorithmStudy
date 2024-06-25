import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (map.get(n) == null)
				sb.append(0).append("\n");
			else
				sb.append(1).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
