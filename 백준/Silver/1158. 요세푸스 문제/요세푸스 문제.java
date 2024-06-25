import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		while (deque.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				deque.addLast(deque.pollFirst());
			}

			sb.append(deque.pollFirst()).append(", ");
		}

		sb.append(deque.pollFirst()).append('>');

		System.out.println(sb.toString());
	}

}
