import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append(A+B).append("\n");
		sb.append(A-B).append("\n");
		sb.append(A*B).append("\n");
		sb.append(A/B).append("\n");
		sb.append(A%B).append("\n");
		
		System.out.println(sb);
	}

}
