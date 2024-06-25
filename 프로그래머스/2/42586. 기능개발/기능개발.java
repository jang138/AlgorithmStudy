import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int l = progresses.length;
		ArrayList<Integer> al = new ArrayList<>();
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < l; i++) {
			int work = 100 - progresses[i];
			int day = (work % speeds[i] == 0) ? work / speeds[i] : work / speeds[i] + 1;

			if (deque.isEmpty()) {
				deque.addLast(day);
				continue;
			}

			if (deque.peekLast() > day) {
				deque.addLast(deque.peekLast());
			} else {
				deque.addLast(day);
			}
		}

		int preTarget = 0;
		while (!deque.isEmpty()) {
			int target = deque.poll();
			if (target != preTarget) {
				al.add(1);
			} else {
				int index = al.size() - 1;
				int get = al.get(index);
				al.set(index, get + 1);
			}
			preTarget = target;
		}

		int[] answer = new int[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}
		return answer;
    }
}