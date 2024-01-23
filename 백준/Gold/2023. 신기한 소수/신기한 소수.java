import java.util.Scanner;

public class Main {
	static int[] prime = { 2, 3, 5, 7 };
	static int N;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

	}

	public static void dfs(int number, int depth) {
		if (depth == N) {
			if (isPrime(number)) {
				System.out.println(number);
			}
			return;
		}

		for (int i = 1; i < 10; i += 2) {
			if (isPrime(number * 10 + i)) {
				dfs(number * 10 + i, depth + 1);
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
