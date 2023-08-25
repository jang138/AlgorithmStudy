import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, num = 1, min = Integer.MAX_VALUE, now;
	static int[][] map;
	static int[][] distArr;
	static boolean[][] edge;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		edge = new boolean[N][N];
		distArr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				
				if (in == 0) {
					distArr[i][j] = -1;
				} else {
					distArr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					num++;
					dfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (edge[i][j]) {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					if (map[i][j] != map[nx][ny]) {
						min = Math.min(min, distArr[nx][ny] + distArr[i][j]);
					}

				}
			}
		}

		System.out.println(min);

	}

	private static void dfs(int x, int y) {
		map[x][y] = num;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}

			if (map[nx][ny] == 0) {
				edge[x][y] = true;
			}

			if (map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}

	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] target = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = target[0] + dx[d];
				int ny = target[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || distArr[nx][ny] == 0) {
					continue;
				}

				if (distArr[nx][ny] == -1) {
					distArr[nx][ny] = target[2] + 1;
					map[nx][ny] = map[target[0]][target[1]];

					queue.add(new int[] { nx, ny, target[2] + 1 });
				}

			}

		}
	}

}
