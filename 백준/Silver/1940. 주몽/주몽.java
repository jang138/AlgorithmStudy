import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int numbers[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

//		System.out.println(Arrays.toString(numbers));

		int start = 0;
		int end = N - 1;
		int sum = 0;
		int cnt = 0;

		while (start < end) {
			sum = numbers[start] + numbers[end];
			
			if(sum < M) {
				start++;
			} else if(sum > M) {
				end--;
			} else {
				cnt++;
				start++;
			}
		}
		
		System.out.println(cnt);
	}

}
