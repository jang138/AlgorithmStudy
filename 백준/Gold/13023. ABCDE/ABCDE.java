import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);

			if (flag)
				break;
		}

		System.out.println(flag ? 1 : 0);

	}

	public static void dfs(int number, int depth) {
		if (depth == 5 || flag) {
			flag = true;
			return;
		}

		visited[number] = true;

		for (int target : graph.get(number)) {
			if (!visited[target]) {
				dfs(target, depth + 1);
			}
		}

		visited[number] = false;
	}

}
