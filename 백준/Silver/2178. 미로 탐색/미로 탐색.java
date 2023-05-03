
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	static int[][] A;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(A[N - 1][M - 1]);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int node[] = queue.poll();
			visit[i][j] = true;

			for (int k = 0; k < 4; k++) {
				int x = node[0] + dx[k];
				int y = node[1] + dy[k];

				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (A[x][y] != 0 && !visit[x][y]) {
						visit[x][y] = true;
						A[x][y] = A[node[0]][node[1]] + 1;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}

}
