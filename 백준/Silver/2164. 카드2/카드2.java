import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <=N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			// 1. 맨 위 카드를 버린다.
			queue.poll();
			
			// 2. 다음 맨 위 카드는 맨 아래로 넣는다.
			int bottom = queue.poll();
			queue.add(bottom);
		}
		
		System.out.println(queue.poll());
	}

}
