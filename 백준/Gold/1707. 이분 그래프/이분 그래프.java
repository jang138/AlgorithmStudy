import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean flag;
	static int check[];
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			check = new int[V + 1];
			graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}

			int start = 0;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph.get(u).add(v);
				graph.get(v).add(u);

				start = u;
			}

			flag = true;
			
			for (int i = 1; i <= V; i++) {
				if(check[i] == 0) {
					flag = flag && bfs(i);
				}
			}

			System.out.println(flag ? "YES" : "NO");
		}
	}

	private static boolean bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		check[num] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int node : graph.get(now)) {
				
				if (check[node] == check[now]) {
					return false;
				}

				if (check[node] == 0) {
					check[node] = -1 * check[now];
					queue.add(node);
				}

			}
		}
		
		return true;
	}

}
