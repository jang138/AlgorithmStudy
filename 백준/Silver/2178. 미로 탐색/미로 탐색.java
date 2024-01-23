import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(map[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				if (map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				map[nx][ny] = map[node[0]][node[1]] + 1;
				queue.add(new int[] { nx, ny });

			}
		}
	}
}
