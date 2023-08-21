import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean visit[];
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			visit = new boolean[N + 1];
			graph = new ArrayList<>();

			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int p = Integer.parseInt(st.nextToken());

				graph.get(i).add(p);
				graph.get(p).add(i);
			}

			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					count++;
					//dfs(i);
					bfs(i);
				}
			}

			System.out.println(count);
		}

	}

	private static void dfs(int num) {
		visit[num] = true;

		for (int node : graph.get(num)) {
			if (!visit[node]) {
				dfs(node);
			}
		}
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visit[num] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int node : graph.get(now)) {
				if (!visit[node]) {
					queue.add(node);
					visit[node] = true;
				}
			}
		}
	}

}
