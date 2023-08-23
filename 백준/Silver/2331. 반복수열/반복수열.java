import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();

		ArrayList<Integer> arrayList = new ArrayList<>();

		arrayList.add(A);
		int sum = 0;
		int answer = 0;

		while (true) {
			String num = Integer.toString(arrayList.get(arrayList.size() - 1));
			sum = 0;

			for (int i = 0; i < num.length(); i++) {
				int n = num.charAt(i) - '0';
				sum += Math.pow(n, P);
			}

			if (arrayList.contains(sum)) {
				answer = arrayList.indexOf(sum);
				System.out.println(answer);
				break;
			}

			arrayList.add(sum);

		}
	}

}
