import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 0) {
			System.out.println(1);
			return;
		}
		long ans = 1;
		for (int i = 1; i <= N; i++) {
			ans *= i;
		}

		System.out.println(ans);
	}

}