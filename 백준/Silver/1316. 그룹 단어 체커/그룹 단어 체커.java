import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int count = 0;

		Loop: for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String inputStr = st.nextToken();

			int[] alphabet = new int[26];

			char currentChar = 0;
			for (int j = 0; j < inputStr.length(); j++) {
				char c = inputStr.charAt(j);
				int charIndex = c - 97;
				
				if (alphabet[charIndex] == 0 || c == currentChar) {
					alphabet[charIndex]++;
					currentChar = c;
				} else {
					continue Loop;
				}
			}

			count++;
		}

		System.out.println(count);
	}
}
