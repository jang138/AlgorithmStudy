import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		Long ans = (A + B) * (A - B);
		System.out.println(ans);

	}

}
