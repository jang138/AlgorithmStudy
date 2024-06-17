import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] board;
	static int min = 64;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'W') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}

			}
		}

		int N_row = N - 7;
		int M_col = M - 7;

		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}

		System.out.println(min);
	}

	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean first = board[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

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
