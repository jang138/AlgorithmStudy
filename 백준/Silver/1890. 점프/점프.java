import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		long dp[][] = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				int jump = map[i][j];

				if (i + jump < N) {
					dp[i + jump][j] += dp[i][j];
				}

				if (j + jump < N) {
					dp[i][j + jump] += dp[i][j];
				}

				/*
				for (int k = 0; k < N; k++) {
					for (int k2 = 0; k2 < N; k2++) {
						System.out.print(dp[k][k2] + " ");
					}
					System.out.println();
				}
				
				System.out.println("============");
				*/
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}

}
