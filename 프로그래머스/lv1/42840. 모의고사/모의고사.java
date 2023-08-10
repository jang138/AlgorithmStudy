import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int supoja1[] = { 1, 2, 3, 4, 5 };
		int supoja2[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int supoja3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int count[] = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == supoja1[i % 5])
				count[0]++;
			if (answers[i] == supoja2[i % 8])
				count[1]++;
			if (answers[i] == supoja3[i % 10])
				count[2]++;
		}

		int max = Math.max(count[0], Math.max(count[1], count[2]));

		ArrayList<Integer> arrayList = new ArrayList<>();
		if (max == count[0])
			arrayList.add(1);
		if (max == count[1])
			arrayList.add(2);
		if (max == count[2])
			arrayList.add(3);
		
		int[] answer = new int[arrayList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arrayList.get(i);
		}

		return answer;
    }
}