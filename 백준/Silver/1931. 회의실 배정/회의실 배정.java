import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, (o1, o2) -> {
			if (o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});

		int count = 0;
		int end = 0;

		for (int i = 0; i < N; i++) {
			if (end <= time[i][0]) {
				end = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}

}
