import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String D = st.nextToken();
		int ans = 0;

		boolean prime[] = new boolean[B + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i <= B; i++) {
			if (!prime[i])
				continue;

			for (int j = 2 * i; j <= B; j += i)
				prime[j] = false;

		}

		
		for (int i = A; i <= B; i++) {
			if(!prime[i])
				continue;
			
			String str = Integer.toString(i);
			if(str.contains(D))
				ans++;
			
		}
		
		System.out.println(ans);
	}

}
