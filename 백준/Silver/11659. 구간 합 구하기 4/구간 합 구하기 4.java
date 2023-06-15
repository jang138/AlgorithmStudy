import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		S[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken()) + S[i - 1];
		}

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			System.out.println(S[j] - S[i - 1]);
		}

	}

}
