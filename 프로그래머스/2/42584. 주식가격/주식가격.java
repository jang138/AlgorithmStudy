import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
		int[] sec = new int[n];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int pop = stack.pop();
				sec[pop] = i - pop;
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int pop = stack.pop();
			sec[pop] = n - pop - 1;
		}

		return sec;
    }
}