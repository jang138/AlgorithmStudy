import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		/*
		 * i번째 타일 = (i-1)번째 타일에 l 타일만 추가 + (i-2)번째 타일에 二타일과 ㅁ타일 두가지 추가
		 */

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
