import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int C, N;
	static int infection;
	static int A[][];
	static boolean check[];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new int[C + 1][C + 1];
		check = new boolean[C + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			A[a][b] = A[b][a] = 1;

//			System.out.println(a + " " + b);
		}

//		dfs(1);
		bfs(1);

		System.out.println(infection);

	}

	private static void dfs(int n) {

		check[n] = true;

		for (int i = 1; i <= C; i++) {
			if (A[n][i] == 1 && !check[i]) {
				infection++;
				dfs(i);
			}
		}

	}

	private static void bfs(int n) {

		queue.add(n);
		check[n] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= C; i++) {
				if (A[now][i] == 1 && !check[i]) {
					check[i] = true;
					queue.add(i);
					infection++;
				}
			}
		}
	}

}
