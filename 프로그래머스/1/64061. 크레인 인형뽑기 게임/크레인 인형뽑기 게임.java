import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int n : moves) {
			int target = n - 1;

			for (int i = 0; i < N; i++) {
				int doll = board[i][target];
				if (doll == 0)
					continue;

				if (!stack.isEmpty() && stack.peek() == doll) {
					stack.pop();
					answer += 2;
					board[i][target] = 0;
					break;
				} else {
					stack.push(doll);
					board[i][target] = 0;
					break;
				}
			}
		}
		return answer;
    }
}