import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int lvalue[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];

		int maxHigh = Integer.MIN_VALUE;
		int minHigh = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				lvalue[i][j] = input;

				maxHigh = Math.max(maxHigh, input);
				minHigh = Math.min(minHigh, input);
			}
		}

		int minSec = Integer.MAX_VALUE;
		int high = 0;

		for (int standardHigh = minHigh; standardHigh <= maxHigh; standardHigh++) {
			int itemB = B;
			int sec = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					int targetHigh = lvalue[i][j];

					if (targetHigh == standardHigh) {
						visited[i][j] = true;
						continue;
					} else if (targetHigh > standardHigh) {
						sec += 2 * (targetHigh - standardHigh);
						itemB += targetHigh - standardHigh;
						visited[i][j] = true;
					}

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						continue;

					int targetHigh = lvalue[i][j];

					if (targetHigh < standardHigh) {
						sec += (standardHigh - targetHigh);
						itemB -= standardHigh - targetHigh;
					}

				}
			}

			for (boolean[] b : visited) {
				Arrays.fill(b, false);
			}

			if (itemB < 0)
				break;


			if (minSec >= sec) {
				minSec = sec;
				high = standardHigh;
			}
		}


		System.out.println(minSec + " " + high);

	}

}
