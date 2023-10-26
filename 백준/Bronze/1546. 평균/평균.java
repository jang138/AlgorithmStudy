import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		double M = -1;
		double sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			double score = Double.parseDouble(st.nextToken());
			sum += score;
			M = Math.max(M, score);
		}

		double answer = sum * 100 / M / N;

		System.out.println(answer);
	}

}
