import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int index = -1;

		for (int i = 1; i <= 9; i++) {
			int target = Integer.parseInt(br.readLine());
			if (target > max) {
				max = target;
				index = i;
			}
		}
		
		System.out.println(max);
		System.out.println(index);

	}

}