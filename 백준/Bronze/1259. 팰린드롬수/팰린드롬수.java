import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = "";
		StringBuilder answer = new StringBuilder();

		while (true) {
			number = br.readLine();
			if (number.equals("0")) {
				break;
			}

			StringBuilder palindrome = new StringBuilder();
			palindrome.append(number).reverse();

			if (number.equals(palindrome.toString()))
				answer.append("yes").append("\n");
			else
				answer.append("no").append("\n");
		}

		System.out.println(answer.toString());

	}

}
