import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
		}
		
		dp[1] = input[1];
		int max = input[1];
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
