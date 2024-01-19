import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}
		
		while(dq.size() > 1) {
			dq.pollFirst();
			
			int goBottom = dq.pollFirst();
			dq.addLast(goBottom);
		}
		
		System.out.println(dq.poll());
	}
}