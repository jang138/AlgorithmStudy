import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] distance;

	static class Edge {
		int node;
		int value;

		public Edge(int node, int value) {
			this.node = node;
			this.value = value;
		}

		public String toString() {
			return node + " " + value;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		visited = new boolean[V + 1];
		distance = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < V; i++) {
			String[] str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);

			for (int j = 1; j < str.length; j += 2) {
				int n = Integer.parseInt(str[j]);
				if (n == -1)
					break;

				int val = Integer.parseInt(str[j + 1]);

				tree.get(v).add(new Edge(n, val));
			}
		}

		bfs(1);
		
		int max = 1;
		for (int i = 2; i <= V; i++) {
			if(distance[max] < distance[i]) {
				max = i;
			}
		}
		
		visited = new boolean[V + 1];
		distance = new int[V + 1];
		bfs(max);
		
		Arrays.sort(distance);
		System.out.println(distance[V]);

	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (Edge edge : tree.get(node)) {
				int n = edge.node;
				int v = edge.value;

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					distance[n] = distance[node] + v;
				}
			}
		}

	}

}
