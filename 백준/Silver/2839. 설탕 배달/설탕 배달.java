import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] bag = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		Arrays.fill(check, true);
		for (int i = 1; i < 3; i++) {
			check[i] = false;
		}

		if (N == 3 || N == 5) {
			System.out.println(1);
			return;
		}

		if (N == 4) {
			System.out.println(-1);
			return;
		}

		bag[3] = 1;
		check[4] = false;
		bag[5] = 1;

		for (int i = 6; i <= N; i++) {
			boolean a = check[i - 3];
			boolean b = check[i - 5];

			if (a && b) {
				bag[i] = Math.min(bag[i - 3], bag[i - 5]) + 1;
			} else if (!a && b) {
				bag[i] = bag[i - 5] + 1;
			} else if (a && !b) {
				bag[i] = bag[i - 3] + 1;
			} else {
				check[i] = false;
			}

		}

		System.out.println(check[N] ? bag[N] : -1);

	}

}
