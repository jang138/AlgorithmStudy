import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("");
		String t = br.readLine();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]);
//            System.out.println(sb);
			if (sb.length() >= t.length()) {
				if (sb.substring(sb.length() - t.length(), sb.length()).equals(t)) {
					sb.delete(sb.length() - t.length(), sb.length());
//                    System.out.println(sb);
				}
			} else {
				continue;
			}
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}