import java.util.*;

class Solution {
    static int N, M;
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
    public int solution(String[] maps) {
        int answer = 0;
		N = maps.length;
		M = maps[0].length();
		map = new char[N][M];

		Node start = null;
		Node lever = null;
		Node end = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = maps[i].charAt(j);

				if (map[i][j] == 'S') {
					start = new Node(i, j);
				} else if (map[i][j] == 'L') {
					lever = new Node(i, j);
				} else if (map[i][j] == 'E') {
					end = new Node(i, j);
				}
			}
		}

		int goToLeverAtStart = bfs(start, lever);
		int goToEndAtLever = bfs(lever, end);

		System.out.println(goToLeverAtStart + " " + goToEndAtLever);

		if (goToLeverAtStart == -1 || goToEndAtLever == -1)
			return -1;
		else
			return goToLeverAtStart + goToEndAtLever;
	}

	private static int bfs(Node start, Node end) {
		int[][] dist = new int[N][M];

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start.x, start.y));
		dist[start.x][start.y] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (dist[nx][ny] != 0)
					continue;

				if (map[nx][ny] == 'X')
					continue;

				dist[nx][ny] = dist[now.x][now.y] + 1;
				queue.add(new Node(nx, ny));

				if (nx == end.x && ny == end.y)
					return dist[end.x][end.y] - 1;
			}

		}

		return -1;
	}
}