import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seq[] = new int[N + 1];
		int dp[] = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = seq[i] + max;
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}
