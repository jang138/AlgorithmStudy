
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 1;
		int left = 1;
		int right = 1;
		int sum = 1;

		while (right != N) {
			if (sum == N) {
				cnt++;
				right++;
				sum += right;
			} else if (sum > N) {
				sum -= left;
				left++;
			} else {
				right++;
				sum += right;
			}
		}
		
		System.out.println(cnt);
	}

}
