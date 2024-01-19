import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] NGE = new int[N];
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i])
				NGE[stack.pop()] = A[i];

			stack.push(i);
		}

		while (!stack.isEmpty())
			NGE[stack.pop()] = -1;

		for (int n : NGE) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}