import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(array);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int target = array[i];
			int start = 0;
			int end = N - 1;

			while (start < end) {
				int sum = array[start] + array[end];

				if (target == sum) {
					if (start != i && end != i) {
						ans++;
						break;
					} else if (start == i) {
						start++;
					} else {
						end--;
					}
				} else {
					if (target > sum) {
						start++;
					} else if (target < sum) {
						end--;
					}
				}
			}

		}

		System.out.println(ans);

	}

}
