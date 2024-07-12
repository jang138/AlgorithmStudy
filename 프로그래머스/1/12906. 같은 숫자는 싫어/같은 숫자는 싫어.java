import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			if(queue.peekLast() != arr[i])
				queue.addLast(arr[i]);
		}
		
		int[] answer = new int[queue.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = queue.pollFirst();
		}
		
		return answer;
    }
}