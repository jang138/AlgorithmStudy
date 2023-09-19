

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result;
	static int[][] arr, visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < m + 1; j++) {
				int value = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
				arr[i][j] = value;
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		result = getRoute(1, 1);
		System.out.println(result);
	}

	private static int getRoute(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 1, 0));
		visit[x][y] = 0;

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			if (point.x == n && point.y == m) {
				return point.count;
			}

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				if (nx > 0 && ny > 0 && nx < n + 1 && ny < m + 1) {
					if (visit[nx][ny] > point.crash) {
						if (arr[nx][ny] == 0) {
							queue.offer(new Point(nx, ny, point.count + 1, point.crash));
							visit[nx][ny] = point.crash;
						} else {
							if (point.crash == 0) {
								queue.offer(new Point(nx, ny, point.count + 1, point.crash + 1));
								visit[nx][ny] = point.crash + 1;
							}
						}
					}
				}
			}
		}
		return -1;
	}

	static class Point {
		int x, y, count, crash;

		public Point(int x, int y, int count, int crash) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.crash = crash;
		}
	}
}