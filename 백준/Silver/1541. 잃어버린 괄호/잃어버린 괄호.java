import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		int sum = 0;
		int cnt = 0;

		while (st.hasMoreTokens()) {
			int temp = 0;

			StringTokenizer bracket = new StringTokenizer(st.nextToken(), "+");
			while (bracket.hasMoreTokens()) {
				temp += Integer.parseInt(bracket.nextToken());
			}

			if (cnt > 0)
				sum -= temp;
			else
				sum += temp;

			cnt++;
		}

		System.out.println(sum);
	}

}
