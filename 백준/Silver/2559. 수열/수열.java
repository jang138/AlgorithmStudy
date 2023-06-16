import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// ∑ (x=0 to K-1) a[i+x] = S[i+K-1] - S[i-1]
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N - K + 1; i++) {
			max = Math.max(max, S[i + K - 1] - S[i - 1]);
		}
		
		
		System.out.println(max);
	}

}
