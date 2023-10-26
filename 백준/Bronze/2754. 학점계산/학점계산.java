import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String score = br.readLine();
		double grade = 0;

		switch (score.charAt(0)) {
		case 'A':
			grade = 4;
			break;
		case 'B':
			grade = 3;
			break;
		case 'C':
			grade = 2;
			break;
		case 'D':
			grade = 1;
			break;
		default:
			grade = 0;
		}

		if (grade == 0) {
			System.out.println(grade);
			return;
		}

		if (score.charAt(1) == '+') {
			grade += 0.3;
		} else if (score.charAt(1) == '-') {
			grade -= 0.3;
		}
		
		System.out.println(grade);

	}

}