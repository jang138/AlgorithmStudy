import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];

		dfs(0, 1);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth, int start) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1, i);
		}
	}
}
