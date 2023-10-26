import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			String target = br.readLine();
			sb.append(target.charAt(0)).append(target.charAt(target.length() - 1)).append("\n");
		}
		
		System.out.println(sb);

	}

}