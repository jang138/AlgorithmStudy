import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String number = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += number.charAt(i) - 48;
		}
		System.out.println(sum);
	}

}