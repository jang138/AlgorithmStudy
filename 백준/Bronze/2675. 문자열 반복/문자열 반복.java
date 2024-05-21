import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			int length = S.length();
			
			for (int i = 0; i < length; i++) {
				char c = S.charAt(i);
				
				for (int j = 0; j < R; j++) {
					sb.append(c);
				}
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb.toString());

	}
}
