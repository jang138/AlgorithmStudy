import java.util.Scanner;

public class Main {

	static final int mod = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int dp[][] = new int[N + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			dp[i][9] = 1;

			for (int j = 8; j >= 0; j--) {
				dp[i][j] += (dp[i - 1][j] + dp[i][j + 1]) % mod;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}

		System.out.println(sum % mod);
	}

}
