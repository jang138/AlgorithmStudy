import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String command = sc.next();
			switch (command) {
				case "push":
					int X = sc.nextInt();
					stack.add(X);
					break;
	
				case "pop":
					if (!stack.isEmpty()) {
						sb.append(stack.pop()).append("\n");
					}else {
						sb.append(-1).append("\n");
					}
					break;
					
				case "size":
					sb.append(stack.size()).append("\n");
					break;
					
				case "empty":
					if (stack.isEmpty()) {
						sb.append(1).append("\n");
					}else {
						sb.append(0).append("\n");
					}
					break;
					
				case "top":
					if (!stack.isEmpty()) {
						sb.append(stack.peek()).append("\n");
					}else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
