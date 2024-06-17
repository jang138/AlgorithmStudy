import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] board;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				// 흰색의 경우 true, 검은색의 경우 false
				if (line.charAt(j) == 'W') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}

			}
		}

		int r = N - 7;
		int c = M - 7;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				check(i, j);
			}
		}

		System.out.println(min);
	}

	public static void check(int x, int y) {
		int endx = x + 8;
		int endy = y + 8;
		int count = 0;

		// 체스판의 첫번째 칸
		boolean first = board[x][y];

		for (int i = x; i < endx; i++) {
			for (int j = y; j < endy; j++) {

				if (board[i][j] != first) {
					count++;
				}

				first = !first;
			}

			first = !first;
		}

		// 8 X 8 경우의 수 중에서 맨 앞이 검정인 경우와 하양인 경우를 비교
		count = Math.min(count, 64 - count);

		min = Math.min(min, count);
	}

}
