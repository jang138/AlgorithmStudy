import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[N + 1];
		int[] root = new int[N + 1];
		root[1] = 1;

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visit[1] = true;

		while (!queue.isEmpty()) {
			int target = queue.poll();

			for (int node : graph.get(target)) {
				if (!visit[node]) {
					queue.add(node);
					visit[node] = true;
					root[node] = target;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < root.length; i++) {
			sb.append(root[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
