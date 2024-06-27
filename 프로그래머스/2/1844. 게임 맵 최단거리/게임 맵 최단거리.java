import java.util.*;

class Solution {
	int[] dx = { 1, 0, -1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
    public int solution(int[][] maps) {
        int n = maps.length;
		int m = maps[0].length;
		int[][] dist = new int[n][m];

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0));
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (maps[nx][ny] == 0)
					continue;

				if (dist[nx][ny] == 0) {
					queue.add(new Node(nx, ny));
					dist[nx][ny] = dist[node.x][node.y] + 1;
				}
			}
		}

		if (dist[n - 1][m - 1] == 0) {
			return -1;
		} else {
			return dist[n - 1][m - 1];
		}
    }
}