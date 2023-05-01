
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] A;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			// 양방향 에지
			A[s].add(e);
			A[e].add(s);
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.print(i + " => ");
//			for (int j = 0; j < A[i].size(); j++) {
//				System.out.print(A[i].get(j) + " ");
//			}
//			System.out.println();
//		}

//		for (int i = 1; i <= N; i++) {
//			System.out.print(i + " => ");
//			for (int j : A[i]) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);
	}

	private static void dfs(int v) {
		if (visit[v]) {
			return;
		}

		visit[v] = true;

		for (int i : A[v]) {
			if (visit[i] == false) {
				dfs(i);
			}
		}
	}

}
