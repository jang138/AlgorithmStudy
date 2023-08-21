import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, A, B, M;
	static int chon[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		chon = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		dfs(A);

		System.out.println(chon[B] == 0 ? -1 : chon[B]);

	}

	private static void dfs(int n) {
		if (n == B) {
			return;
		}

		for (int now : graph.get(n)) {
			if (chon[now] == 0) {
				chon[now] = chon[n] + 1;
				dfs(now);
			}
		}

	}
}
